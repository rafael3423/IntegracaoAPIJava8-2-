/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infotera.it.tboholiday;

import com.google.gson.Gson;

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

}
