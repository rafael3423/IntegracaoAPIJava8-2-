package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSReserva;
import br.com.infotera.common.WSReservaHotel;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSReservaStatusEnum;
import br.com.infotera.common.reserva.rqrs.WSReservaRQ;
import br.com.infotera.common.reserva.rqrs.WSReservaRS;
import br.com.infotera.it.tboholiday.ChamaWS;
import tektravel.hotelbookingapi.CancelRequestType;
import tektravel.hotelbookingapi.HotelCancelRequest;
import tektravel.hotelbookingapi.HotelCancelResponse;

public class CancelarReservaWS {

    ConsultarReservaWS consultarReservaWS = new ConsultarReservaWS();
    ChamaWS chamaWS = new ChamaWS();

    public WSReservaRS cancelar(WSReservaRQ reservaRQ) throws ErrorException {

        WSReservaRS consultarCancelamento = consultarReservaWS.consultar(reservaRQ);

        if (consultarCancelamento.getReserva().getReservaHotel().getReservaStatus().equals(WSReservaStatusEnum.CONFIRMADO)) {
            HotelCancelRequest hotelCancelRequest = new HotelCancelRequest();

            hotelCancelRequest.setBookingId(Integer.parseInt(reservaRQ.getReserva().getReservaHotel().getNrLocalizador()));
            hotelCancelRequest.setRemarks("");
            hotelCancelRequest.setRequestType(CancelRequestType.HOTEL_CANCEL);

            chamaWS.chamadaPadrao(reservaRQ.getIntegrador(), hotelCancelRequest, HotelCancelResponse.class);

            WSReservaRS reserva = consultarReservaWS.consultar(reservaRQ);

            return reserva;
        } else {
            return consultarCancelamento;
        }
    }
}
