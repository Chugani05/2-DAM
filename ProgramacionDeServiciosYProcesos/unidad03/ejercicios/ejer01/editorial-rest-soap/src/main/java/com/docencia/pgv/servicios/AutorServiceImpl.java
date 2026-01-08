package com.docencia.pgv.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.docencia.pgv.interfaces.AutorService;
import com.docencia.pgv.modelo.Autor;
import com.docencia.pgv.repositorios.interfaces.AutorRepository;

/**
 * Class AutorService
 * Es el servicio que gestiona la lógica relacionada con los autores.
 * 
 * @author Chugani05 
 */
@Service
public class AutorServiceImpl implements AutorService {

    private final AutorRepository repository;

    @Autowired
    public AutorServiceImpl(AutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Autor> findAll() {
        return repository.findAll();
    }

    @Override
    public Autor findByIdOrThrow(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Autor create(Autor autor) {
        return repository.save(autor);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
}
