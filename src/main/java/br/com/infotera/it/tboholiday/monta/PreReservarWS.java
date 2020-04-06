/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSPreReservarRQ;
import br.com.infotera.common.WSPreReservarRS;
import br.com.infotera.common.WSReserva;
import br.com.infotera.common.WSReservaHotel;
import br.com.infotera.common.WSReservaHotelUh;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.WSTarifa;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSReservaStatusEnum;
import br.com.infotera.common.hotel.WSUh;
import br.com.infotera.common.hotel.rqrs.WSTarifarHotelRQ;
import br.com.infotera.common.politica.WSPolitica;
import br.com.infotera.it.tboholiday.ChamaWS;
import java.util.ArrayList;
import java.util.List;
import tektravel.hotelbookingapi.AvailabilityAndPricingRequest;
import tektravel.hotelbookingapi.AvailabilityAndPricingResponse;
import tektravel.hotelbookingapi.BookingOptions;
import tektravel.hotelbookingapi.RoomCombination;

public class PreReservarWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSPreReservarRS preReservar(WSPreReservarRQ preReservarRQ) throws ErrorException {

        TarifarWS tarifarWS = new TarifarWS();
        
        preReservarRQ.getReserva().getReservaHotel().setReservaStatus(WSReservaStatusEnum.ORCAMENTO);
        
        tarifarWS.tarifarHotel(new WSTarifarHotelRQ(preReservarRQ.getIntegrador(), preReservarRQ.getReserva().getReservaHotel()));
        
        
        
        
        
        
        
        
        
        
        
        RoomCombination roomCombination = new RoomCombination();
        roomCombination.getRoomIndex().add(1);
        BookingOptions bookingOptions = new BookingOptions();
        bookingOptions.setFixedFormat(false);
        bookingOptions.getRoomCombination().add(roomCombination);

        AvailabilityAndPricingRequest availabilityAndPricingRequest = new AvailabilityAndPricingRequest();

        availabilityAndPricingRequest.setSessionId("1e2c0c94-2e32-4aed-9e8e-e4e43c23daa2");
        availabilityAndPricingRequest.setResultIndex(1);
        availabilityAndPricingRequest.setOptionsForBooking(bookingOptions);

        AvailabilityAndPricingResponse availabilityAndPricingResponse = chamaWS.chamadaPadrao(preReservarRQ.getIntegrador(), availabilityAndPricingRequest, AvailabilityAndPricingResponse.class);

        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();

        for (WSReservaHotelUh rhu : preReservarRQ.getReserva().getReservaHotel().getReservaHotelUhList()) {

            List<WSPolitica> politicaCancelamentoList = new ArrayList();

            WSTarifa tarifa = new WSTarifa(,
                    ,
                    null,
                    null,
                    null,
                    politicaCancelamentoList);

            WSUh uh = new WSUh(null,
                    rhu.getUh().getCdUh(),
                    rhu.getUh().getDsCategoria(),
                    rhu.getUh().getDsUh(),
                    );

            List<WSReservaNome> reservaNomeList = new ArrayList();

            for (WSReservaNome rn : rhu.getReservaNomeList()) {

                reservaNomeList.add(new WSReservaNome(rn.getNmNome(),
                        rn.getNmSobrenome(),
                        rn.getPaxTipo(),
                        rn.getDtNascimento(),
                        rn.getQtIdade(),
                        rn.getSexo()));

                rhu.setReservaNomeList(reservaNomeList);
            }
            
            int sqQuarto = 0;
            reservaHotelUhList.add(new WSReservaHotelUh(sqQuarto++,
                    uh,
                    rhu.getRegime(),
                    tarifa,
                    rhu.getDtEntrada(),
                    rhu.getDtSaida(),
                    reservaNomeList,
                    WSReservaStatusEnum.SOLICITACAO));
        }

        WSReservaHotel reservaHotel = new WSReservaHotel(reservaHotelUhList);
        reservaHotel.setHotel(preReservarRQ.getReserva().getReservaHotel().getHotel());
        reservaHotel.setDsParametro(preReservarRQ.getReserva().getReservaHotel().getDsParametro());

        WSReserva reserva = new WSReserva(reservaHotel);

        return new WSPreReservarRS(reserva, preReservarRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);
    }
}
