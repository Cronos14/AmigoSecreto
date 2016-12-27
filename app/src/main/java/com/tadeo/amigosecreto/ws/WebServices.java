package com.tadeo.amigosecreto.ws;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Tadeo-developer on 22/11/16.
 */

public class WebServices {

    public static final String URL = "http://luctadeveloper.com/amigo_secreto/";
    public static final String REGISTRAR = "login.php";

    public static JSONObject serviceLogin(String nombreUsuario){

        JSONObject params = new JSONObject();
        try {
            params.put("nombreUsuario",nombreUsuario);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return Request.request(URL+REGISTRAR,params.toString(),true,"POST");
    }

}
