/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.services;

import java.io.IOException;

/**
 *
 * @author camilolopez
 */
public interface ParcialServices {

    /**
     *
     * @param identificador
     * @param intervalo
     * @return
     * @throws java.io.IOException
     */
    public String obtenerAccionesIntradia(String identificador) throws IOException;
    
    /**
     *
     * @param identificador
     * @return
     * @throws IOException
     */
    public String obtenerAccionesDiarias(String identificador) throws IOException;
    
    /**
     *
     * @param identificador
     * @return
     * @throws IOException
     */
    public String obtenerAccionesSemanales(String identificador) throws IOException;
    
    /**
     *
     * @param identificador
     * @return
     * @throws IOException
     */
    public String obtenerAccionesMensuales(String identificador) throws IOException;
}
