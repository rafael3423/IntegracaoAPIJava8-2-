
package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.hotel.rqrs.WSPesquisaHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSPesquisaHotelRS;
import br.com.infotera.it.tboholiday.ChamaWS;


public class PesquisarHotelWS {
        ChamaWS chamaWS = new ChamaWS();

    public WSPesquisaHotelRS pesquisarHotel(WSPesquisaHotelRQ pesquisarHotelRQ) throws ErrorException {


        return new WSPesquisaHotelRS(hotelList, integrador);
    }
    
}
