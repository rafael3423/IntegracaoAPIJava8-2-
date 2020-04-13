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
import br.com.infotera.common.hotel.rqrs.WSTarifarHotelRS;
import br.com.infotera.it.tboholiday.ChamaWS;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class PreReservarWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSPreReservarRS preReservar(WSPreReservarRQ preReservarRQ) throws ErrorException {

        TarifarWS tarifarWS = new TarifarWS();

        preReservarRQ.getReserva().getReservaHotel().setReservaStatus(WSReservaStatusEnum.ORCAMENTO);

        WSTarifarHotelRS tarifarHotelRS = tarifarWS.tarifarHotel(new WSTarifarHotelRQ(preReservarRQ.getIntegrador(), preReservarRQ.getReserva().getReservaHotel()));

        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();


        for (WSReservaHotelUh rhu : tarifarHotelRS.getReservaHotel().getReservaHotelUhList()) {

            WSTarifa tarifa = new WSTarifa(rhu.getTarifa().getSgMoeda(),
                    rhu.getTarifa().getVlNeto(),
                    null,
                    rhu.getTarifa().getCdTarifa(),
                    null,
                    rhu.getTarifa().getPoliticaList(),
                    rhu.getTarifa().getTarifaAdicionalList());

            WSUh uh = new WSUh(null,
                    rhu.getUh().getCdUh(),
                    rhu.getUh().getDsCategoria(),
                    rhu.getUh().getDsUh(),
                    rhu.getUh().getDsParametro());

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
