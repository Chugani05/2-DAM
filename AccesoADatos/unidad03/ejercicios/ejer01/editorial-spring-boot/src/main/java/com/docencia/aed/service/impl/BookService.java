package com.docencia.aed.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.aed.entity.Book;
import com.docencia.aed.repository.BookRepository;
import com.docencia.aed.service.interfaces.IBookService;

/**
 * Class BookService
 * Es el servicio que gestiona la lógica relacionada con los libros.
 * 
 * @author Chugani05 
 */
@Service
public class BookService implements IBookService {

    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Book create(Book name, Long authorId) {
        return repository.save(name);
    }
}
