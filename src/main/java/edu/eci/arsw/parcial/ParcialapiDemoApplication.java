/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.eci.arsw.parcial;

import edu.eci.arsw.parcial.model.AccionRepository;
import edu.eci.arsw.parcial.controller.ParcialAPIController;
import edu.eci.arsw.parcial.model.Accion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParcialapiDemoApplication implements CommandLineRunner {

    @Autowired
    AccionRepository repository;
    
    @Autowired
    ParcialAPIController pServices;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ParcialapiDemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        repository.deleteAll();
        
        //Save MSFT daily shares
        repository.save(new Accion((String) pServices.obtenerAccionesDiarias("MSFT").getBody()));
        repository.save(new Accion((String) pServices.obtenerAccionesDiarias("FB").getBody()));
        
        for(Accion x : repository.findAll()){
            System.out.println(x);   
        }
    }

}
