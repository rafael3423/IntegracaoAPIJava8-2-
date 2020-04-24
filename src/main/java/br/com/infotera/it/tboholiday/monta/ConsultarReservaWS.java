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
import br.com.infotera.common.politica.WSPoliticaCondicaoGeral;
import br.com.infotera.common.reserva.rqrs.WSReservaRQ;
import br.com.infotera.common.reserva.rqrs.WSReservaRS;
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.ChamaWS;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tektravel.hotelbookingapi.APIBookingDetail;
import tektravel.hotelbookingapi.CancelPolicies;
import tektravel.hotelbookingapi.CancellationChargeTypeForHotel;
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

        try {
            for (RoomDetails rd : bookingDetail.getRoomtype().getRoomDetails()) {

                List<WSPolitica> politicaCancelamentoList = new ArrayList();

                String normasHotel = bookingDetail.getHotelPolicyDetails() + "; " + bookingDetail.getHotelCancelPolicies().getDefaultPolicy();

                if (normasHotel != null && !normasHotel.equals("")) {
                    politicaCancelamentoList.add(new WSPoliticaCondicaoGeral("Condição geral", normasHotel));
                }

                Double diferencaEmDias = Double.parseDouble(Utils.diferencaEmDias(Utils.toDate(bookingDetail.getCheckInDate().toString(), "yyyy-MM-dd"), Utils.toDate(bookingDetail.getCheckOutDate().toString(), "yyyy-MM-dd")).toString());

                Double vlDiaria = Utils.dividir(rd.getRoomRate().getTotalFare().doubleValue(), diferencaEmDias);

                if (bookingDetail.getHotelCancelPolicies() != null) {
                    politicaCancelamentoList.addAll(montaPoliticaCancelamento(bookingDetail.getHotelCancelPolicies(), vlDiaria, rd.getRoomRate().getTotalFare().doubleValue(), integrador));
                }

                sqQuarto++;

                List<WSTarifaAdicional> tarifaAdicionalList = new ArrayList();
                Double vlMulta = 0.0;
                String sgMoedaCancelamento = null;
                try {
                    for (WSPolitica politica : politicaCancelamentoList) {
                        if (politica.getPoliticaTipo().isCancelamento()) {
                            if ((politica.getPoliticaCancelamento().isStNaoReembolsavel()) || (new Date().compareTo(politica.getPoliticaCancelamento().getDtMinCancelamento()) == 1)) {
                                if (politica.getPoliticaCancelamento().getDtMaxCancelamento() != null) {
                                    if (new Date().compareTo(politica.getPoliticaCancelamento().getDtMinCancelamento()) == 1 && new Date().compareTo(politica.getPoliticaCancelamento().getDtMaxCancelamento()) == -1) {
                                        vlMulta = politica.getPoliticaCancelamento().getVlCancelamento();
                                        sgMoedaCancelamento = politica.getPoliticaCancelamento().getSgMoeda();
                                    }
                                } else {
                                    vlMulta = politica.getPoliticaCancelamento().getVlCancelamento();
                                    sgMoedaCancelamento = politica.getPoliticaCancelamento().getSgMoeda();
                                }
                            }
                        }
                    }

                    if (vlMulta != 0.0 && isCancelamento) {
                        tarifaAdicionalList.add(new WSTarifaAdicional(WSTarifaAdicionalTipoEnum.MULTA, "Multa de cancelamento", sgMoedaCancelamento, vlMulta));
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
                    rd.getGuestInfo().getGuest().forEach((g) -> {
                        WSPaxTipoEnum paxTipoEnum = null;

                        if (g.getGuestType().toString().toUpperCase().equals("ADULT")) {
                            paxTipoEnum = WSPaxTipoEnum.ADT;
                        } else if (g.getGuestType().toString().toUpperCase().equals("CHILD")) {
                            paxTipoEnum = WSPaxTipoEnum.CHD;
                        }

                        reservaNomeList.add(new WSReservaNome(g.getFirstName(),
                                g.getLastName(),
                                paxTipoEnum,
                                null,
                                g.getAge(),
                                null));
                    });
                } catch (Exception ex) {
                    throw new ErrorException(integrador, ConsultarReservaWS.class, "montaReserva", WSMensagemErroEnum.HCO, "Ocorreu uma falha ao efetuar a consulta da reserva", WSIntegracaoStatusEnum.INCONSISTENTE, ex);
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
            throw new ErrorException(integrador, ConsultarReservaWS.class, "montareserva", WSMensagemErroEnum.HCO, "Ocorreu uma falha ao efetuar a consulta da reserva", WSIntegracaoStatusEnum.INCONSISTENTE, ex);
        }

        WSReservaStatusEnum reservaStatusEnum = null;

        switch (bookingDetail.getBookingStatus().toString().toUpperCase()) {
            case "CONFIRMED":
                reservaStatusEnum = WSReservaStatusEnum.CONFIRMADO;
                break;
            case "REJECTED":
                reservaStatusEnum = WSReservaStatusEnum.NEGADO;
                break;
            case "CANCELLED":
                reservaStatusEnum = WSReservaStatusEnum.CANCELADO;
                break;
            case "PENDING":
            case "FAILED":
            case "CANCELLATION_IN_PROGRESS":
            case "VOUCHERED":
                reservaStatusEnum = WSReservaStatusEnum.INCONSISTENTE;
                break;
            default:
                reservaStatusEnum = WSReservaStatusEnum.INCONSISTENTE;
                break;
        }

        if (reservaStatusEnum.equals(WSReservaStatusEnum.INCONSISTENTE)) {
            throw new ErrorException(integrador, ConsultarReservaWS.class, "montareserva", WSMensagemErroEnum.HCO, "Erro ao consultar a reserva, status: " + bookingDetail.getBookingStatus().toString(), WSIntegracaoStatusEnum.INCONSISTENTE, null);
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

        WSHotel hotel = new WSHotel(bookingDetail.getTBOHotelCode(),
                bookingDetail.getHotelName(),
                null,
                hotelCategoria,
                null,
                null,
                endereco,
                null,
                null);

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

    private List<WSPolitica> montaPoliticaCancelamento(CancelPolicies cancelPolicies, Double vlDiaria, Double vlTotal, WSIntegrador integrador) throws ErrorException {

        List<WSPolitica> politicaList = new ArrayList();

        if (cancelPolicies != null && cancelPolicies.getCancelPolicy() != null) {
            try {
                cancelPolicies.getCancelPolicy().forEach((cp) -> {

                    Double pcCancelamento = null;
                    Double vlCancelamento = null;

                    if (cp.getChargeType() != null && cp.getChargeType().equals(CancellationChargeTypeForHotel.PERCENTAGE)) {
                        if (cp.getCancellationCharge() != null && cp.getCancellationCharge().doubleValue() > 0.0) {
                            pcCancelamento = cp.getCancellationCharge().doubleValue();

                            vlCancelamento = Utils.dividir(Utils.multiplicar(vlTotal, pcCancelamento), 100.00);

                        }
                    } else if (cp.getChargeType() != null && cp.getChargeType().equals(CancellationChargeTypeForHotel.FIXED)) {
                        if (cp.getCancellationCharge() != null && cp.getCancellationCharge().doubleValue() > 0.0) {
                            vlCancelamento = cp.getCancellationCharge().doubleValue();
                        }
                    } else if (cp.getChargeType() != null && cp.getChargeType().equals(CancellationChargeTypeForHotel.NIGHT)) {
                        if (cp.getCancellationCharge() != null && cp.getCancellationCharge().doubleValue() > 0.0) {
                            vlCancelamento = Utils.multiplicar(vlDiaria, cp.getCancellationCharge().doubleValue());
                        }
                    }

                    if (pcCancelamento != null || vlCancelamento != null) {
                        Date dtMinCancelamento = Utils.addDias(Utils.toDate(cp.getFromDate(), "yyyy-MM-dd"), -3);
                        Date dtMaxCancelamento = Utils.toDate(cp.getToDate(), "yyyy-MM-dd");
                        boolean stImediata = false;

                        if (dtMinCancelamento.before(new Date())) {
                            stImediata = true;
                        }

                        politicaList.add(new WSPoliticaCancelamento("Politica de cancelamento",
                                "",
                                cp.getCurrency(),
                                vlCancelamento,
                                pcCancelamento,
                                null,
                                stImediata,
                                dtMinCancelamento,
                                dtMaxCancelamento,
                                false));
                    }
                });
            } catch (Exception ex) {
                throw new ErrorException(integrador, ConsultarReservaWS.class, "montaPoliticaCancelamento", WSMensagemErroEnum.HCO, "Ocorreu uma falha ao montar politica de cancelamento.", WSIntegracaoStatusEnum.INCONSISTENTE, ex);
            }
        }

        return politicaList;
    }
}
