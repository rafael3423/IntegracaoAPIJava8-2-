/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infotera.it.tboholiday;

import br.com.infotera.common.ErrorException;
import br.com.infotera.common.WSIntegrador;
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
import tektravel.hotelbookingapi.CancelPolicies;
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

}
