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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParcialapiDemoApplication implements CommandLineRunner {

    @Autowired
    AccionRepository repository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ParcialapiDemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        repository.deleteAll();
    }

}
