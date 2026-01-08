package com.docencia.aed.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.aed.entity.Author;
import com.docencia.aed.entity.Book;
import com.docencia.aed.repository.AuthorRepository;
import com.docencia.aed.service.interfaces.IAuthorService;

/**
 * Class AuthorService
 * Es el servicio que gestiona la lógica relacionada con los autores.
 * 
 * @author Chugani05 
 */
@Service
public class AuthorService implements IAuthorService {

    private final AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Author> findAll() {
        return repository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Author create(Author author) {
        return repository.save(author);
    }

    @Override
    public List<Book> findBooksByAuthor(Long authorId) {
        // return repository.findByAuthorId(authorId);
        return null;
    }

    
}
