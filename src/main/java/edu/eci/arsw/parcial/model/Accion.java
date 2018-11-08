/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.model;

import org.springframework.data.annotation.Id;

/**
 *
 * @author camilolopez
 */
public class Accion {

    @Id
    public String id;

    public String stringAccion;

    public Accion() {
    }

    public Accion(String stringAccion) {
        this.stringAccion = stringAccion;
    }

    public String getStringAccion() {
        return stringAccion;
    }

    public void setStringAccion(String stringAccion) {
        this.stringAccion = stringAccion;
    }

    @Override
    public String toString() {
        return "Accion: " + stringAccion;
    }
}
