package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSEndereco;
import br.com.infotera.common.WSIntegrador;
import br.com.infotera.common.WSReserva;
import br.com.infotera.common.WSReservaHotel;
import br.com.infotera.common.WSReservaHotelUh;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.WSTarifa;
import br.com.infotera.common.WSTarifaAdicional;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSMensagemErroEnum;
import br.com.infotera.common.enumerator.WSPaxTipoEnum;
import br.com.infotera.common.enumerator.WSReservaStatusEnum;
import br.com.infotera.common.enumerator.WSTarifaAdicionalTipoEnum;
import br.com.infotera.common.hotel.WSHotel;
import br.com.infotera.common.hotel.WSHotelCategoria;
import br.com.infotera.common.hotel.WSRegime;
import br.com.infotera.common.hotel.WSUh;
import br.com.infotera.common.politica.WSPolitica;
import br.com.infotera.common.politica.WSPoliticaCancelamento;
import br.com.infotera.common.reserva.rqrs.WSReservaRQ;
import br.com.infotera.common.reserva.rqrs.WSReservaRS;
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.ChamaWS;
import br.com.infotera.it.tboholiday.ParDisp;
import br.com.infotera.it.tboholiday.UtilsWS;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tektravel.hotelbookingapi.APIBookingDetail;
import tektravel.hotelbookingapi.CancelPolicy;
import tektravel.hotelbookingapi.Guest;
import tektravel.hotelbookingapi.HotelBookingDetailRequest;
import tektravel.hotelbookingapi.HotelBookingDetailResponse;
import tektravel.hotelbookingapi.RoomDetails;

public class ConsultarReservaWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSReservaRS consultar(WSReservaRQ reservaRQ, Boolean isCancelamento) throws ErrorException {

        HotelBookingDetailRequest hotelBookingDetailRequest = new HotelBookingDetailRequest();

        hotelBookingDetailRequest.setBookingId(Integer.parseInt(reservaRQ.getReserva().getReservaHotel().getNrLocalizador()));

        HotelBookingDetailResponse hotelBookingDetailResponse = chamaWS.chamadaPadrao(reservaRQ.getIntegrador(), hotelBookingDetailRequest, HotelBookingDetailResponse.class);

        WSReserva reserva = montaReserva(reservaRQ.getIntegrador(), hotelBookingDetailResponse.getBookingDetail(), isCancelamento);
        reserva.getReservaHotel().setNrLocalizador(reservaRQ.getReserva().getReservaHotel().getNrLocalizador());

        return new WSReservaRS(reserva, reservaRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);

    }

    public WSReserva montaReserva(WSIntegrador integrador, APIBookingDetail bookingDetail, Boolean isCancelamento) throws ErrorException {

        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();
        int sqQuarto = 0;
        UtilsWS utilsWS = new UtilsWS();

        Double vlTotalTodosQuartos = 0.0;
        String vlTotalCadaQuarto = "";

        for (RoomDetails rd : bookingDetail.getRoomtype().getRoomDetails()) {

            vlTotalCadaQuarto += rd.getRoomRate().getTotalFare().toString() + "#";
            vlTotalTodosQuartos += Double.parseDouble(rd.getRoomRate().getTotalFare().toString());
        }

        try {
            for (RoomDetails rd : bookingDetail.getRoomtype().getRoomDetails()) {

                List<WSPolitica> politicaCancelamentoList = new ArrayList();

                String normasHotel = bookingDetail.getHotelPolicyDetails() + "; " + bookingDetail.getHotelCancelPolicies().getDefaultPolicy();

                String vlTotal = vlTotalTodosQuartos + "#" + vlTotalCadaQuarto;
                Double diferencaEmDias = Double.parseDouble(Utils.diferencaEmDias(Utils.toDate(bookingDetail.getCheckInDate().toString(), "yyyy-MM-dd"), Utils.toDate(bookingDetail.getCheckOutDate().toString(), "yyyy-MM-dd")).toString());

                if (bookingDetail.getHotelCancelPolicies() != null && !bookingDetail.getHotelCancelPolicies().equals("") && sqQuarto == 0) {
                    politicaCancelamentoList = utilsWS.montaPolitica(integrador,
                            bookingDetail.getHotelCancelPolicies(),
                            vlTotal,
                            diferencaEmDias,
                            normasHotel);
                }

                sqQuarto++;

                List<WSTarifaAdicional> tarifaAdicionalList = new ArrayList();
                Double vlMulta = 0.0;

                try {
                    for (WSPolitica politica : politicaCancelamentoList) {
                        if (politica.getPoliticaTipo().isCancelamento()) {
                            if ((politica.getPoliticaCancelamento().isStNaoReembolsavel()) || (new Date().compareTo(politica.getPoliticaCancelamento().getDtMinCancelamento()) == 1)) {
                                if (politica.getPoliticaCancelamento().getDtMaxCancelamento() != null) {
                                    if (new Date().compareTo(politica.getPoliticaCancelamento().getDtMinCancelamento()) == 1 && new Date().compareTo(politica.getPoliticaCancelamento().getDtMaxCancelamento()) == -1) {
                                        vlMulta = politica.getPoliticaCancelamento().getVlCancelamento();
                                    }
                                } else {
                                    vlMulta = politica.getPoliticaCancelamento().getVlCancelamento();
                                }
                            }
                        }
                    }

                    if (vlMulta != 0.0 && isCancelamento) {
                        tarifaAdicionalList.add(new WSTarifaAdicional(WSTarifaAdicionalTipoEnum.MULTA, "Multa de cancelamento", bookingDetail.getHotelCancelPolicies().getCancelPolicy().get(sqQuarto).getCurrency(), vlMulta));
                    }
                } catch (Exception ex) {
                    throw new ErrorException(integrador, ConsultarReservaWS.class, "montareserva", WSMensagemErroEnum.HCO, "Erro ao montar a tarifa de cancelamento", WSIntegracaoStatusEnum.INCONSISTENTE, ex);
                }

                tarifaAdicionalList.add(new WSTarifaAdicional(WSTarifaAdicionalTipoEnum.TAXA_SERVICO,
                        "Taxa de serviço.",
                        rd.getRoomRate().getCurrency(),
                        Double.parseDouble(rd.getRoomRate().getRoomTax().toString())));

                WSTarifa tarifa = new WSTarifa(rd.getRoomRate().getCurrency(),
                        Double.parseDouble(rd.getRoomRate().getRoomFare().toString()),
                        null,
                        null,
                        null,
                        politicaCancelamentoList,
                        tarifaAdicionalList);

                WSUh uh = new WSUh(null,
                        rd.getRoomName(),
                        rd.getRoomName(),
                        bookingDetail.getRating().toString(),
                        null);

                WSRegime regime = new WSRegime(rd.getMealType(),
                        null,
                        rd.getMealType());

                List<WSReservaNome> reservaNomeList = new ArrayList();
                try {
                    for (Guest g : rd.getGuestInfo().getGuest()) {

                        WSPaxTipoEnum paxTipoEnum = null;

                        if (g.getGuestType().toString().toString().toUpperCase().equals("ADULT")) {
                            paxTipoEnum = paxTipoEnum.ADT;
                        } else if (g.getGuestType().toString().toString().toUpperCase().equals("CHILD")) {
                            paxTipoEnum = paxTipoEnum.CHD;
                        }

                        reservaNomeList.add(new WSReservaNome(g.getFirstName(),
                                g.getLastName(),
                                paxTipoEnum,
                                null,
                                g.getAge(),
                                null));
                    }
                } catch (Exception ex) {
                    throw new ErrorException(integrador, ConsultarReservaWS.class, "montaReserva", WSMensagemErroEnum.HCO, "Ocorreu uma falha ao efetuar a consulta da reserva", WSIntegracaoStatusEnum.NEGADO, ex);
                }

                reservaHotelUhList.add(new WSReservaHotelUh(sqQuarto,
                        uh,
                        regime,
                        tarifa,
                        Utils.toDate(bookingDetail.getCheckInDate().toString(), "yyyy-MM-dd"),
                        Utils.toDate(bookingDetail.getCheckOutDate().toString(), "yyyy-MM-dd"),
                        reservaNomeList,
                        null));

            }
        } catch (Exception ex) {
            throw new ErrorException(integrador, ConsultarReservaWS.class, "montareserva", WSMensagemErroEnum.HCO, "Ocorreu uma falha ao efetuar a consulta da reserva", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        WSReservaStatusEnum reservaStatusEnum = null;

        switch (bookingDetail.getBookingStatus().toString().toUpperCase()) {
            case "CONFIRMED":
                reservaStatusEnum = reservaStatusEnum.CONFIRMADO;
                break;
            case "REJECTED":
                reservaStatusEnum = reservaStatusEnum.NEGADO;
                break;
            case "CANCELLED":
                reservaStatusEnum = reservaStatusEnum.CANCELADO;
                break;
            case "PENDING":
                reservaStatusEnum = reservaStatusEnum.INCONSISTENTE;
                break;
            case "FAILED":
                reservaStatusEnum = reservaStatusEnum.INCONSISTENTE;
                break;
            case "CANCELLATION_IN_PROGRESS":
                reservaStatusEnum = reservaStatusEnum.INCONSISTENTE;
                break;
            case "VOUCHERED":
                reservaStatusEnum = reservaStatusEnum.INCONSISTENTE;
                break;
            default:
                break;
        }

        String chvMap[] = bookingDetail.getMap().split("\\|");

        WSEndereco endereco = new WSEndereco(bookingDetail.getAddressLine1(),
                "",
                "",
                "",
                "",
                "",
                chvMap[0],
                chvMap[1]);

        WSHotelCategoria hotelCategoria = new WSHotelCategoria(null, bookingDetail.getRating().toString());

        WSHotel hotel = new WSHotel("",
                bookingDetail.getHotelName(),
                null,
                hotelCategoria,
                null,
                null,
                endereco,
                null,
                null);

        hotel.setId(Integer.parseInt(bookingDetail.getTBOHotelCode()));

        WSReservaHotel reservaHotel = new WSReservaHotel(Utils.toDate(bookingDetail.getBookingDate().toString(), "yyyy-MM-dd"),
                null,
                bookingDetail.getBookingId() + "",
                hotel,
                reservaHotelUhList,
                null,
                null,
                reservaStatusEnum,
                null,
                null);

        return new WSReserva(reservaHotel);
    }
}
