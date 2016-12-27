package com.tadeo.amigosecreto.models;

import java.util.ArrayList;

/**
 * Created by Tadeo-developer on 26/12/16.
 */

public class FactoryLogin {

    private Usuario usuario;
    private ArrayList<Opcion> opciones;
    private Usuario personaSecreta;
    private ArrayList<Opcion> opcionesPersonaSecreta;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(ArrayList<Opcion> opciones) {
        this.opciones = opciones;
    }

    public Usuario getPersonaSecreta() {
        return personaSecreta;
    }

    public void setPersonaSecreta(Usuario personaSecreta) {
        this.personaSecreta = personaSecreta;
    }

    public ArrayList<Opcion> getOpcionesPersonaSecreta() {
        return opcionesPersonaSecreta;
    }

    public void setOpcionesPersonaSecreta(ArrayList<Opcion> opcionesPersonaSecreta) {
        this.opcionesPersonaSecreta = opcionesPersonaSecreta;
    }
}
