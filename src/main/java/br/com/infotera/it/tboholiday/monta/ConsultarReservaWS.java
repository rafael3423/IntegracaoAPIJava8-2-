package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSIntegrador;
import br.com.infotera.common.WSReserva;
import br.com.infotera.common.WSReservaHotel;
import br.com.infotera.common.WSReservaHotelUh;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.WSTarifa;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSPaxTipoEnum;
import br.com.infotera.common.enumerator.WSReservaStatusEnum;
import br.com.infotera.common.hotel.WSRegime;
import br.com.infotera.common.hotel.WSUh;
import br.com.infotera.common.politica.WSPolitica;
import br.com.infotera.common.politica.WSPoliticaCancelamento;
import br.com.infotera.common.reserva.rqrs.WSReservaRQ;
import br.com.infotera.common.reserva.rqrs.WSReservaRS;
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.ChamaWS;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tektravel.hotelbookingapi.APIBookingDetail;
import tektravel.hotelbookingapi.ArrayOfRoomDetails;
import tektravel.hotelbookingapi.Guest;
import tektravel.hotelbookingapi.HotelBookingDetailRequest;
import tektravel.hotelbookingapi.HotelBookingDetailResponse;
import tektravel.hotelbookingapi.RoomDetails;

public class ConsultarReservaWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSReservaRS consultar(WSReservaRQ reservaRQ) throws ErrorException {

        HotelBookingDetailRequest hotelBookingDetailRequest = new HotelBookingDetailRequest();

        hotelBookingDetailRequest.setBookingId(Integer.parseInt(reservaRQ.getReserva().getReservaHotel().getNrLocalizador()));

        HotelBookingDetailResponse hotelBookingDetailResponse = chamaWS.chamadaPadrao(reservaRQ.getIntegrador(), hotelBookingDetailRequest, HotelBookingDetailResponse.class);

        WSReserva reserva = montaReserva(reservaRQ.getIntegrador(), hotelBookingDetailResponse.getBookingDetail());
        reserva.getReservaHotel().setNrLocalizador(reservaRQ.getReserva().getReservaHotel().getNrLocalizador());

        return new WSReservaRS(reserva, reservaRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);
    }

    public WSReserva montaReserva(WSIntegrador integrador, APIBookingDetail bookingDetail) {

        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();
        int sqQuarto = 0;

        for (RoomDetails rd : bookingDetail.getRoomtype().getRoomDetails()) {

            List<WSPolitica> politicaCancelamentoList = new ArrayList();

            Double vlCancelamento = 0.0;

            String chvDiaCheckIn[] = bookingDetail.getCheckInDate().toString().split("-");
            String chvDiaCheckOut[] = bookingDetail.getCheckOutDate().toString().split("-");

            Double qntDia = Utils.subtrair(Double.parseDouble(chvDiaCheckOut[2]), Double.parseDouble(chvDiaCheckIn[2]));
            Double vlDiaria = Utils.dividir(Double.parseDouble(rd.getRoomRate().getTotalFare().toString()), qntDia);

            vlCancelamento = Utils.multiplicar(vlDiaria, Double.parseDouble(bookingDetail.getHotelCancelPolicies().getCancelPolicy().get(sqQuarto).getCancellationCharge().toString()));

            if (bookingDetail.getHotelCancelPolicies().getCancelPolicy().get(sqQuarto).getChargeType().toString().toUpperCase().equals("FIXED")) {
                vlCancelamento = Double.parseDouble(bookingDetail.getHotelCancelPolicies().getCancelPolicy().get(sqQuarto).getCancellationCharge().toString());

            } else if (bookingDetail.getHotelCancelPolicies().getCancelPolicy().get(sqQuarto).getChargeType().toString().toUpperCase().equals("PERCENTAGE")) {
                vlCancelamento = Utils.dividir(Utils.multiplicar(Double.parseDouble(rd.getRoomRate().getTotalFare().toString()), Double.parseDouble(bookingDetail.getHotelCancelPolicies().getCancelPolicy().get(sqQuarto).getCancellationCharge().toString())), 100.00);

            } else if (bookingDetail.getHotelCancelPolicies().getCancelPolicy().get(sqQuarto).getChargeType().toString().toUpperCase().equals("NIGHT")) {

            }

            Boolean stNaoRefundable = false;
            if (vlCancelamento == Double.parseDouble(rd.getRoomRate().getTotalFare().toString())) {
                stNaoRefundable = true;

            } else if (vlCancelamento < Double.parseDouble(rd.getRoomRate().getTotalFare().toString())) {
                stNaoRefundable = false;
            }

            Date dtMaximaCancelamento = Utils.addDias(Utils.toDate(bookingDetail.getHotelCancelPolicies().getCancelPolicy().get(sqQuarto).getToDate(), "yyyy-MM-dd"), -3);

            boolean stImediata = false; //Inicia Multa em normalmente falso

            if (new Date().compareTo(dtMaximaCancelamento) == 1) { //Compara se o dia de hoje passou a data máxima de ccanelmento
                stImediata = true;  // entra em multa
            }

            if (stNaoRefundable == true) { // checa se o conector tem prazo de cancelamento
                stImediata = true; // entra em multa
            }

            politicaCancelamentoList.add(new WSPoliticaCancelamento(bookingDetail.getHotelCancelPolicies().getCancelPolicy().get(sqQuarto).getRoomTypeName(),
                    bookingDetail.getHotelCancelPolicies().getDefaultPolicy(),
                    bookingDetail.getHotelCancelPolicies().getCancelPolicy().get(sqQuarto).getCurrency(),
                    vlCancelamento,
                    null,
                    null,
                    stImediata,
                    Utils.toDate(bookingDetail.getHotelCancelPolicies().getCancelPolicy().get(sqQuarto).getFromDate(), "yyyy-MM-dd"),
                    Utils.toDate(bookingDetail.getHotelCancelPolicies().getCancelPolicy().get(sqQuarto).getToDate(), "yyyy-MM-dd"),
                    stNaoRefundable));

            politicaCancelamentoList.get(0).setDsPolitica(bookingDetail.getHotelPolicyDetails());

            WSTarifa tarifa = new WSTarifa(rd.getRoomRate().getCurrency(),
                    Double.parseDouble(rd.getRoomRate().getTotalFare().toString()),
                    null,
                    null,
                    null,
                    politicaCancelamentoList);

            WSUh uh = new WSUh(null,
                    rd.getRoomName(),
                    rd.getRoomName(),
                    bookingDetail.getRating().toString(),
                    null);

            WSRegime regime = new WSRegime(rd.getAmeneties().get(0),
                    null,
                    rd.getAmeneties().get(0));

            List<WSReservaNome> reservaNomeList = new ArrayList();

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

            WSReservaStatusEnum reservaStatusEnum = null;

            if (bookingDetail.getBookingStatus().toString().toUpperCase().equals("CONFIRMED")) {
                reservaStatusEnum = reservaStatusEnum.CONFIRMADO;

            } else if (bookingDetail.getBookingStatus().toString().toUpperCase().equals("REJECTED")) {
                reservaStatusEnum = reservaStatusEnum.NEGADO;

            } else if (bookingDetail.getBookingStatus().toString().toUpperCase().equals("CANCELLED")) {
                reservaStatusEnum = reservaStatusEnum.CANCELADO;

            } else if (bookingDetail.getBookingStatus().toString().toUpperCase().equals("PENDING")) {
                reservaStatusEnum = reservaStatusEnum.INCONSISTENTE;
                
            } else if (bookingDetail.getBookingStatus().toString().toUpperCase().equals("FAILED")) {
                reservaStatusEnum = reservaStatusEnum.INCONSISTENTE;
                
            } else if (bookingDetail.getBookingStatus().toString().toUpperCase().equals("CANCELLATIONINPROGRESS")) {
                reservaStatusEnum = reservaStatusEnum.INCONSISTENTE;
                
            } else if (bookingDetail.getBookingStatus().toString().toUpperCase().equals("VOUCHERED")) {
                reservaStatusEnum = reservaStatusEnum.INCONSISTENTE;
            }

            sqQuarto++;

            reservaHotelUhList.add(new WSReservaHotelUh(sqQuarto,
                    uh,
                    regime,
                    tarifa,
                    Utils.toDate(bookingDetail.getCheckInDate().toString(), "yyyy-MM-dd"),
                    Utils.toDate(bookingDetail.getCheckOutDate().toString(), "yyyy-MM-dd"),
                    reservaNomeList,
                    reservaStatusEnum));
        }

        WSReservaHotel reservaHotel = new WSReservaHotel(reservaHotelUhList);

        return new WSReserva(reservaHotel);
    }
}
