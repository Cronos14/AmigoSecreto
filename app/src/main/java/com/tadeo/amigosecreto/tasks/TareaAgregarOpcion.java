package com.tadeo.amigosecreto.tasks;

import android.support.v7.app.AppCompatActivity;

import com.tadeo.amigosecreto.ws.WebServices;

import org.json.JSONObject;

/**
 * Created by Tadeo-developer on 26/12/16.
 */

public class TareaAgregarOpcion extends Tarea {
    public TareaAgregarOpcion(AppCompatActivity appCompatActivity, String title) {
        super(appCompatActivity, title);
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        return WebServices.serviceAgregarOpcion(strings[0],strings[1]);
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);


        if(jsonObject!=null){
            if(jsonObject.optInt("code")==1){

                if(getOnPostExcecuteListener()!=null){
                    getOnPostExcecuteListener().onPostExecute(true);
                }

            }
        }
    }


}
