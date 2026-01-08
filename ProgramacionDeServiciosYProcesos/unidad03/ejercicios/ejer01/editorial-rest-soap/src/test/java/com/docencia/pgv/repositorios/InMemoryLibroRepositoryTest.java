package com.docencia.pgv.repositorios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.docencia.pgv.modelo.Libro;

class InMemoryLibroRepositoryTest {

    @Test
    void findAll_debeDevolverCopia_yNoListaInterna() {
        InMemoryLibroRepository repo = new InMemoryLibroRepository();

        List<Libro> primera = repo.findAll();
        int sizeInicial = primera.size();

        primera.clear();

        List<Libro> segunda = repo.findAll();
        assertEquals(sizeInicial, segunda.size());
        assertNotSame(primera, segunda);
    }

    @Test
    void findById_debeEncontrarYNoEncontrarCorrectamente() {
        InMemoryLibroRepository repo = new InMemoryLibroRepository();

        assertTrue(repo.findById(1L).isPresent());
        assertEquals("Cien años de soledad", repo.findById(1L).get().getTitulo());

        assertTrue(repo.findById(999L).isEmpty());
        assertTrue(repo.findById(null).isEmpty());
    }

    @Test
    void findByIdAutor_debeFiltrarCorrectamente() {
        InMemoryLibroRepository repo = new InMemoryLibroRepository();

        List<Libro> deAutor1 = repo.findByIdAutor(1L);
        assertEquals(2, deAutor1.size());

        List<Libro> deAutorInexistente = repo.findByIdAutor(999L);
        assertEquals(0, deAutorInexistente.size());

        List<Libro> conNull = repo.findByIdAutor(null);
        assertEquals(0, conNull.size());
    }

    @Test
    void save_conIdNull_debeGenerarIdNuevo() {
        InMemoryLibroRepository repo = new InMemoryLibroRepository();

        Libro nuevo = new Libro(null, "Nuevo Libro", 2025, 1L);
        Libro guardado = repo.save(nuevo);

        assertNotNull(guardado.getId());
        assertTrue(guardado.getId() >= 5L);
        assertTrue(repo.findById(guardado.getId()).isPresent());
    }

    @Test
    void save_conIdExistente_debeActualizar() {
        InMemoryLibroRepository repo = new InMemoryLibroRepository();

        Libro actualizado = new Libro(4L, "Rayuela (Edición)", 1963, 3L);
        repo.save(actualizado);

        Libro l = repo.findById(4L).orElseThrow();
        assertEquals("Rayuela (Edición)", l.getTitulo());
    }

    @Test
    void deleteById_y_deleteAll_funcionan() {
        InMemoryLibroRepository repo = new InMemoryLibroRepository();

        assertTrue(repo.deleteById(2L));
        assertTrue(repo.findById(2L).isEmpty());

        assertFalse(repo.deleteById(999L));
        assertFalse(repo.deleteById(null));

        repo.deleteAll();
        assertEquals(0, repo.findAll().size());
    }
}
