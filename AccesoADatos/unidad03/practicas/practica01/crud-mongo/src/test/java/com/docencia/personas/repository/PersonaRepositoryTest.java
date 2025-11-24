package com.docencia.personas.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.personas.model.Direccion;
import com.docencia.personas.model.Persona;

@SpringBootTest
@ActiveProfiles
public class PersonaRepositoryTest {

    private PersonaRepository repository;
    private Persona personColection;
    private Direccion direccion;
    private Persona personFind;

    private String name = "Rashi";
    private int age = 20;
    private String email = "r@gmail.com";

    private String street = "some street";
    private String city = "some city";
    private String cp = "35632";
    private String country = "some contry";

    @Autowired
    public void setPersonaRepository(PersonaRepository repository) {
        this.repository = repository;
    }

    @BeforeEach
    void cleanDataBase() {
        repository.deleteAll();
        direccion = new Direccion(street, city, cp, country);
        personColection = new Persona(name, age, email, direccion);
        personFind = repository.save(personColection);
    }

    @Test
    void testFind() {
        Assertions.assertEquals(1, repository.count());
        Assertions.assertNotNull(personFind);
        Assertions.assertNotNull(personFind.getId());
    }

    @Test
    void testFindByCiudad() {
        List<Persona> foundByCiudad = repository.findByCiudad(city);
        Assertions.assertTrue(foundByCiudad.size() >= 1);
        Assertions.assertEquals(city, foundByCiudad.get(0).getDireccion().getCiudad());
    }

    @Test
    void testFindByEdadBetween() {
        int maxAge = 24;
        int minAge = 16;
        Assertions.assertTrue(minAge <= age && maxAge >= age);
        List<Persona> foundByAge = repository.findByEdadBetween(minAge, maxAge);
        Assertions.assertTrue(foundByAge.size() >= 1);
        Assertions.assertEquals(age, foundByAge.get(0).getEdad());
    }

    @Test
    void testFindByEmail() {
        Optional<Persona> person = repository.findByEmail(email);
        Assertions.assertEquals(email, person.get().getEmail() );
    }

    @Test
    void testFindByNombreContainingIgnoreCase() {

    }
}
