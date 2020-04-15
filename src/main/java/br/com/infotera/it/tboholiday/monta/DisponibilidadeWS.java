package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSEndereco;
import br.com.infotera.common.WSIntegrador;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.WSTarifa;
import br.com.infotera.common.WSTarifaAdicional;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSMensagemErroEnum;
import br.com.infotera.common.enumerator.WSTarifaAdicionalTipoEnum;
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
import java.util.LinkedHashMap;
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

        int sqQuarto = 0;
        ArrayOfRoomGuest listaNomes = new ArrayOfRoomGuest();

        Map<Integer, List<WSReservaNome>> reservanomeMap = new HashMap();

        try {
            for (WSConfigUh cuh : disponibilidadeRQ.getConfigUhList()) {

                sqQuarto++;

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
        } catch (Exception ex) {
            throw new ErrorException(disponibilidadeRQ.getIntegrador(), DisponibilidadeWS.class, "disponibilidade", WSMensagemErroEnum.HDICUH, "Ocorreu uma falha na montagem dos hospedes", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        if (disponibilidadeRQ.getMunicipioId() != null && !disponibilidadeRQ.getMunicipioId().equals("")) {
            hotelSearchRequest.setCityId(Integer.parseInt(disponibilidadeRQ.getMunicipioId()));
        } else {
            String hotelCodeList = null;
            for (WSHotel hid : disponibilidadeRQ.getHotelList()) {
                if (hotelCodeList == null) {
                    hotelCodeList = hid.getIdExterno();
                } else {
                    hotelCodeList = hotelCodeList + "," + hid.getIdExterno();
                }
            }

            hotelSearchRequest.getFilters().setHotelCodeList(hotelCodeList);
        }

//      hotelSearchRequest.setResultCount(1);
        hotelSearchRequest.setCheckInDate(Utils.convertStringDateToXmlGregorianCalendar(disponibilidadeRQ.getDtEntrada(), true));
        hotelSearchRequest.setCheckOutDate(Utils.convertStringDateToXmlGregorianCalendar(disponibilidadeRQ.getDtSaida(), true));
        hotelSearchRequest.setNoOfRooms(sqQuarto);
        hotelSearchRequest.setGuestNationality("BR");
        hotelSearchRequest.setRoomGuests(listaNomes);
        hotelSearchRequest.setResponseTime(30000);
        hotelSearchRequest.setIsNearBySearchAllowed(true);

        HotelSearchResponse hotelSearchResponse = chamaWS.chamadaPadrao(disponibilidadeRQ.getIntegrador(), hotelSearchRequest, HotelSearchResponse.class);

        List<WSHotelPesquisa> hotelPesquisaList = new ArrayList();

        try {
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
                hotel.setIdExterno2(disponibilidadeRQ.getMunicipioId());

                List<WSQuarto> quartoList = new ArrayList();
                List<WSQuartoUh> quartoUhList = new ArrayList();

                WSTarifa tarifa = new WSTarifa(hr.getMinHotelPrice().getCurrency(), Double.parseDouble(hr.getMinHotelPrice().getTotalPrice().toString()), null);

                quartoUhList.add(new WSQuartoUh(1, new WSUh(null, "hotel", "hotel", "hotel", "hotel", null), new WSRegime("hotel", "hotel", "hotel"), tarifa));

                quartoList.add(new WSQuarto(Integer.parseInt(hotelSearchResponse.getNoOfRoomsRequested()),
                        new WSConfigUh(),
                        quartoUhList));

                hotelPesquisaList.add(new WSHotelPesquisa(disponibilidadeRQ.getIntegrador(),
                        Utils.toDate(hotelSearchResponse.getCheckInDate(), "dd/MM/yyyy HH:mm:ss"),
                        Utils.toDate(hotelSearchResponse.getCheckOutDate(), "dd/MM/yyyy HH:mm:ss"),
                        hotel,
                        quartoList,
                        null,
                        false,
                        hotelSearchResponse.getSessionId() + "#" + hr.getResultIndex()));
            }

        } catch (Exception ex) {
            throw new ErrorException(disponibilidadeRQ.getIntegrador(), DisponibilidadeWS.class, "disponibilidade", WSMensagemErroEnum.HDI, "Ocorreu uma falha ao consultar os hóteis disponiveis", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        if (hotelPesquisaList.size() == 1) {
            hotelPesquisaList.set(0, disponibilidadeUh(hotelPesquisaList.get(0), disponibilidadeRQ.getIntegrador(), reservanomeMap));
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

        try {
            for (HotelRoom hr : hotelRoomAvailabilityResponse.getHotelRooms().getHotelRoom()) {

                mapQuartoPesquisa.put(hr.getRoomIndex(), hr);
            }
        } catch (Exception ex) {
            throw new ErrorException(integrador, DisponibilidadeWS.class, "disponibilidadeUh", WSMensagemErroEnum.HDI, "Ocorreu uma falha ao consultar os quartos disponiveis", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        Map<Integer, List<HotelRoom>> mapQuartoPesquisadoList = new LinkedHashMap();

        int sqRoomIndex = 0;
        try {
            for (RoomCombination rc : hotelRoomAvailabilityResponse.getOptionsForBooking().getRoomCombination()) {
                List<HotelRoom> quartoPesquisadoList = new ArrayList();
                try {
                    for (int roomIndex : rc.getRoomIndex()) {
                        quartoPesquisadoList.add(mapQuartoPesquisa.get(roomIndex));
                    }
                } catch (Exception ex) {
                    throw new ErrorException(integrador, DisponibilidadeWS.class, "disponibilidadeUh", WSMensagemErroEnum.HDI, "Ocorreu uma falha ao consultar os quartos disponiveis", WSIntegracaoStatusEnum.NEGADO, ex);
                }

                mapQuartoPesquisadoList.put(sqRoomIndex, quartoPesquisadoList);
                sqRoomIndex++;
            }
        } catch (Exception ex) {
            throw new ErrorException(integrador, DisponibilidadeWS.class, "disponibilidadeUh", WSMensagemErroEnum.HDI, "Ocorreu uma falha ao consultar os quartos disponiveis", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        List<WSTarifaAdicional> tarifaAdicionalList = new ArrayList();
//        tarifaAdicionalList.add(new WSTarifaAdicional());
        try {
            for (Map.Entry<Integer, List<HotelRoom>> map : mapQuartoPesquisadoList.entrySet()) {

                int count = 0;
                Double vlNeto = 0.0;
                Double vlTaxa = 0.0;
                String sgMoeda = null;
                List<ParDisp> parDispList = new ArrayList();
                String roomChaveId = "";
                String roomNameId = "";
                LinkedHashMap<String, Integer> quartoConfig = new LinkedHashMap<>();
                try {
                    for (HotelRoom hr : map.getValue()) {

                        count++;

                        List<Supplement> supplementList = new ArrayList();

                        if (hr.getSupplements() != null && !hr.getSupplements().equals("")) {
                            for (Supplement s : hr.getSupplements().getSupplement()) {
                                supplementList.add(s);
                            }
                        }
                        Gson gson = new Gson();

                        ParDisp parDisp = new ParDisp(hr.getRoomIndex() + "",
                                hr.getRoomTypeCode(),
                                hr.getRatePlanCode(),
                                Utils.gerarDsReservaNome(reservanomeMap.get(count)),
                                gson.toJson(supplementList),
                                hr.getRoomRate().getRoomFare().toString() + "#" + hr.getRoomRate().getRoomTax().toString() + "#" + hr.getRoomRate().getTotalFare().toString(),
                                hr.getRoomTypeName());

                        parDispList.add(parDisp);

                        String dsParametro = gson.toJson(parDispList);

                        vlNeto = Utils.somar(vlNeto, Double.parseDouble(hr.getRoomRate().getRoomFare().toString()));
                        vlTaxa = Utils.somar(vlTaxa, Double.parseDouble(hr.getRoomRate().getRoomTax().toString()));

                        Integer qtQuarto = quartoConfig.get(hr.getRoomTypeName());
                        if (qtQuarto == null) {
                            quartoConfig.put(hr.getRoomTypeName(), 1);
                        } else {
                            qtQuarto++;
                            quartoConfig.replace(hr.getRoomTypeName(), qtQuarto);
                        }

                        if (roomChaveId.equalsIgnoreCase("")) {
                            roomChaveId = Integer.toString(hr.getRoomIndex());
                            roomNameId = hr.getRoomTypeName();
                        } else {
                            roomChaveId += "#" + Integer.toString(hr.getRoomIndex());
                            roomNameId += "#" + hr.getRoomTypeName();
                        }

                        String textoQuarto = null;
                        for (Map.Entry<String, Integer> quarto : quartoConfig.entrySet()) {
                            if (textoQuarto == null) {
                                textoQuarto = quarto.getValue() + "x " + quarto.getKey();
                            } else {
                                textoQuarto = textoQuarto + "+ " + quarto.getValue() + "x " + quarto.getKey();
                            }
                        }

//                        tarifaAdicionalList.set(0, new WSTarifaAdicional(WSTarifaAdicionalTipoEnum.TAXA_SERVICO, "Taxa de serviço", sgMoeda = hr.getRoomRate().getCurrency(), vlTaxa));

                        quartoPesquisa = new WSQuartoUh(sqPesquisa,
                                new WSUh(null, textoQuarto, textoQuarto, textoQuarto, textoQuarto, dsParametro),
                                new WSRegime(hr.getInclusion(), null, hr.getInclusion()),
                                new WSTarifa(sgMoeda = hr.getRoomRate().getCurrency(), vlNeto, null, hr.getRatePlanCode(), null, null, tarifaAdicionalList));

                    }
                } catch (Exception ex) {
                    throw new ErrorException(integrador, DisponibilidadeWS.class, "disponibilidadeUh", WSMensagemErroEnum.HDI, "Ocorreu uma falha ao consultar os quartos disponiveis", WSIntegracaoStatusEnum.NEGADO, ex);
                }

                quartoUhList.add(quartoPesquisa);
            }
        } catch (Exception ex) {
            throw new ErrorException(integrador, DisponibilidadeWS.class, "disponibilidadeUh", WSMensagemErroEnum.HDI, "Ocorreu uma falha ao consultar os quartos disponiveis", WSIntegracaoStatusEnum.NEGADO, ex);
        }

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
