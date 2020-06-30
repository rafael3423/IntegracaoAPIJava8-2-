package br.com.infotera.it.tboholiday.monta;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSIntegrador;
import br.com.infotera.common.WSPreReservarRQ;
import br.com.infotera.common.WSPreReservarRS;
import br.com.infotera.common.WSReserva;
import br.com.infotera.common.WSReservaHotel;
import br.com.infotera.common.WSReservaHotelUh;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.WSTarifa;
import br.com.infotera.common.WSTarifaAdicional;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSMensagemErroEnum;
import br.com.infotera.common.enumerator.WSReservaStatusEnum;
import br.com.infotera.common.hotel.WSUh;
import br.com.infotera.common.hotel.rqrs.WSTarifarHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSTarifarHotelRS;
import br.com.infotera.common.politica.WSPolitica;
import br.com.infotera.common.politica.WSPoliticaCancelamento;
import br.com.infotera.common.politica.WSPoliticaCondicaoGeral;
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.ChamaWS;
import br.com.infotera.it.tboholiday.ParDisp;
import br.com.infotera.it.tboholiday.UtilsWS;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tektravel.hotelbookingapi.AvailabilityAndPricingRequest;
import tektravel.hotelbookingapi.AvailabilityAndPricingResponse;
import tektravel.hotelbookingapi.BookingOptions;
import tektravel.hotelbookingapi.CancelPolicies;
import tektravel.hotelbookingapi.CancellationChargeTypeForHotel;
import tektravel.hotelbookingapi.RoomCombination;

public class PreReservarWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSPreReservarRS preReservar(WSPreReservarRQ preReservarRQ) throws ErrorException {

        TarifarWS tarifarWS = new TarifarWS();

        preReservarRQ.getReserva().getReservaHotel().setReservaStatus(WSReservaStatusEnum.ORCAMENTO);

        WSTarifarHotelRS tarifarHotelRS = tarifarWS.tarifarHotel(new WSTarifarHotelRQ(preReservarRQ.getIntegrador(), preReservarRQ.getReserva().getReservaHotel()));

        AvailabilityAndPricingRequest availabilityAndPricingRequest = new AvailabilityAndPricingRequest();

        BookingOptions bookingOptions = new BookingOptions();

        RoomCombination roomCombination = new RoomCombination();

        List<WSReservaHotelUh> reservaHotelUhListFormarado = montaReservaHotelUhList(tarifarHotelRS.getReservaHotel().getReservaHotelUhList(), preReservarRQ.getIntegrador());

        String resultIndex = null;
        String sessionId = null;
        String parametroReservaHotel = null;

        try {
            for (WSReservaHotelUh rhuh : reservaHotelUhListFormarado) {
                ParDisp parDispRetono = (ParDisp) UtilsWS.fromJson(rhuh.getUh().getDsParametro(), ParDisp.class);

                String result[] = parDispRetono.getA7().split("#");
                resultIndex = result[1];
                sessionId = result[0];

                parametroReservaHotel = parDispRetono.getA7();

                roomCombination.getRoomIndex().add(Integer.parseInt(parDispRetono.getA0()));
            }
        } catch (Exception ex) {
            throw new ErrorException(preReservarRQ.getIntegrador(), PreReservarWS.class, "preReservar", WSMensagemErroEnum.HPR, "Ocorreu uma falha ao efetuar a pré reserva do quarto", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        bookingOptions.setFixedFormat(true);
        bookingOptions.getRoomCombination().add(roomCombination);

        availabilityAndPricingRequest.setResultIndex(Integer.parseInt(resultIndex));
        availabilityAndPricingRequest.setOptionsForBooking(bookingOptions);
        availabilityAndPricingRequest.setSessionId(sessionId);

        AvailabilityAndPricingResponse availabilityAndPricingResponse = chamaWS.chamadaPadrao(preReservarRQ.getIntegrador(), availabilityAndPricingRequest, AvailabilityAndPricingResponse.class);

        String normasHotel = "";

        try {
            for (String s : availabilityAndPricingResponse.getHotelCancellationPolicies().getHotelNorms().getString()) {

                if (normasHotel.equals("")) {
                    normasHotel = s + "<br/>" + availabilityAndPricingResponse.getHotelCancellationPolicies().getCancelPolicies().getDefaultPolicy();
                } else {
                    normasHotel = normasHotel + "<br/>" + s;
                }

            }
        } catch (Exception ex) {
            throw new ErrorException(preReservarRQ.getIntegrador(), PreReservarWS.class, "preReservar", WSMensagemErroEnum.HPR, "Ocorreu uma falha ao efetuar a pré reserva do quarto", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();

        int count = 1;
        int sqQuarto = 0;
        String nmQuarto[] = null;
        String nmQuartoFinal = null;

        try {
            for (WSReservaHotelUh rhu : reservaHotelUhListFormarado) {

                List<WSPolitica> politicaCancelamentoList = new ArrayList();

                if (normasHotel != null && !normasHotel.equals("")) {
                    politicaCancelamentoList.add(new WSPoliticaCondicaoGeral("Condição geral", normasHotel));
                }

                Double diferencaEmDias = Double.parseDouble(Utils.diferencaEmDias(rhu.getDtEntrada(), rhu.getDtSaida()).toString());
                Double vlDiaria = Utils.dividir(rhu.getTarifa().getVlNeto(), diferencaEmDias);

                if (availabilityAndPricingResponse.getHotelCancellationPolicies() != null && availabilityAndPricingResponse.getHotelCancellationPolicies().getCancelPolicies() != null) {

                    politicaCancelamentoList.addAll(montaPoliticaCancelamento(availabilityAndPricingResponse.getHotelCancellationPolicies().getCancelPolicies(), vlDiaria, preReservarRQ.getIntegrador(), count));
                }

                WSTarifa tarifa = new WSTarifa(rhu.getTarifa().getSgMoedaNeto(),
                        rhu.getTarifa().getVlNeto(),
                        null,
                        rhu.getTarifa().getCdTarifa(),
                        null,
                        politicaCancelamentoList,
                        rhu.getTarifa().getTarifaAdicionalList());

                if (nmQuarto == null) {
                    if (rhu.getUh().getDsCategoria().contains("<br/>")) {
                        nmQuarto = rhu.getUh().getDsCategoria().split("<br/>");
                    } else {
                        nmQuartoFinal = rhu.getUh().getDsCategoria();
                    }
                }

                if (nmQuarto != null) {
                    nmQuartoFinal = nmQuarto[sqQuarto];
                }

                nmQuartoFinal = nmQuartoFinal.substring(3, nmQuartoFinal.length());

                WSUh uh = new WSUh(null,
                        rhu.getUh().getCdUh(),
                        nmQuartoFinal,
                        nmQuartoFinal,
                        rhu.getUh().getDsParametro());

                List<WSReservaNome> reservaNomeList = new ArrayList();
                try {
                    rhu.getReservaNomeList().stream().map((rn) -> {
                        reservaNomeList.add(new WSReservaNome(rn.getNmNome(),
                                rn.getNmSobrenome(),
                                rn.getPaxTipo(),
                                rn.getDtNascimento(),
                                rn.getQtIdade(),
                                rn.getSexo()));
                        return rn;
                    }).forEachOrdered((_item) -> {
                        rhu.setReservaNomeList(reservaNomeList);
                    });
                } catch (Exception ex) {
                    throw new ErrorException(preReservarRQ.getIntegrador(), PreReservarWS.class, "preReservar", WSMensagemErroEnum.HPR, "Ocorreu uma falha ao efetuar a pré reserva do quarto", WSIntegracaoStatusEnum.NEGADO, ex);
                }

                reservaHotelUhList.add(new WSReservaHotelUh(sqQuarto++,
                        uh,
                        rhu.getRegime(),
                        tarifa,
                        rhu.getDtEntrada(),
                        rhu.getDtSaida(),
                        reservaNomeList,
                        WSReservaStatusEnum.SOLICITACAO));

                count++;
            }
        } catch (Exception ex) {
            throw new ErrorException(preReservarRQ.getIntegrador(), PreReservarWS.class, "preReservar", WSMensagemErroEnum.HPR, "Ocorreu uma falha ao efetuar a pré reserva do quarto", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        WSReservaHotel reservaHotel = new WSReservaHotel(reservaHotelUhList);
        reservaHotel.setHotel(preReservarRQ.getReserva().getReservaHotel().getHotel());
        reservaHotel.setDsParametro(parametroReservaHotel);

        WSReserva reserva = new WSReserva(reservaHotel);

        return new WSPreReservarRS(reserva, preReservarRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);
    }

    private List<WSReservaHotelUh> montaReservaHotelUhList(List<WSReservaHotelUh> reservaHotelUhListChegada, WSIntegrador integrador) throws ErrorException {

        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();
        try {
            reservaHotelUhListChegada.forEach((rhuh) -> {
                ParDisp parDispRetono[] = (ParDisp[]) UtilsWS.fromJson(rhuh.getUh().getDsParametro(), ParDisp[].class);
                int sqQuarto = 0;
                
                for (ParDisp p : parDispRetono) {
                    String dsParametro = UtilsWS.toJson(p);

                    WSUh uh = new WSUh(rhuh.getUh().getHotel(), p.getA1(), rhuh.getUh().getIdExterno(), rhuh.getUh().getDsCategoria(), rhuh.getUh().getDsUh(), dsParametro);

                    Double vlNeto = Utils.dividir(rhuh.getTarifa().getVlNeto(), Double.parseDouble(parDispRetono.length + ""));

                    List<WSTarifaAdicional> tarifaAdicionalList = new ArrayList();
                    rhuh.getTarifa().getTarifaAdicionalList().forEach((ta) -> {
                        Double vltaxa = Utils.dividir(ta.getVlNeto(), Double.parseDouble(parDispRetono.length + ""));

                        tarifaAdicionalList.add(new WSTarifaAdicional(ta.getTpAdcional(),
                                ta.getDsAdicional(),
                                ta.getSgMoeda(),
                                vltaxa));
                    });

                    WSTarifa tarifa = new WSTarifa(rhuh.getTarifa().getSgMoedaNeto(), vlNeto, null, p.getA2(), null, null, tarifaAdicionalList);

                    reservaHotelUhList.add(new WSReservaHotelUh(sqQuarto,
                            uh,
                            rhuh.getRegime(),
                            tarifa,
                            rhuh.getDtEntrada(),
                            rhuh.getDtSaida(),
                            Utils.gerarWSReservaNome(p.getA3()),
                            WSReservaStatusEnum.SOLICITACAO));
                    sqQuarto++;
                }
            });
        } catch (Exception ex) {
            throw new ErrorException(integrador, PreReservarWS.class, "montaReservaHotelUhList", WSMensagemErroEnum.HLI, "Ocorreu uma falha ao gerar lista de reservas", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        return reservaHotelUhList;
    }

    private List<WSPolitica> montaPoliticaCancelamento(CancelPolicies cancelPolicies, Double vlDiaria, WSIntegrador integrador, int sqQuarto) throws ErrorException {

        List<WSPolitica> politicaList = new ArrayList();

        if (cancelPolicies != null && cancelPolicies.getCancelPolicy() != null) {
            try {
                cancelPolicies.getCancelPolicy().forEach((cp) -> {

                    Double pcCancelamento = null;
                    Double vlCancelamento = null;

                    if (cp.getRoomIndex() != null) {
                        if (cp.getRoomIndex().equals(sqQuarto)) {
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
                        }

                    } else {
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
                throw new ErrorException(integrador, PreReservarWS.class, "montaPoliticaCancelamento", WSMensagemErroEnum.HPR, "Ocorreu uma falha ao gerar politicas de cancelamento", WSIntegracaoStatusEnum.NEGADO, ex);
            }
        }

        return politicaList;
    }

}
