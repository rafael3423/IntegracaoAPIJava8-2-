package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSPreReservarRS;
import br.com.infotera.common.WSReservaHotel;
import br.com.infotera.common.WSReservaHotelUh;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.WSTarifa;
import br.com.infotera.common.WSTarifaAdicional;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSMensagemErroEnum;
import br.com.infotera.common.enumerator.WSReservaStatusEnum;
import br.com.infotera.common.enumerator.WSTarifaAdicionalTipoEnum;
import br.com.infotera.common.hotel.WSConfigUh;
import br.com.infotera.common.hotel.WSConfigUhIdade;
import br.com.infotera.common.hotel.WSHotel;
import br.com.infotera.common.hotel.WSHotelPesquisa;
import br.com.infotera.common.hotel.WSQuarto;
import br.com.infotera.common.hotel.WSQuartoUh;
import br.com.infotera.common.hotel.WSRegime;
import br.com.infotera.common.hotel.WSUh;
import br.com.infotera.common.hotel.rqrs.WSDisponibilidadeHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSDisponibilidadeHotelRS;
import br.com.infotera.common.hotel.rqrs.WSTarifarHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSTarifarHotelRS;
import br.com.infotera.common.politica.WSPolitica;
import br.com.infotera.common.politica.WSPoliticaCancelamento;
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.ChamaWS;
import br.com.infotera.it.tboholiday.ParDisp;
import br.com.infotera.it.tboholiday.UtilsWS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tektravel.hotelbookingapi.AvailabilityAndPricingRequest;
import tektravel.hotelbookingapi.AvailabilityAndPricingResponse;
import tektravel.hotelbookingapi.BookingOptions;
import tektravel.hotelbookingapi.RoomCombination;

public class TarifarWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSTarifarHotelRS tarifarHotel(WSTarifarHotelRQ tarifarHotelRQ) throws ErrorException {

        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();
        String chvSessao = null;

        if (tarifarHotelRQ.getReservaHotel().getReservaStatus().equals(WSReservaStatusEnum.ORCAMENTO)) {
            reservaHotelUhList.addAll(tarifarOrcamento(tarifarHotelRQ));

        } else if (tarifarHotelRQ.getReservaHotel().getReservaStatus().equals(WSReservaStatusEnum.SOLICITACAO)) {
            reservaHotelUhList.addAll(tarifarSolicitacao(tarifarHotelRQ));
        }

        WSReservaHotel reservaHotel = new WSReservaHotel(tarifarHotelRQ.getReservaHotel().getDtReserva(),
                tarifarHotelRQ.getReservaHotel().getDtExpiracao(),
                null,
                tarifarHotelRQ.getReservaHotel().getHotel(),
                reservaHotelUhList,
                null,
                null,
                WSReservaStatusEnum.SOLICITACAO,
                null,
                chvSessao);

        return new WSTarifarHotelRS(reservaHotel, tarifarHotelRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);
    }

    private List<WSReservaHotelUh> tarifarOrcamento(WSTarifarHotelRQ tarifarHotelRQ) throws ErrorException {

        DisponibilidadeWS disponibilidadeWS = new DisponibilidadeWS();
        List<WSHotel> hotelList = new ArrayList();
        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();

        hotelList.add(tarifarHotelRQ.getReservaHotel().getHotel());

        ParDisp[] parDisp = (ParDisp[]) UtilsWS.fromJson(tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getUh().getDsParametro(), ParDisp[].class);

        List<WSConfigUh> configUhList = new ArrayList();
        try {
            for (ParDisp pd : parDisp) {
                configUhList.add(new WSConfigUh(Utils.gerarWSReservaNome(pd.getA3())));
            }
        } catch (Exception ex) {
            throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifarHotel", WSMensagemErroEnum.HTA, "Ocorreu uma falha ao gerar tarifas", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        WSDisponibilidadeHotelRS disponibilidadeHotelRS = disponibilidadeWS.disponibilidade(new WSDisponibilidadeHotelRQ(tarifarHotelRQ.getIntegrador(),
                tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtEntrada(),
                tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtSaida(),
                null,
                configUhList,
                hotelList));

        WSQuartoUh quartoUh = null;

        try {
            for (WSHotelPesquisa hp : disponibilidadeHotelRS.getHotelPesquisaList()) {
                for (WSQuartoUh quh : hp.getQuartoList().get(0).getQuartoUhList()) {
                    if (tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getTarifa().getVlNeto().equals(quh.getTarifa().getVlNeto())) {
                        String dsUh = quh.getUh().getDsUh();
                        if (tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getUh().getDsUh().equals(dsUh)) {
                            if (tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getRegime().getDsRegime().equals(quh.getRegime().getDsRegime())) {
                                quartoUh = quh;
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifarHotel", WSMensagemErroEnum.HTA, "Ocorreu uma falha ao gerar tarifas", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        if (quartoUh == null) {
            throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifar", WSMensagemErroEnum.HTA, "Quarto não disponivel", WSIntegracaoStatusEnum.NEGADO, null);
        } else {

            reservaHotelUhList.add(new WSReservaHotelUh(0,
                    quartoUh.getUh(),
                    quartoUh.getRegime(),
                    quartoUh.getTarifa(),
                    tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtEntrada(),
                    tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtSaida(),
                    null,
                    WSReservaStatusEnum.SOLICITACAO));
        }

        return reservaHotelUhList;
    }

    private List<WSReservaHotelUh> tarifarSolicitacao(WSTarifarHotelRQ tarifarHotelRQ) throws ErrorException {

        DisponibilidadeWS disponibilidadeWS = new DisponibilidadeWS();

        List<WSHotel> hotelList = new ArrayList();

        hotelList.add(tarifarHotelRQ.getReservaHotel().getHotel());

        List<WSConfigUh> configUhList = new ArrayList();
        try {
            tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().forEach((rhuh) -> {
                configUhList.add(new WSConfigUh(rhuh.getReservaNomeList()));
            });
        } catch (Exception ex) {
            throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifarHotel", WSMensagemErroEnum.HTA, "Ocorreu uma falha ao gerar tarifas", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        WSDisponibilidadeHotelRS disponibilidadeHotelRS = disponibilidadeWS.disponibilidade(new WSDisponibilidadeHotelRQ(tarifarHotelRQ.getIntegrador(),
                tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtEntrada(),
                tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtSaida(),
                null,
                configUhList,
                hotelList));

        Map<String, WSQuartoUh> mapUhTarifaDisponivel = new HashMap();
        try {
            disponibilidadeHotelRS.getHotelPesquisaList().get(0).getQuartoList().forEach((q) -> {
                q.getQuartoUhList().forEach((uh) -> {
                    String chave = uh.getUh().getDsUh() + "#" + uh.getRegime().getDsRegime() + "#" + uh.getTarifa().getVlNeto();
                    if (mapUhTarifaDisponivel.get(chave) != null) {
                        WSQuartoUh wsUhMap = mapUhTarifaDisponivel.get(chave);
                        if (uh.getTarifa().getVlNeto() <= wsUhMap.getTarifa().getVlNeto()) {
                            mapUhTarifaDisponivel.put(chave, uh);
                        }
                    } else {
                        mapUhTarifaDisponivel.put(chave, uh);
                    }
                });
            });
        } catch (Exception ex) {
            throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifar", WSMensagemErroEnum.HTA, "Erro ao montar tarifa no quarto", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();

        try {
            List<String> chavesUh = new ArrayList();
            String chave = "";
            String chaveRoom = "";
            Double vlQuarto = 0.0;
            for (WSReservaHotelUh hu : tarifarHotelRQ.getReservaHotel().getReservaHotelUhList()) {
                int count = 0;
                String uhKey = null;
                for (String a : chavesUh) {
                    if (a.contains(hu.getUh().getDsUh())) {
                        uhKey = a;
                        break;
                    }
                    count++;
                }

                if (uhKey != null) {
                    int qtUh = Integer.parseInt(uhKey.substring(0, 1));
                    qtUh++;
                    String qtRoom = qtUh + "";
                    uhKey = qtRoom + "x " + hu.getUh().getDsUh();
                    chavesUh.remove(count);
                    chavesUh.add(uhKey);
                } else {
                    chavesUh.add("1x " + hu.getUh().getDsUh());
                }
                vlQuarto = Utils.somar(vlQuarto, hu.getTarifa().getVlNeto());
            }

            chaveRoom = chavesUh.stream().map((chaveIt) -> chaveIt).reduce(chaveRoom, String::concat);

            chave = chaveRoom + "#" + tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getRegime().getDsRegime() + "#" + vlQuarto.toString();

            WSQuartoUh quartoUh = mapUhTarifaDisponivel.get(chave);
            if (quartoUh != null) {
                
                List<WSReservaHotelUh> reservaHotelUhListTemp = new ArrayList();

                reservaHotelUhListTemp.add(new WSReservaHotelUh(0,
                        quartoUh.getUh(),
                        quartoUh.getRegime(),
                        quartoUh.getTarifa(),
                        tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtEntrada(),
                        tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(0).getDtSaida(),
                        null,
                        WSReservaStatusEnum.SOLICITACAO));

                
                reservaHotelUhListTemp.forEach((rhuh) -> {
                    ParDisp parDispRetono[] = (ParDisp[]) UtilsWS.fromJson(rhuh.getUh().getDsParametro(), ParDisp[].class);
                    int sqQuarto = 0;
                    for (ParDisp p : parDispRetono) {
                        String dsParametro = UtilsWS.toJson(p);

                        WSUh uh = new WSUh(rhuh.getUh().getHotel(), rhuh.getUh().getCdUh(), rhuh.getUh().getIdExterno(), rhuh.getUh().getDsCategoria(), rhuh.getUh().getDsUh(), dsParametro);

                        Double vlNeto = Utils.dividir(rhuh.getTarifa().getVlNeto(), Double.parseDouble(parDispRetono.length + ""));

                        List<WSTarifaAdicional> tarifaAdicionalList = new ArrayList();
                        rhuh.getTarifa().getTarifaAdicionalList().forEach((ta) -> {
                            Double vltaxa = Utils.dividir(ta.getVlNeto(), Double.parseDouble(parDispRetono.length + ""));

                            tarifaAdicionalList.add(new WSTarifaAdicional(ta.getTpAdcional(),
                                    ta.getDsAdicional(),
                                    ta.getSgMoeda(),
                                    vltaxa));
                        });

                        WSTarifa tarifa = new WSTarifa(rhuh.getTarifa().getSgMoedaNeto(), vlNeto, tarifaAdicionalList);

                        reservaHotelUhList.add(new WSReservaHotelUh(sqQuarto,
                                uh,
                                rhuh.getRegime(),
                                tarifa,
                                rhuh.getDtEntrada(),
                                rhuh.getDtSaida(),
                                tarifarHotelRQ.getReservaHotel().getReservaHotelUhList().get(sqQuarto).getReservaNomeList(),
                                WSReservaStatusEnum.SOLICITACAO));
                        sqQuarto++;
                    }
                });

            } else {
                throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifar", WSMensagemErroEnum.HTA, "Quarto não disponivel", WSIntegracaoStatusEnum.NEGADO, null);
            }

        } catch (Exception ex) {
            throw new ErrorException(tarifarHotelRQ.getIntegrador(), TarifarWS.class, "tarifar", WSMensagemErroEnum.HTA, "Falha ao atribuir tarifa ao quarto", WSIntegracaoStatusEnum.NEGADO, ex);
        }
        
        AvailabilityAndPricingRequest availabilityAndPricingRequest = new AvailabilityAndPricingRequest();

        BookingOptions bookingOptions = new BookingOptions();

        RoomCombination roomCombination = new RoomCombination();

        String resultIndex = null;
        String sessionId = null;

        for (WSReservaHotelUh rhuh : reservaHotelUhList) {

            ParDisp parDispRetono = (ParDisp) UtilsWS.fromJson(rhuh.getUh().getDsParametro(), ParDisp.class);

            String result[] = parDispRetono.getA7().split("#");
            resultIndex = result[1];
            sessionId = result[0];

            roomCombination.getRoomIndex().add(Integer.parseInt(parDispRetono.getA0()));
        }

        bookingOptions.setFixedFormat(false);
        bookingOptions.getRoomCombination().add(roomCombination);

        availabilityAndPricingRequest.setResultIndex(Integer.parseInt(resultIndex));
        availabilityAndPricingRequest.setOptionsForBooking(bookingOptions);
        availabilityAndPricingRequest.setSessionId(sessionId);

        chamaWS.chamadaPadrao(tarifarHotelRQ.getIntegrador(), availabilityAndPricingRequest, AvailabilityAndPricingResponse.class);

        return reservaHotelUhList;
    }

}
