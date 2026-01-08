package com.docencia.pgv.repositorios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.docencia.pgv.modelo.Autor;

class InMemoryAutorRepositoryTest {

    @Test
    void findAll_debeDevolverCopia_yNoListaInterna() {
        InMemoryAutorRepository repo = new InMemoryAutorRepository();

        List<Autor> primera = repo.findAll();
        int sizeInicial = primera.size();

        // si modificamos la lista devuelta, no debe afectar al repo
        primera.clear();

        List<Autor> segunda = repo.findAll();
        assertEquals(sizeInicial, segunda.size());
        assertNotSame(primera, segunda);
    }

    @Test
    void findById_debeEncontrarYNoEncontrarCorrectamente() {
        InMemoryAutorRepository repo = new InMemoryAutorRepository();

        assertTrue(repo.findById(1L).isPresent());
        assertEquals("Gabriel García Márquez", repo.findById(1L).get().getNombre());

        assertTrue(repo.findById(999L).isEmpty());
        assertTrue(repo.findById(null).isEmpty());
    }

    @Test
    void save_conIdNull_debeGenerarIdNuevo() {
        InMemoryAutorRepository repo = new InMemoryAutorRepository();

        Autor nuevo = new Autor(null, "Nuevo Autor", "Portugal");
        Autor guardado = repo.save(nuevo);

        assertNotNull(guardado.getId());
        assertTrue(guardado.getId() >= 4L);
        assertTrue(repo.findById(guardado.getId()).isPresent());
        assertEquals("Nuevo Autor", repo.findById(guardado.getId()).get().getNombre());
    }

    @Test
    void save_conIdExistente_debeActualizar() {
        InMemoryAutorRepository repo = new InMemoryAutorRepository();

        Autor actualizado = new Autor(2L, "Isabel Allende (Edit)", "Chile");
        repo.save(actualizado);

        Autor a = repo.findById(2L).orElseThrow();
        assertEquals("Isabel Allende (Edit)", a.getNombre());
    }

    @Test
    void deleteById_y_deleteAll_funcionan() {
        InMemoryAutorRepository repo = new InMemoryAutorRepository();

        assertTrue(repo.deleteById(3L));
        assertTrue(repo.findById(3L).isEmpty());

        assertFalse(repo.deleteById(999L));
        assertFalse(repo.deleteById(null));

        repo.deleteAll();
        assertEquals(0, repo.findAll().size());
    }
}
