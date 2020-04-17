/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infotera.it.tboholiday;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSReservaNome;
import br.com.infotera.common.enumerator.WSIntegracaoStatusEnum;
import br.com.infotera.common.enumerator.WSMensagemErroEnum;
import br.com.infotera.common.enumerator.WSPaxTipoEnum;
import br.com.infotera.common.hotel.WSRegime;
import br.com.infotera.common.hotel.WSUh;
import br.com.infotera.common.politica.WSPolitica;
import br.com.infotera.common.politica.WSPoliticaCancelamento;
import br.com.infotera.common.util.Utils;
import br.com.infotera.it.tboholiday.monta.ConsultarReservaWS;
import br.com.infotera.it.tboholiday.monta.PreCancelarReservaWS;
import com.google.gson.Gson;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import tektravel.hotelbookingapi.CancelPolicy;
import tektravel.hotelbookingapi.Guest;

/**
 *
 * @author rafael
 */
public class UtilsWS {

    public static String toJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static Object fromJson(String json, Class classe) {
        Gson gson = new Gson();
        return gson.fromJson(json, classe);
    }

    public static Date dtFormatadaddMMMyyyy(String dtddMMMyyyy) {

        DateFormat shortFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        DateFormat mediumFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String shortDate = null;
        try {
            shortDate = shortFormat.format(mediumFormat.parse(dtddMMMyyyy));
        } catch (java.text.ParseException ex) {
        }
        return Utils.toDate(shortDate, "dd-MM-yyyy");

    }

    public WSPoliticaCancelamento montaPolitica() {

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
                            if (!vlCancelamento.equals(0.0) && cp.getRoomIndex().equals(roomIndex)) {
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
    }
}
