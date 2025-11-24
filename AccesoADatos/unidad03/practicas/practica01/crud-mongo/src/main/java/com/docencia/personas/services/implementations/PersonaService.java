package com.docencia.personas.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docencia.personas.model.Persona;
import com.docencia.personas.repository.PersonaRepository;
import com.docencia.personas.services.IPersonaService;

@Service()
public class PersonaService implements IPersonaService{

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona findById(String id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Boolean deleteById(String id) {
        personaRepository.deleteById(id);
        return true;
    }

}
