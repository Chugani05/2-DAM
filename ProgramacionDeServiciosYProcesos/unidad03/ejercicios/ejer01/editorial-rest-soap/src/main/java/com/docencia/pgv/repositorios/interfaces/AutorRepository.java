package com.docencia.pgv.repositorios.interfaces;

import java.util.List;
import java.util.Optional;

import com.docencia.pgv.modelo.Autor;


public interface AutorRepository {

    List<Autor> findAll();

    Optional<Autor> findById(Long id);

    Autor save(Autor autor);

    boolean deleteById(Long id);

    void deleteAll();
}
