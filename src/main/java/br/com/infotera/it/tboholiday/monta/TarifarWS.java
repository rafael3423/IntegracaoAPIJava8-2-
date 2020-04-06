package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSReservaHotel;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSReservaStatusEnum;
import br.com.infotera.common.hotel.WSConfigUh;
import br.com.infotera.common.hotel.WSHotel;
import br.com.infotera.common.hotel.rqrs.WSDisponibilidadeHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSDisponibilidadeHotelRS;
import br.com.infotera.common.hotel.rqrs.WSTarifarHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSTarifarHotelRS;
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.ChamaWS;
import br.com.infotera.it.tboholiday.ParDisp;
import br.com.infotera.it.tboholiday.UtilsWS;
import java.util.ArrayList;
import java.util.List;

public class TarifarWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSTarifarHotelRS tarifarHotel(WSTarifarHotelRQ tarifarHotelRQ) throws ErrorException {

        if (tarifarHotelRQ.getReservaHotel().getReservaStatus().equals(WSReservaStatusEnum.ORCAMENTO)) {
            DisponibilidadeWS disponibilidadeWS = new DisponibilidadeWS();

            List<WSHotel> hotelList = new ArrayList();

            hotelList.add(tarifarHotelRQ.getReservaHotel().getHotel());

            ParDisp[] parDisp = (ParDisp[]) UtilsWS.fromJson(tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getUh().getDsParametro(), ParDisp[].class);

            List<WSConfigUh> configUhList = new ArrayList();

            for (ParDisp pd : parDisp) {
                configUhList.add(new WSConfigUh(Utils.gerarWSReservaNome(pd.getA3())));
            }

            WSDisponibilidadeHotelRS disponibilidadeHotelRS = disponibilidadeWS.disponibilidade(new WSDisponibilidadeHotelRQ(tarifarHotelRQ.getIntegrador(),
                    tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtEntrada(),
                    tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtSaida(),
                    null,
                    configUhList,
                    hotelList));

        }

        return new WSTarifarHotelRS(new WSReservaHotel, tarifarHotelRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);
    }
}
