package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSEndereco;
import br.com.infotera.common.WSIntegrador;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.WSTarifa;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.hotel.WSConfigUh;
import br.com.infotera.common.hotel.WSHotel;
import br.com.infotera.common.hotel.WSHotelCategoria;
import br.com.infotera.common.hotel.WSHotelPesquisa;
import br.com.infotera.common.hotel.WSQuarto;
import br.com.infotera.common.hotel.WSQuartoUh;
import br.com.infotera.common.hotel.WSRegime;
import br.com.infotera.common.hotel.WSUh;
import br.com.infotera.common.hotel.rqrs.WSDisponibilidadeHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSDisponibilidadeHotelRS;
import br.com.infotera.common.media.WSMedia;
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.ChamaWS;
import br.com.infotera.it.tboholiday.ParDisp;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tektravel.hotelbookingapi.ArrayOfInt;
import tektravel.hotelbookingapi.ArrayOfRoomGuest;
import tektravel.hotelbookingapi.HotelResult;
import tektravel.hotelbookingapi.HotelRoom;
import tektravel.hotelbookingapi.HotelRoomAvailabilityRequest;
import tektravel.hotelbookingapi.HotelRoomAvailabilityResponse;
import tektravel.hotelbookingapi.HotelSearchRequest;
import tektravel.hotelbookingapi.HotelSearchResponse;

import tektravel.hotelbookingapi.RoomCombination;
import tektravel.hotelbookingapi.RoomGuest;
import tektravel.hotelbookingapi.Supplement;

///**
// *
// * @author bruno
// */
public class DisponibilidadeWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSDisponibilidadeHotelRS disponibilidade(WSDisponibilidadeHotelRQ disponibilidadeRQ) throws ErrorException {

        HotelSearchRequest hotelSearchRequest = new HotelSearchRequest();

        hotelSearchRequest.setCheckInDate(Utils.convertStringDateToXmlGregorianCalendar(disponibilidadeRQ.getDtEntrada(), true));
        hotelSearchRequest.setCheckOutDate(Utils.convertStringDateToXmlGregorianCalendar(disponibilidadeRQ.getDtSaida(), true));
        hotelSearchRequest.setCityId(Integer.parseInt(disponibilidadeRQ.getMunicipioId()));

        int sqQuarto = 0;
        String sgNacinoalidade = null;
        ArrayOfRoomGuest listaNomes = new ArrayOfRoomGuest();

        Map<Integer, List<WSReservaNome>> reservanomeMap = new HashMap();

        for (WSConfigUh cuh : disponibilidadeRQ.getConfigUhList()) {

            sqQuarto++;
            sgNacinoalidade = cuh.getReservaNomeList().get(0).getSgNacionalidade();

            RoomGuest hospede = new RoomGuest();

            ArrayOfInt idadesCrianca = new ArrayOfInt();

            int qtAdt = 0;
            for (WSReservaNome rn : cuh.getReservaNomeList()) {
                if (rn.getPaxTipo().isChd() || rn.getPaxTipo().isInf()) {
                    idadesCrianca.getInt().add(rn.getQtIdade());
                } else {
                    qtAdt++;
                }
            }

            hospede.setAdultCount(qtAdt);

            if (idadesCrianca.getInt() != null && !idadesCrianca.getInt().isEmpty()) {
                hospede.setChildCount(idadesCrianca.getInt().size());
                hospede.setChildAge(idadesCrianca);
            }

            listaNomes.getRoomGuest().add(hospede);
            reservanomeMap.put(sqQuarto, cuh.getReservaNomeList());

        }

        hotelSearchRequest.setResultCount(1);
        hotelSearchRequest.setNoOfRooms(sqQuarto);
        hotelSearchRequest.setGuestNationality(sgNacinoalidade);
        hotelSearchRequest.setRoomGuests(listaNomes);
        hotelSearchRequest.setResponseTime(disponibilidadeRQ.getIntegrador().getTimeoutSegundos());
        hotelSearchRequest.setIsNearBySearchAllowed(true);

        HotelSearchResponse hotelSearchResponse = chamaWS.chamadaPadrao(disponibilidadeRQ.getIntegrador(), hotelSearchRequest, HotelSearchResponse.class);

        List<WSHotelPesquisa> hotelPesquisaList = new ArrayList();

        for (HotelResult hr : hotelSearchResponse.getHotelResultList().getHotelResult()) {

            WSHotelCategoria hotelCategoria = new WSHotelCategoria(hr.getHotelInfo().getRating().toString(), hr.getHotelInfo().getRating().toString());

            WSEndereco endereco = new WSEndereco();

            endereco.setDsEndereco(hr.getHotelInfo().getHotelAddress());
            endereco.setNrLatitude(hr.getHotelInfo().getLatitude().toString());
            endereco.setNrLongitude(hr.getHotelInfo().getLongitude().toString());

            List<WSMedia> imagemList = new ArrayList();

            imagemList.add(new WSMedia(null, hr.getHotelInfo().getHotelPicture()));

            WSHotel hotel = new WSHotel(null,
                    hr.getHotelInfo().getHotelName(),
                    hr.getHotelInfo().getHotelDescription(),
                    hotelCategoria,
                    null,
                    null,
                    endereco,
                    imagemList);

            hotel.setIdExterno(hr.getHotelInfo().getHotelCode());

            List<WSQuarto> quartoList = new ArrayList();
            List<WSQuartoUh> quartoUhList = new ArrayList();

            WSTarifa tarifa = new WSTarifa(hr.getMinHotelPrice().getCurrency(), Double.parseDouble(hr.getMinHotelPrice().getTotalPrice().toString()), null);

            quartoUhList.add(new WSQuartoUh(1, null, null, tarifa));

            quartoList.add(new WSQuarto(Integer.parseInt(hotelSearchResponse.getNoOfRoomsRequested()),
                    new WSConfigUh(),
                    quartoUhList));

            hotelPesquisaList.add(new WSHotelPesquisa(disponibilidadeRQ.getIntegrador(),
                    Utils.toDate(hotelSearchResponse.getCheckInDate(), "dd/MM/yyyy HH:mm:ss"),
                    Utils.toDate(hotelSearchResponse.getCheckOutDate(), "dd/MM/yyyy HH:mm:ss"),
                    hotel,
                    quartoList,
                    null,
                    hotelSearchResponse.getSessionId() + "#" + hr.getResultIndex()));
        }

        if (hotelPesquisaList.size() == 1) {
            disponibilidadeUh(hotelPesquisaList.get(0), disponibilidadeRQ.getIntegrador(), reservanomeMap);
        }

        return new WSDisponibilidadeHotelRS(hotelPesquisaList, disponibilidadeRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);
    }

    public WSHotelPesquisa disponibilidadeUh(WSHotelPesquisa hotelPesquisa, WSIntegrador integrador, Map<Integer, List<WSReservaNome>> reservanomeMap) throws ErrorException {

        HotelRoomAvailabilityRequest hotelRoomAvailabilityRequest = new HotelRoomAvailabilityRequest();

        String chvSessao[] = hotelPesquisa.getDsParametro().split("#");

        hotelRoomAvailabilityRequest.setHotelCode(hotelPesquisa.getHotel().getIdExterno());
        hotelRoomAvailabilityRequest.setIsCancellationPolicyRequired(true);
        hotelRoomAvailabilityRequest.setResponseTime(integrador.getTimeoutSegundos());
        hotelRoomAvailabilityRequest.setResultIndex(Integer.parseInt(chvSessao[1]));
        hotelRoomAvailabilityRequest.setSessionId(chvSessao[0]);

        HotelRoomAvailabilityResponse hotelRoomAvailabilityResponse = chamaWS.chamadaPadrao(integrador, hotelRoomAvailabilityRequest, HotelRoomAvailabilityResponse.class);

        Integer sqPesquisa = 0;
        List<WSQuartoUh> quartoUhList = new ArrayList();

        WSQuartoUh quartoPesquisa = new WSQuartoUh();
        Map<Integer, HotelRoom> mapQuartoPesquisa = new HashMap();

        for (HotelRoom hr : hotelRoomAvailabilityResponse.getHotelRooms().getHotelRoom()) {

            mapQuartoPesquisa.put(hr.getRoomIndex(), hr);
        }
//            sqPesquisa++;
//
//            List<WSPolitica> politicaCancelamentoList = new ArrayList();
//
//            if (hr.getCancelPolicies() != null) {
//                for (CancelPolicy cp : hr.getCancelPolicies().getCancelPolicy()) {
//
//                    politicaCancelamentoList.add(new WSPoliticaCancelamento(cp.getRoomTypeName(),
//                            hr.getCancelPolicies().getDefaultPolicy(),
//                            cp.getCurrency(),
//                            Double.parseDouble(cp.getCancellationCharge().toString()),
//                            null,
//                            null,
//                            false,
//                            Utils.toDate(cp.getFromDate(), "yyyy-MM-dd'T'HH:mm:ss"),
//                            Utils.toDate(cp.getToDate(), "yyyy-MM-dd'T'HH:mm:ss"),
//                            true));
//                }
//            }

        List<HotelRoom> quartoPesquisadoList = new ArrayList();

        for (RoomCombination rc : hotelRoomAvailabilityResponse.getOptionsForBooking().getRoomCombination()) {

            for (int roomIndex : rc.getRoomIndex()) {
                quartoPesquisadoList.add(mapQuartoPesquisa.get(roomIndex));
            }
        }

        int count = 0;

        List<ParDisp> parDispList = new ArrayList();

        Double vlNeto = 0.0;
        String sgMoeda = null;
        String nmQuarto = "";

        for (HotelRoom hr : quartoPesquisadoList) {

            count++;

            List<Supplement> supplementList = new ArrayList();

            for (Supplement s : hr.getSupplements().getSupplement()) {
                supplementList.add(s);
            }

            Gson gson = new Gson();

            String supplement = gson.toJson(supplementList);

            ParDisp parDisp = new ParDisp(hr.getRoomIndex() + "",
                    hr.getRoomTypeCode(),
                    hr.getRatePlanCode(),
                    Utils.gerarDsReservaNome(reservanomeMap.get(count)),
                    supplement,
                    null);

            parDispList.add(parDisp);

            String dsParametro = gson.toJson(parDispList);

            vlNeto = Utils.somar(vlNeto, Double.parseDouble(hr.getRoomRate().getTotalFare().toString()));
            sgMoeda = hr.getRoomRate().getCurrency();

            if (nmQuarto.equals("")) {
                nmQuarto = hr.getRoomTypeName();
            } else {
                nmQuarto = nmQuarto + "#" + hr.getRoomTypeName();
            }

            quartoPesquisa = new WSQuartoUh(sqPesquisa,
                    new WSUh(null, nmQuarto, hr.getRoomTypeCode(), nmQuarto, nmQuarto, dsParametro),
                    new WSRegime(hr.getInclusion(), null, hr.getInclusion()),
                    new WSTarifa(sgMoeda, vlNeto, null, hr.getRatePlanCode(), null, null));

        }

        quartoUhList.add(quartoPesquisa);

        List<WSQuarto> quartoList = new ArrayList();

        quartoList.add(new WSQuarto(sqPesquisa,
                new WSConfigUh(),
                quartoUhList));

        return new WSHotelPesquisa(integrador,
                hotelPesquisa.getDtEntrada(),
                hotelPesquisa.getDtSaida(),
                hotelPesquisa.getHotel(),
                quartoList,
                sqPesquisa,
                hotelPesquisa.getDsParametro());
    }
}
