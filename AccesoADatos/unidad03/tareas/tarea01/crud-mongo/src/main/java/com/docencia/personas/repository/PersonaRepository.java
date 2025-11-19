package com.docencia.personas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.docencia.personas.model.Persona;

public interface PersonaRepository extends MongoRepository<Persona, String>{

    Optional<Persona> findByEmail(String email);

    List<Persona> findByNombreContainingIgnoreCase(String nombre);

    List<Persona> findByEdadBetween(Integer min, Integer max);

    @Query("{ 'direccion.ciudad': ?0 }")
    List<Persona> findByCiudad(String ciudad);
}
