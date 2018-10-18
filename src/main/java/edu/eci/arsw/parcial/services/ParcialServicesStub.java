/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.services;

import edu.eci.arsw.parcial.persistence.ParcialPersistence;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author camilolopez
 */
@Service
public class ParcialServicesStub implements ParcialServices {

    @Autowired
    ParcialPersistence pPersis;

    @Override
    public String obtenerAccionesIntradia(String identificador) throws IOException {
        return pPersis.obtenerAccionesIntraDia(identificador);
    }

    @Override
    public String obtenerAccionesDiarias(String identificador) throws IOException {
        return pPersis.obtenerAccionesDiarias(identificador);
    }

    @Override
    public String obtenerAccionesSemanales(String identificador) throws IOException {
        return pPersis.obtenerAccionesSemanales(identificador);
    }

    @Override
    public String obtenerAccionesMensuales(String identificador) throws IOException {
        return pPersis.obtenerAccionesMensuales(identificador);
    }

}
