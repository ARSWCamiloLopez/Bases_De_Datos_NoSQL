/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.nosql.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import edu.eci.arsw.nosql.model.Accion;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arsw.nosql.services.NoSQLServices;

/**
 *
 * @author camilolopez
 */
@RestController
@RequestMapping(value = "/acciones")
@Service
public class NoSQLAPIController {

    @Autowired
    NoSQLServices pServices;

    /**
     *
     * @param identificador
     * @param intervalo
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "intradia/{identificador}")
    public ResponseEntity<?> obtenerAccionesIntradia(@PathVariable("identificador") String identificador) {
        try {
            return new ResponseEntity<>(pServices.obtenerAccionesIntradia(identificador),
                    HttpStatus.ACCEPTED);
        } catch (IOException ex) {
            return new ResponseEntity<>("No se han podido obtener las acciones", HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @param identificador
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "diaria/{identificador}")
    public ResponseEntity<?> obtenerAccionesDiarias(@PathVariable("identificador") String identificador) {
        try {
            return new ResponseEntity<>(pServices.obtenerAccionesDiarias(identificador),
                    HttpStatus.ACCEPTED);
        } catch (IOException ex) {
            return new ResponseEntity<>("No se han podido obtener las acciones", HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @param identificador
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "semanal/{identificador}")
    public ResponseEntity<?> obtenerAccionesSemanales(@PathVariable("identificador") String identificador) {
        try {
            return new ResponseEntity<>(pServices.obtenerAccionesSemanales(identificador),
                    HttpStatus.ACCEPTED);
        } catch (IOException ex) {
            return new ResponseEntity<>("No se han podido obtener las acciones", HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @param identificador
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "mensual/{identificador}")
    public ResponseEntity<?> obtenerAccionesMensuales(@PathVariable("identificador") String identificador) {
        try {
            return new ResponseEntity<>(pServices.obtenerAccionesMensuales(identificador),
                    HttpStatus.ACCEPTED);
        } catch (IOException ex) {
            return new ResponseEntity<>("No se han podido obtener las acciones", HttpStatus.NOT_FOUND);
        }
    }
}
