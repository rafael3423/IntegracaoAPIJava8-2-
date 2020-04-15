package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSReserva;
import br.com.infotera.common.WSReservaHotel;
import br.com.infotera.common.WSReservaHotelUh;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.WSReservaRelatorioRQ;
import br.com.infotera.common.WSReservaRelatorioRS;
import br.com.infotera.common.WSTarifa;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSMensagemErroEnum;
import br.com.infotera.common.enumerator.WSReservaStatusEnum;
import br.com.infotera.common.hotel.WSHotel;
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.ChamaWS;
import br.com.infotera.it.tboholiday.UtilsWS;
import java.util.ArrayList;
import java.util.List;
import tektravel.hotelbookingapi.BookingsBasedOnDate;
import tektravel.hotelbookingapi.HotelBookingDetailBasedOnDateRequest;
import tektravel.hotelbookingapi.HotelBookingDetailBasedOnDateResponse;

public class ReservaRelatorioWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSReservaRelatorioRS relatorio(WSReservaRelatorioRQ reservaRelatorioRQ) throws ErrorException {

        HotelBookingDetailBasedOnDateRequest hotelBookingDetailBasedOnDateRequest = new HotelBookingDetailBasedOnDateRequest();

        hotelBookingDetailBasedOnDateRequest.setFromDate(Utils.convertStringDateToXmlGregorianCalendar(reservaRelatorioRQ.getDtInicial(), true));
        hotelBookingDetailBasedOnDateRequest.setToDate(Utils.convertStringDateToXmlGregorianCalendar(reservaRelatorioRQ.getDtFinal(), true));

        HotelBookingDetailBasedOnDateResponse hotelBookingDetailBasedOnDateResponse = chamaWS.chamadaPadrao(reservaRelatorioRQ.getIntegrador(), hotelBookingDetailBasedOnDateRequest, HotelBookingDetailBasedOnDateResponse.class);

        List<WSReserva> reservaList = new ArrayList();
        try {
            for (BookingsBasedOnDate bbd : hotelBookingDetailBasedOnDateResponse.getBookingDetail().getBooking()) {

                List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();

                List<WSReservaNome> reservaNomeList = new ArrayList();

                reservaHotelUhList.add(new WSReservaHotelUh(null,
                        null,
                        null,
                        new WSTarifa(Double.parseDouble(bbd.getBookingPrice()), null, bbd.getCurrency(), null),
                        null,
                        null,
                        reservaNomeList));

                WSReservaStatusEnum reservaStatusEnum = null;

                switch (bbd.getBookingStatus().toString().toUpperCase()) {
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
                        reservaStatusEnum = WSReservaStatusEnum.INCONSISTENTE;
                        break;
                    case "FAILED":
                        reservaStatusEnum = WSReservaStatusEnum.INCONSISTENTE;
                        break;
                    case "CANCELLATION_IN_PROGRESS":
                        reservaStatusEnum = WSReservaStatusEnum.INCONSISTENTE;
                        break;
                    case "VOUCHERED":
                        reservaStatusEnum = WSReservaStatusEnum.INCONSISTENTE;
                        break;
                    default:
                        break;
                }

                WSReservaHotel reservaHotel = new WSReservaHotel(UtilsWS.dtFormatadaddMMMyyyy(bbd.getBookingDate()),
                        null,
                        bbd.getBookingId(),
                        new WSHotel(Integer.parseInt(bbd.getTBOHotelCode()), "Hotel", null, null),
                        reservaHotelUhList,
                        null,
                        null,
                        reservaStatusEnum,
                        null,
                        null);

                reservaHotel.setId(Integer.parseInt(bbd.getBookingId()));

                WSReserva reserva = new WSReserva(reservaHotel);

                reserva.setId(bbd.getBookingId());

                reservaList.add(reserva);
            }
        } catch (Exception ex) {
            throw new ErrorException(reservaRelatorioRQ.getIntegrador(), ReservaRelatorioWS.class, "relatorio", WSMensagemErroEnum.HRL, "Ocorreu uma falha ao gerar relatório", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        return new WSReservaRelatorioRS(reservaList, reservaRelatorioRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);

    }

}
