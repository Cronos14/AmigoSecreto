package com.tadeo.amigosecreto.utils;

import com.tadeo.amigosecreto.models.FactoryLogin;

/**
 * Created by Tadeo-developer on 26/12/16.
 */

public class Singleton {

    private static Singleton instance;

    private FactoryLogin factoryLogin;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }

        return instance;
    }

    public FactoryLogin getFactoryLogin() {
        return factoryLogin;
    }

    public void setFactoryLogin(FactoryLogin factoryLogin) {
        this.factoryLogin = factoryLogin;
    }
}
