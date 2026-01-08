package com.docencia.pgv.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.docencia.pgv.interfaces.LibroService;
import com.docencia.pgv.modelo.Libro;
import com.docencia.pgv.repositorios.interfaces.LibroRepository;

/**
 * Class LibroService
 * Es el servicio que gestiona la lógica relacionada con los libros.
 * 
 * @author Chugani05 
 */
@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository repository;

    @Autowired
    public LibroServiceImpl(LibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Libro> findAll() {
        return repository.findAll();
    }

    @Override
    public Libro findByIdOrThrow(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Libro> findByAutorOrThrow(Long idAutor) {
        return repository.findByIdAutor(idAutor);
    }

    @Override
    public Libro create(Libro libro) {
        return repository.save(libro);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
}
