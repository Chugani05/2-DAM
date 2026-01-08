package com.docencia.pgv.repositorios.interfaces;

import java.util.List;
import java.util.Optional;

import com.docencia.pgv.modelo.Libro;


public interface LibroRepository {

    List<Libro> findAll();

    Optional<Libro> findById(Long id);

    List<Libro> findByIdAutor(Long idAutor);

    Libro save(Libro libro);

    boolean deleteById(Long id);

    void deleteAll();
}
