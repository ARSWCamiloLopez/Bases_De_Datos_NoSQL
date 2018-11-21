/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.nosql.model;

import org.springframework.data.annotation.Id;

/**
 *
 * @author camilolopez
 */
public class Accion {

    @Id
    public String id;

    private String nombreAccion;
    private String stringAccion;
    private String tiempo;

    public Accion() {
    }

    public Accion(String nombreAccion, String tiempo, String stringAccion) {
        this.nombreAccion = nombreAccion;
        this.tiempo = tiempo;
        this.stringAccion = stringAccion;
    }

    public String getStringAccion() {
        return stringAccion;
    }

    public void setStringAccion(String stringAccion) {
        this.stringAccion = stringAccion;
    }

    public String getNombreAccion() {
        return nombreAccion;
    }

    public void setNombreAccion(String nombreAccion) {
        this.nombreAccion = nombreAccion;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Accion: " + stringAccion;
    }
}
