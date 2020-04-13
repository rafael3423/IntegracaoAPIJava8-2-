package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.hotel.rqrs.WSPesquisaHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSPesquisaHotelRS;
import br.com.infotera.it.tboholiday.ChamaWS;
import tektravel.hotelbookingapi.GiataHotelCodesRequest;
import tektravel.hotelbookingapi.GiataHotelCodesResponse;

public class PesquisarHotelWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSPesquisaHotelRS pesquisarHotel(WSPesquisaHotelRQ pesquisarHotelRQ) throws ErrorException {

        GiataHotelCodesRequest giataHotelCodesRequest = new GiataHotelCodesRequest();

        giataHotelCodesRequest.setCityCode(pesquisarHotelRQ.getCdDestino());

        GiataHotelCodesResponse giataHotelCodesResponse = chamaWS.chamadaPadrao(pesquisarHotelRQ.getIntegrador(), giataHotelCodesRequest, GiataHotelCodesResponse.class);

        return null;
    }

}
