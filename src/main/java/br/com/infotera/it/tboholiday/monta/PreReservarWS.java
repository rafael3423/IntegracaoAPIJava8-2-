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
import br.com.infotera.common.enumerator.WSMensagemErroEnum;
import br.com.infotera.common.enumerator.WSReservaStatusEnum;
import br.com.infotera.common.hotel.WSUh;
import br.com.infotera.common.hotel.rqrs.WSTarifarHotelRQ;
import br.com.infotera.common.hotel.rqrs.WSTarifarHotelRS;
import br.com.infotera.common.politica.WSPolitica;
import br.com.infotera.common.politica.WSPoliticaCancelamento;
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
import tektravel.hotelbookingapi.CancelPolicy;
import tektravel.hotelbookingapi.RoomCombination;

public class PreReservarWS {

    ChamaWS chamaWS = new ChamaWS();

    public WSPreReservarRS preReservar(WSPreReservarRQ preReservarRQ) throws ErrorException {

        TarifarWS tarifarWS = new TarifarWS();
        
        preReservarRQ.getReserva().getReservaHotel().setReservaStatus(WSReservaStatusEnum.ORCAMENTO);

        WSTarifarHotelRS tarifarHotelRS = tarifarWS.tarifarHotel(new WSTarifarHotelRQ(preReservarRQ.getIntegrador(), preReservarRQ.getReserva().getReservaHotel()));

        AvailabilityAndPricingRequest availabilityAndPricingRequest = new AvailabilityAndPricingRequest();

        String chvSessao[] = tarifarHotelRS.getReservaHotel().getDsParametro().split("#");

        BookingOptions bookingOptions = new BookingOptions();

        RoomCombination roomCombination = new RoomCombination();

        for (WSReservaHotelUh rhuh : tarifarHotelRS.getReservaHotel().getReservaHotelUhList()) {
            ParDisp parDispRetono = (ParDisp) UtilsWS.fromJson(rhuh.getUh().getDsParametro(), ParDisp.class);
            roomCombination.getRoomIndex().add(Integer.parseInt(parDispRetono.getA0()));
        }

        bookingOptions.setFixedFormat(false);
        bookingOptions.getRoomCombination().add(roomCombination);

        availabilityAndPricingRequest.setResultIndex(Integer.parseInt(chvSessao[1]));
        availabilityAndPricingRequest.setOptionsForBooking(bookingOptions);
        availabilityAndPricingRequest.setSessionId(chvSessao[0]);

        AvailabilityAndPricingResponse availabilityAndPricingResponse = chamaWS.chamadaPadrao(preReservarRQ.getIntegrador(), availabilityAndPricingRequest, AvailabilityAndPricingResponse.class);

        String normasHotel = "";

        for (String s : availabilityAndPricingResponse.getHotelCancellationPolicies().getHotelNorms().getString()) {

            if (normasHotel.equals("")) {
                normasHotel = s;
            } else {
                normasHotel = normasHotel + "; " + s;
            }

        }

        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();

        int sqQuarto = 0;

        try {
            for (WSReservaHotelUh rhu : tarifarHotelRS.getReservaHotel().getReservaHotelUhList()) {

                List<WSPolitica> politicaCancelamentoList = new ArrayList();

                if (availabilityAndPricingResponse.getHotelCancellationPolicies() != null && !availabilityAndPricingResponse.getHotelCancellationPolicies().equals("")) {
                    if (availabilityAndPricingResponse.getHotelCancellationPolicies().getCancelPolicies() != null && !availabilityAndPricingResponse.getHotelCancellationPolicies().getCancelPolicies().equals("")) {
                        try {
                            for (CancelPolicy cp : availabilityAndPricingResponse.getHotelCancellationPolicies().getCancelPolicies().getCancelPolicy()) {

                                Double vlCancelamento = 0.0;

                                Double vlTotal = Utils.somar(rhu.getTarifa().getVlNeto(), rhu.getTarifa().getTarifaAdicionalList().get(0).getVlNeto());

                                Double vlDiaria = Utils.dividir(vlTotal, Double.parseDouble(Utils.diferencaEmDias(rhu.getDtEntrada(), rhu.getDtSaida()).toString()));

                                if (cp.getChargeType().toString().toUpperCase().equals("FIXED")) {
                                    vlCancelamento = Double.parseDouble(cp.getCancellationCharge().toString());

                                } else if (cp.getChargeType().toString().toUpperCase().equals("PERCENTAGE")) {
                                    vlCancelamento = Utils.dividir(Utils.multiplicar(vlTotal, Double.parseDouble(cp.getCancellationCharge().toString())), 100.00);

                                } else if (cp.getChargeType().toString().toUpperCase().equals("NIGHT")) {
                                    vlCancelamento = Utils.multiplicar(vlDiaria, Double.parseDouble(cp.getCancellationCharge().toString()));
                                }

                                Boolean stImediata = false;
                                Boolean stNaoRefundable = false;

                                Date dtMinimaCancelamento = Utils.addDias(Utils.toDate(cp.getFromDate(), "yyyy-MM-dd"), -3);

                                if (new Date().compareTo(dtMinimaCancelamento) == 1) {
                                    stImediata = true;
                                }

                                WSPoliticaCancelamento politicaCancelamento = new WSPoliticaCancelamento(cp.getRoomTypeName(),
                                        normasHotel,
                                        cp.getCurrency(),
                                        vlCancelamento,
                                        null,
                                        null,
                                        stImediata,
                                        Utils.toDate(cp.getFromDate(), "yyyy-MM-dd"),
                                        Utils.toDate(cp.getToDate(), "yyyy-MM-dd"),
                                        stNaoRefundable);
                                
                                ParDisp pd = (ParDisp) UtilsWS.fromJson(rhu.getUh().getDsParametro(), ParDisp.class);

                                if (cp.getRoomIndex() != null && !cp.getRoomIndex().equals("")) {
                                    if (!vlCancelamento.equals(0.0) && cp.getRoomIndex().equals(pd.getA0())) {
                                        politicaCancelamentoList.add(politicaCancelamento);
                                    }
                                } else if (!vlCancelamento.equals(0.0)) {
                                    politicaCancelamentoList.add(politicaCancelamento);
                                }

                            }
                        } catch (Exception ex) {
                            throw new ErrorException(preReservarRQ.getIntegrador(), PreCancelarReservaWS.class, "preReservar", WSMensagemErroEnum.HPR, "Ocorreu uma falha ao gerar politicas de cancelamento", WSIntegracaoStatusEnum.NEGADO, ex);
                        }
                    }
                }

                WSTarifa tarifa = new WSTarifa(rhu.getTarifa().getSgMoedaNeto(),
                        rhu.getTarifa().getVlNeto(),
                        null,
                        rhu.getTarifa().getCdTarifa(),
                        null,
                        politicaCancelamentoList,
                        rhu.getTarifa().getTarifaAdicionalList());

                WSUh uh = new WSUh(null,
                        rhu.getUh().getCdUh(),
                        rhu.getUh().getDsCategoria(),
                        rhu.getUh().getDsUh(),
                        rhu.getUh().getDsParametro());

                List<WSReservaNome> reservaNomeList = new ArrayList();
                try {
                    for (WSReservaNome rn : rhu.getReservaNomeList()) {

                        reservaNomeList.add(new WSReservaNome(rn.getNmNome(),
                                rn.getNmSobrenome(),
                                rn.getPaxTipo(),
                                rn.getDtNascimento(),
                                rn.getQtIdade(),
                                rn.getSexo()));

                        rhu.setReservaNomeList(reservaNomeList);
                    }
                } catch (Exception ex) {
                    throw new ErrorException(preReservarRQ.getIntegrador(), PreReservarWS.class, "preReservar", WSMensagemErroEnum.HPR, "Ocorreu uma falha ao efetuar a pré reserva do quarto", WSIntegracaoStatusEnum.NEGADO, ex);
                }

                sqQuarto++;

                reservaHotelUhList.add(new WSReservaHotelUh(sqQuarto,
                        uh,
                        rhu.getRegime(),
                        tarifa,
                        rhu.getDtEntrada(),
                        rhu.getDtSaida(),
                        reservaNomeList,
                        WSReservaStatusEnum.SOLICITACAO));
            }
        } catch (Exception ex) {

            throw new ErrorException(preReservarRQ.getIntegrador(), PreReservarWS.class, "preReservar", WSMensagemErroEnum.HPR, "Ocorreu uma falha ao efetuar a pré reserva do quarto", WSIntegracaoStatusEnum.NEGADO, ex);
        }

        WSReservaHotel reservaHotel = new WSReservaHotel(reservaHotelUhList);
        reservaHotel.setHotel(preReservarRQ.getReserva().getReservaHotel().getHotel());
        reservaHotel.setDsParametro(preReservarRQ.getReserva().getReservaHotel().getDsParametro());

        WSReserva reserva = new WSReserva(reservaHotel);

        return new WSPreReservarRS(reserva, preReservarRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);
    }
}
