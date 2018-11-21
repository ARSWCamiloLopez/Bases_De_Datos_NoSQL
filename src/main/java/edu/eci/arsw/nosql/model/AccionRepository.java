/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.nosql.model;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author camilo
 */
public interface AccionRepository extends MongoRepository<Accion, String>{
    
    /**
     *
     * @param nombreAccion
     * @return
     */
    public Accion findBynombreAccion(String nombreAccion);    
    
}
