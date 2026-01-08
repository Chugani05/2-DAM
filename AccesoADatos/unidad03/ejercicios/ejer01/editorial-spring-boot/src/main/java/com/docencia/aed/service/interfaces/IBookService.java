package com.docencia.aed.service.interfaces;

import java.util.List;

import com.docencia.aed.entity.Book;

public interface IBookService {

    /**
     * 
     * @return
     */
    List<Book> findAll();

    /**
     * 
     * @param id
     * @return
     */
    Book findById(Long id);

    /**
     * 
     * @param name
     * @param authorId
     * @return
     */
    Book create(Book name, Long authorId);
}
