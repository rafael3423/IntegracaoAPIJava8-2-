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
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.ChamaWS;
import br.com.infotera.it.tboholiday.ParDisp;
import br.com.infotera.it.tboholiday.UtilsWS;
import java.util.ArrayList;
import java.util.List;
import tektravel.hotelbookingapi.AvailabilityAndPricingRequest;
import tektravel.hotelbookingapi.AvailabilityAndPricingResponse;
import tektravel.hotelbookingapi.BookingOptions;
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

        List<WSReservaHotelUh> reservaHotelUhListFormarado = montaReservaHotelUhList(tarifarHotelRS.getReservaHotel().getReservaHotelUhList());

        String resultIndex = null;
        String sessionId = null;
        String parametroReservaHotel = null;

        for (WSReservaHotelUh rhuh : reservaHotelUhListFormarado) {
            ParDisp parDispRetono = (ParDisp) UtilsWS.fromJson(rhuh.getUh().getDsParametro(), ParDisp.class);

            String result[] = parDispRetono.getA7().split("#");
            resultIndex = result[1];
            sessionId = result[0];

            parametroReservaHotel = parDispRetono.getA7();
            
            roomCombination.getRoomIndex().add(Integer.parseInt(parDispRetono.getA0()));
        }

        bookingOptions.setFixedFormat(false);
        bookingOptions.getRoomCombination().add(roomCombination);

        availabilityAndPricingRequest.setResultIndex(Integer.parseInt(resultIndex));
        availabilityAndPricingRequest.setOptionsForBooking(bookingOptions);
        availabilityAndPricingRequest.setSessionId(sessionId);

        AvailabilityAndPricingResponse availabilityAndPricingResponse = chamaWS.chamadaPadrao(preReservarRQ.getIntegrador(), availabilityAndPricingRequest, AvailabilityAndPricingResponse.class);

        String normasHotel = "";

        for (String s : availabilityAndPricingResponse.getHotelCancellationPolicies().getHotelNorms().getString()) {

            if (normasHotel.equals("")) {
                normasHotel = s + "; " + availabilityAndPricingResponse.getHotelCancellationPolicies().getCancelPolicies().getDefaultPolicy();
            } else {
                normasHotel = normasHotel + "; " + s;
            }

        }

        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();

        int sqQuarto = 0;
        Double vlTotalTodosQuartos = 0.0;
        String vlTotalCadaQuarto = "";

        for (WSReservaHotelUh rhu : reservaHotelUhListFormarado) {

            vlTotalCadaQuarto += Utils.somar(rhu.getTarifa().getVlNeto(), rhu.getTarifa().getTarifaAdicionalList().get(0).getVlNeto()) + "#";
            vlTotalTodosQuartos += Utils.somar(rhu.getTarifa().getVlNeto(), rhu.getTarifa().getTarifaAdicionalList().get(0).getVlNeto());
        }

        try {
            for (WSReservaHotelUh rhu : reservaHotelUhListFormarado) {

                List<WSPolitica> politicaCancelamentoList = new ArrayList();

                UtilsWS utilsWS = new UtilsWS();

                Double diferencaEmDias = Double.parseDouble(Utils.diferencaEmDias(rhu.getDtEntrada(), rhu.getDtSaida()).toString());
                String vlTotal = vlTotalTodosQuartos + "#" + vlTotalCadaQuarto;

                if (availabilityAndPricingResponse.getHotelCancellationPolicies() != null && !availabilityAndPricingResponse.getHotelCancellationPolicies().equals("") && sqQuarto == 0) {
                    politicaCancelamentoList = utilsWS.montaPolitica(preReservarRQ.getIntegrador(),
                            availabilityAndPricingResponse.getHotelCancellationPolicies().getCancelPolicies(),
                            vlTotal,
                            diferencaEmDias,
                            normasHotel);
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
                        rhu.getUh().getDsParametro() + "%" + tarifarHotelRS.getReservaHotel().getDsParametro());

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
        reservaHotel.setDsParametro(parametroReservaHotel);

        WSReserva reserva = new WSReserva(reservaHotel);

        return new WSPreReservarRS(reserva, preReservarRQ.getIntegrador(), WSIntegracaoStatusEnum.OK);
    }

    private List<WSReservaHotelUh> montaReservaHotelUhList(List<WSReservaHotelUh> reservaHotelUhListChegada) {

        List<WSReservaHotelUh> reservaHotelUhList = new ArrayList();
        for (WSReservaHotelUh rhuh : reservaHotelUhListChegada) {
            ParDisp parDispRetono[] = (ParDisp[]) UtilsWS.fromJson(rhuh.getUh().getDsParametro(), ParDisp[].class);
            int sqQuarto = 0;
            for (ParDisp p : parDispRetono) {

                rhuh.getUh().setDsParametro(UtilsWS.toJson(p));
                reservaHotelUhList.add(new WSReservaHotelUh(sqQuarto,
                        rhuh.getUh(),
                        rhuh.getRegime(),
                        rhuh.getTarifa(),
                        rhuh.getDtEntrada(),
                        rhuh.getDtSaida(),
                        Utils.gerarWSReservaNome(p.getA3()),
                        WSReservaStatusEnum.SOLICITACAO));

                sqQuarto++;
            }

        }

        return reservaHotelUhList;
    }

}
