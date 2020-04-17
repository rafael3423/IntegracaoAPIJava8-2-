/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSEndereco;
import br.com.infotera.common.WSTelefone;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSMensagemErroEnum;
import br.com.infotera.common.hotel.WSFacilidade;
import br.com.infotera.common.hotel.WSFacilidadeItem;
import br.com.infotera.common.hotel.WSHotel;
import br.com.infotera.common.hotel.WSHotelCategoria;
import br.com.infotera.common.hotel.rqrs.WSDetalheHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSDetalheHotelRS;
import br.com.infotera.common.media.WSMedia;
import br.com.infotera.it.tboholiday.ChamaWS;
import java.util.ArrayList;
import java.util.List;
import tektravel.hotelbookingapi.HotelDetailsRequest;
import tektravel.hotelbookingapi.HotelDetailsResponse;
import tektravel.hotelbookingapi.ImageUrlDetails;

public class DetalharHotelWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSDetalheHotelRS detalharHotel(WSDetalheHotelRQ detalheHotelRQ) throws ErrorException {

        HotelDetailsRequest hotelDetailsRequest = new HotelDetailsRequest();

        hotelDetailsRequest.setHotelCode(detalheHotelRQ.getHotel().getIdExterno());
        hotelDetailsRequest.setLanguage("PT");

        HotelDetailsResponse hotelDetailsResponse = chamaWS.chamadaPadrao(detalheHotelRQ.getIntegrador(), hotelDetailsRequest, HotelDetailsResponse.class);

        String cvhMap[] = hotelDetailsResponse.getHotelDetails().getMap().split("\\|");

        WSEndereco endereco = new WSEndereco(hotelDetailsResponse.getHotelDetails().getAddress(),
                null,
                hotelDetailsResponse.getHotelDetails().getCityName(),
                null,
                null,
                hotelDetailsResponse.getHotelDetails().getCountryName(),
                cvhMap[0],
                cvhMap[1]);

        List<WSTelefone> telefoneList = new ArrayList();

        WSTelefone telefone = new WSTelefone(hotelDetailsResponse.getHotelDetails().getPhoneNumber(), null);

        telefoneList.add(telefone);

        List<WSMedia> imagemList = new ArrayList();

        try {
            for (ImageUrlDetails imgUrl : hotelDetailsResponse.getHotelDetails().getImageUrls().getImageUrl()) {
                imagemList.add(new WSMedia(null, imgUrl.getValue()));
            }
        } catch (Exception ex) {
            throw new ErrorException(detalheHotelRQ.getIntegrador(), DetalharHotelWS.class, "detalharHotel", WSMensagemErroEnum.HDI, "Ocorreu uma falha ao buscar o detalhe do hotel.", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        List<WSFacilidadeItem> facilidadeItemList = new ArrayList();

        try {
            for (String facility : hotelDetailsResponse.getHotelDetails().getHotelFacilities().getHotelFacility()) {
                facilidadeItemList.add(new WSFacilidadeItem(null, facility, facility, null, null, null, null));
            }
        } catch (Exception ex) {
            throw new ErrorException(detalheHotelRQ.getIntegrador(), DetalharHotelWS.class, "detalharHotel", WSMensagemErroEnum.HCO, "Ocorreu uma falha ao buscar o detalhe do hotel.", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        List<WSFacilidade> facilidadeList = new ArrayList();
        facilidadeList.add(new WSFacilidade(null, null, facilidadeItemList, null));

        WSHotelCategoria hotelCategoria = new WSHotelCategoria(hotelDetailsResponse.getHotelDetails().getHotelRating().toString(), hotelDetailsResponse.getHotelDetails().getHotelRating().toString());

        WSHotel hotel = new WSHotel(hotelDetailsResponse.getHotelDetails().getHotelCode(),
                null,
                hotelDetailsResponse.getHotelDetails().getHotelName(),
                hotelDetailsResponse.getHotelDetails().getDescription(),
                endereco,
                null,
                null,
                null,
                hotelCategoria,
                imagemList,
                facilidadeList);

        return new WSDetalheHotelRS(hotel, detalheHotelRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);
    }
}
