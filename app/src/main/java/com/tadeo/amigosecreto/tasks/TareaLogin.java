package com.tadeo.amigosecreto.tasks;

import android.support.v7.app.AppCompatActivity;

import com.tadeo.amigosecreto.models.FactoryLogin;
import com.tadeo.amigosecreto.models.Opcion;
import com.tadeo.amigosecreto.models.Usuario;
import com.tadeo.amigosecreto.ws.WebServices;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Tadeo-developer on 26/12/16.
 */

public class TareaLogin extends Tarea {
    public TareaLogin(AppCompatActivity appCompatActivity, String title) {
        super(appCompatActivity, title);
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        return WebServices.serviceLogin(strings[0]);
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);


        if(jsonObject!=null){
            if(jsonObject.optInt("code")==1){

                Usuario usuario = getUsuario(jsonObject.optJSONObject("usuario"));

                ArrayList<Opcion> opcionesUsuario = getOpciones(jsonObject.optJSONArray("opciones_usuario"));

                Usuario personaSecreta = getUsuario(jsonObject.optJSONObject("persona_secreta"));

                ArrayList<Opcion> opcionesPersonaSecreta = getOpciones(jsonObject.optJSONArray("opciones_persona_secreta"));

                FactoryLogin factoryLogin = new FactoryLogin();
                factoryLogin.setUsuario(usuario);
                factoryLogin.setOpciones(opcionesUsuario);
                factoryLogin.setPersonaSecreta(personaSecreta);
                factoryLogin.setOpcionesPersonaSecreta(opcionesPersonaSecreta);

                if(getOnPostExcecuteListener()!=null){
                    getOnPostExcecuteListener().onPostExecute(factoryLogin);
                }

            }
        }
    }

    private Usuario getUsuario(JSONObject jsonObjectUsuario){
        Usuario usuario = new Usuario();
        usuario.setId(jsonObjectUsuario.optInt("id"));
        usuario.setIdPush(jsonObjectUsuario.optString("id_push"));
        usuario.setNombre(jsonObjectUsuario.optString("nombre"));
        usuario.setContrasenia(jsonObjectUsuario.optString("contrasenia"));

        return usuario;
    }

    private ArrayList<Opcion> getOpciones(JSONArray jsonArrayOpciones){

        ArrayList<Opcion> opcionesUsuario = new ArrayList<>();
        for(int i = 0;i<jsonArrayOpciones.length();i++){
            JSONObject jsonObjectOpcionUsuario = jsonArrayOpciones.optJSONObject(i);

            Opcion opcion = new Opcion();
            opcion.setId(jsonObjectOpcionUsuario.optInt("id"));
            opcion.setIdUsuario(jsonObjectOpcionUsuario.optInt("id_usuario"));
            opcion.setNombre(jsonObjectOpcionUsuario.optString("nombre"));
            opcionesUsuario.add(opcion);
        }

        return opcionesUsuario;
    }
}
