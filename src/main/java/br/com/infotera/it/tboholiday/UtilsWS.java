package br.com.infotera.it.tboholiday;

import br.com.infotera.common.util.Utils;
import com.google.gson.Gson;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


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
