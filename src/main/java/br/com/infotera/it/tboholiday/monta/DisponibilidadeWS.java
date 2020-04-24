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
import br.com.infotera.common.politica.WSPolitica;
import br.com.infotera.common.politica.WSPoliticaCancelamento;
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.ChamaWS;
import br.com.infotera.it.tboholiday.ParDisp;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tektravel.hotelbookingapi.ArrayOfInt;
import tektravel.hotelbookingapi.ArrayOfRoomGuest;
import tektravel.hotelbookingapi.CancelPolicies;
import tektravel.hotelbookingapi.CancellationChargeTypeForHotel;
import tektravel.hotelbookingapi.Filters;
import tektravel.hotelbookingapi.HotelResult;
import tektravel.hotelbookingapi.HotelRoom;
import tektravel.hotelbookingapi.HotelRoomAvailabilityRequest;
import tektravel.hotelbookingapi.HotelRoomAvailabilityResponse;
import tektravel.hotelbookingapi.HotelSearchRequest;
import tektravel.hotelbookingapi.HotelSearchResponse;
import tektravel.hotelbookingapi.RoomCombination;
import tektravel.hotelbookingapi.RoomGuest;
import tektravel.hotelbookingapi.Supplement;

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

                try {
                    for (WSReservaNome rn : cuh.getReservaNomeList()) {
                        if (rn.getPaxTipo().isChd() || rn.getPaxTipo().isInf()) {
                            idadesCrianca.getInt().add(rn.getQtIdade());
                        } else {
                            qtAdt++;
                        }
                    }
                } catch (Exception ex) {
                    throw new ErrorException(disponibilidadeRQ.getIntegrador(), DisponibilidadeWS.class, "disponibilidade", WSMensagemErroEnum.HDICUH, "Ocorreu uma falha na montagem dos hospedes", WSIntegracaoStatusEnum.NEGADO, ex);
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

        Filters filters = new Filters();

        if (disponibilidadeRQ.getMunicipioId() != null && !disponibilidadeRQ.getMunicipioId().equals("")) {
            hotelSearchRequest.setCityId(Integer.parseInt(disponibilidadeRQ.getMunicipioId()));
        } else {
            String hotelCodeList = null;
            try {
                for (WSHotel hid : disponibilidadeRQ.getHotelList()) {
                    if (hotelCodeList == null) {
                        hotelCodeList = hid.getIdExterno();
                    } else {
                        hotelCodeList = hotelCodeList + "," + hid.getIdExterno();
                    }
                }
            } catch (Exception ex) {
                throw new ErrorException(disponibilidadeRQ.getIntegrador(), DisponibilidadeWS.class, "disponibilidade", WSMensagemErroEnum.HPH, "Ocorreu uma falha ao pesquisar o hotel", WSIntegracaoStatusEnum.NEGADO, ex);
            }

            filters.setHotelCodeList(hotelCodeList);
            hotelSearchRequest.setFilters(filters);
        }

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
            hotelSearchResponse.getHotelResultList().getHotelResult().forEach((hr) -> {
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

                quartoUhList.add(new WSQuartoUh(1, new WSUh(), new WSRegime(), tarifa));

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
            });

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
            hotelRoomAvailabilityResponse.getHotelRooms().getHotelRoom().forEach((hr) -> {
                mapQuartoPesquisa.put(hr.getRoomIndex(), hr);
            });
        } catch (Exception ex) {
            throw new ErrorException(integrador, DisponibilidadeWS.class, "disponibilidadeUh", WSMensagemErroEnum.HDI, "Ocorreu uma falha ao consultar os quartos disponiveis", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        Map<Integer, List<HotelRoom>> mapQuartoPesquisadoList = new LinkedHashMap();

        int sqRoomIndex = 0;
        try {
            for (RoomCombination rc : hotelRoomAvailabilityResponse.getOptionsForBooking().getRoomCombination()) {
                List<HotelRoom> quartoPesquisadoList = new ArrayList();
                try {
                    rc.getRoomIndex().forEach((roomIndex) -> {
                        quartoPesquisadoList.add(mapQuartoPesquisa.get(roomIndex));
                    });
                } catch (Exception ex) {
                    throw new ErrorException(integrador, DisponibilidadeWS.class, "disponibilidadeUh", WSMensagemErroEnum.HDI, "Ocorreu uma falha ao consultar os quartos disponiveis", WSIntegracaoStatusEnum.NEGADO, ex);
                }

                mapQuartoPesquisadoList.put(sqRoomIndex, quartoPesquisadoList);
                sqRoomIndex++;
            }
        } catch (Exception ex) {
            throw new ErrorException(integrador, DisponibilidadeWS.class, "disponibilidadeUh", WSMensagemErroEnum.HDI, "Ocorreu uma falha ao consultar os quartos disponiveis", WSIntegracaoStatusEnum.NEGADO, ex);
        }
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
                List<WSPolitica> politicaList = new ArrayList();
                try {
                    for (HotelRoom hr : map.getValue()) {

                        count++;

                        List<Supplement> supplementList = new ArrayList();

                        if (hr.getSupplements() != null) {
                            try {
                                hr.getSupplements().getSupplement().forEach((s) -> {
                                    supplementList.add(s);
                                });
                            } catch (Exception ex) {
                                throw new ErrorException(integrador, DisponibilidadeWS.class, "disponibilidadeUh", WSMensagemErroEnum.HDI, "Ocorreu uma falha ao consultar os quartos disponiveis", WSIntegracaoStatusEnum.NEGADO, ex);
                            }
                        }
                        Gson gson = new Gson();

                        ParDisp parDisp = new ParDisp(hr.getRoomIndex() + "",
                                hr.getRoomTypeCode(),
                                hr.getRatePlanCode(),
                                Utils.gerarDsReservaNome(reservanomeMap.get(count)),
                                gson.toJson(supplementList),
                                hr.getRoomRate().getRoomFare().toString() + "#" + hr.getRoomRate().getRoomTax().toString() + "#" + hr.getRoomRate().getTotalFare().toString(),
                                hr.getRoomTypeName(),
                                hotelPesquisa.getDsParametro());

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
                        try {
                            for (Map.Entry<String, Integer> quarto : quartoConfig.entrySet()) {
                                if (textoQuarto == null) {
                                    textoQuarto = quarto.getValue() + "x " + quarto.getKey();
                                } else {
                                    textoQuarto = textoQuarto + "<br/>" + quarto.getValue() + "x " + quarto.getKey();
                                }
                            }
                        } catch (Exception ex) {
                            throw new ErrorException(integrador, DisponibilidadeWS.class, "disponibilidadeUh", WSMensagemErroEnum.HDI, "Ocorreu uma falha ao consultar os quartos disponiveis", WSIntegracaoStatusEnum.NEGADO, ex);
                        }

                        politicaList.addAll(montaPoliticaCancelamento(hr.getCancelPolicies(), hr.getRoomRate().getTotalFare().doubleValue(), integrador));

                        List<WSTarifaAdicional> tarifaAdicionalList = new ArrayList();

                        sgMoeda = hr.getRoomRate().getCurrency();
                        tarifaAdicionalList.add(new WSTarifaAdicional(WSTarifaAdicionalTipoEnum.TAXA_SERVICO, "Taxa de serviço", sgMoeda, vlTaxa));

                        WSTarifa tarifa = new WSTarifa(sgMoeda, vlNeto, null, hr.getRatePlanCode(), null, null, tarifaAdicionalList);
                        tarifa.setPoliticaList(politicaList);

                        quartoPesquisa = new WSQuartoUh(sqPesquisa,
                                new WSUh(null, hr.getRoomTypeCode(), textoQuarto, textoQuarto, textoQuarto, dsParametro),
                                new WSRegime(hr.getMealType().replace("_", ""), null, hr.getMealType().replace("_", "")),
                                tarifa);

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

    private List<WSPolitica> montaPoliticaCancelamento(CancelPolicies cancelPolicies, Double vlDiaria, WSIntegrador integrador) throws ErrorException {

        List<WSPolitica> politicaList = new ArrayList();

        if (cancelPolicies != null && cancelPolicies.getCancelPolicy() != null) {
            try {
                cancelPolicies.getCancelPolicy().forEach((cp) -> {

                    Double pcCancelamento = null;
                    Double vlCancelamento = null;

                    if (cp.getChargeType() != null && cp.getChargeType().equals(CancellationChargeTypeForHotel.PERCENTAGE)) {
                        if (cp.getCancellationCharge() != null && cp.getCancellationCharge().doubleValue() > 0.0) {
                            pcCancelamento = cp.getCancellationCharge().doubleValue();
                        }
                    } else if (cp.getChargeType() != null && cp.getChargeType().equals(CancellationChargeTypeForHotel.FIXED)) {
                        if (cp.getCancellationCharge() != null && cp.getCancellationCharge().doubleValue() > 0.0) {
                            vlCancelamento = cp.getCancellationCharge().doubleValue();
                        }
                    } else if (cp.getChargeType() != null && cp.getChargeType().equals(CancellationChargeTypeForHotel.NIGHT)) {
                        if (cp.getCancellationCharge() != null && cp.getCancellationCharge().doubleValue() > 0.0) {
                            vlCancelamento = Utils.multiplicar(vlDiaria, cp.getCancellationCharge().doubleValue());
                        }
                    }

                    if (pcCancelamento != null || vlCancelamento != null) {
                        Date dtMinCancelamento = Utils.addDias(Utils.toDate(cp.getFromDate(), "yyyy-MM-dd"), -3);
                        Date dtMaxCancelamento = Utils.toDate(cp.getToDate(), "yyyy-MM-dd");
                        boolean stImediata = false;

                        if (dtMinCancelamento.before(new Date())) {
                            stImediata = true;
                        }

                        politicaList.add(new WSPoliticaCancelamento("Politica de cancelamento",
                                null,
                                cp.getCurrency(),
                                vlCancelamento,
                                pcCancelamento,
                                null,
                                stImediata,
                                dtMinCancelamento,
                                dtMaxCancelamento,
                                false));
                    }
                });
            } catch (Exception ex) {
                throw new ErrorException(integrador, DisponibilidadeWS.class, "montaPoliticaCancelamento", WSMensagemErroEnum.HDI, "Ocorreu uma falha ao gerar politicas de cancelamento", WSIntegracaoStatusEnum.NEGADO, ex);
            }
        }

        return politicaList;
    }
}
