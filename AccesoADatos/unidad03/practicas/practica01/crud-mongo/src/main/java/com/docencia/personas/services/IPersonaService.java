package com.docencia.personas.services;

import java.util.List;

import com.docencia.personas.model.Persona;

public interface IPersonaService {

    public List<Persona> findAll();
    public Persona findById(String id);
    public Persona save(Persona persona);
    public Boolean deleteById(String id);
}
