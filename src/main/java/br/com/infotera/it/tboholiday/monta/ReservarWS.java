package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSReserva;
import br.com.infotera.common.WSReservaHotel;
import br.com.infotera.common.WSReservaHotelUh;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.WSTarifa;
import br.com.infotera.common.WSTarifaAdicional;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSReservaStatusEnum;
import br.com.infotera.common.hotel.WSUh;
import br.com.infotera.common.politica.WSPolitica;
import br.com.infotera.common.reserva.rqrs.WSReservaRQ;
import br.com.infotera.common.reserva.rqrs.WSReservaRS;
import br.com.infotera.common.reserva.rqrs.WSReservarRQ;
import br.com.infotera.common.reserva.rqrs.WSReservarRS;
import br.com.infotera.it.tboholiday.ChamaWS;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import tektravel.hotelbookingapi.ArrayOfGuest;
import tektravel.hotelbookingapi.ArrayOfRequestedRooms;
import tektravel.hotelbookingapi.Guest;
import tektravel.hotelbookingapi.GuestType;
import tektravel.hotelbookingapi.HotelBookRequest;
import tektravel.hotelbookingapi.HotelBookResponse;
import tektravel.hotelbookingapi.PaymentInfo;
import tektravel.hotelbookingapi.PaymentModeType;
import tektravel.hotelbookingapi.Rate;
import tektravel.hotelbookingapi.RequestedRooms;

public class ReservarWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSReservarRS reservar(WSReservarRQ reservarRQ) throws ErrorException {

        HotelBookRequest hotelBookRequest = new HotelBookRequest();
        int sqQuato = 0;

        for (WSReservaHotelUh rhuh : reservarRQ.getReserva().getReservaHotel().getReservaHotelUhList()) {

            Boolean leadGuest = true;
            sqQuato++;
            ArrayOfGuest arrayOfGuest = new ArrayOfGuest();

            for (WSReservaNome rn : rhuh.getReservaNomeList()) {

                Guest guest = new Guest();
                GuestType guestType = null;

                if (rn.getPaxTipo().isAdt() || rn.getPaxTipo().isSrn()) {
                    guestType = guestType.ADULT;
                } else if (rn.getPaxTipo().isChd() || rn.getPaxTipo().isInf()) {
                    guestType = guestType.CHILD;
                }

                guest.setLeadGuest(leadGuest);
                leadGuest = false;
                guest.setGuestType(guestType);
                guest.setGuestInRoom(sqQuato);
                guest.setFirstName(rn.getNmNome());
                guest.setLastName(rn.getNmSobrenome());
                guest.setAge(rn.getQtIdade());

                arrayOfGuest.getGuest().add(guest);
            }

            PaymentInfo paymentInfo = new PaymentInfo();

            paymentInfo.setVoucherBooking(true);
            paymentInfo.setPaymentModeType(PaymentModeType.LIMIT);

            ArrayOfRequestedRooms arrayOfRequestedRooms = new ArrayOfRequestedRooms();
            RequestedRooms requestedRooms = new RequestedRooms();

            Double vlTarifa = 0.0;
            for (WSTarifaAdicional ta : rhuh.getTarifa().getTarifaAdicionalList()) {
                vlTarifa = vlTarifa + ta.getVlNeto();
            }

            BigDecimal bigFare = new BigDecimal(rhuh.getTarifa().getVlNeto());
            BigDecimal bigTax = new BigDecimal(vlTarifa);
            BigDecimal bigTotalFare = new BigDecimal(rhuh.getTarifa().getVlTotal());

            Rate rate = new Rate();
            rate.setRoomFare(bigFare);
            rate.setRoomTax(bigTax);
            rate.setTotalFare(bigTotalFare);

            requestedRooms.setRoomIndex(sqQuato);
            requestedRooms.setRoomTypeName(rhuh.getUh().getCdUh());
            requestedRooms.setRoomTypeCode(rhuh.getUh().getIdToken());
            requestedRooms.setRatePlanCode(rhuh.getTarifa().getCdTarifa());
            requestedRooms.setRoomRate(rate);

            arrayOfRequestedRooms.getHotelRoom().add(requestedRooms);

            String chvSplit[] = reservarRQ.getReserva().getReservaHotel().getDsParametro().split("#");

            hotelBookRequest.setGuestNationality(rhuh.getReservaNomeList().get(0).getSgNacionalidade());
            hotelBookRequest.setClientReferenceNumber(reservarRQ.getIntegrador().getUsuario());
            hotelBookRequest.setGuests(arrayOfGuest);
            hotelBookRequest.setPaymentInfo(paymentInfo);
            hotelBookRequest.setSessionId(chvSplit[0]);
            hotelBookRequest.setNoOfRooms(sqQuato);
            hotelBookRequest.setResultIndex(Integer.parseInt(chvSplit[1]));
            hotelBookRequest.setHotelCode(reservarRQ.getReserva().getReservaHotel().getHotel().getId().toString());
            hotelBookRequest.setHotelName(reservarRQ.getReserva().getReservaHotel().getHotel().getNome());
            hotelBookRequest.setRestrictDuplicateBooking(false);
            hotelBookRequest.setHotelRooms(arrayOfRequestedRooms);
            hotelBookRequest.getSupplements

        }

        HotelBookResponse hotelBookResponse = chamaWS.chamadaPadrao(reservarRQ.getIntegrador(), hotelBookRequest, HotelBookResponse.class);

        ConsultarReservaWS consultarReservaWS = new ConsultarReservaWS();

        WSReserva reserva = new WSReserva(new WSReservaHotel(Integer.toString(hotelBookResponse.getBookingId())));

        WSReservaRS reservaRS = consultarReservaWS.consultar(new WSReservaRQ(reservarRQ.getIntegrador(), reserva));

        return new WSReservarRS(reservaRS.getReserva(), reservarRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);

    }
}
