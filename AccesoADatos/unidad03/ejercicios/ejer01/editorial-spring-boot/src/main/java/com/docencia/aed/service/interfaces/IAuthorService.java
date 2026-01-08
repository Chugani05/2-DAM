package com.docencia.aed.service.interfaces;

import java.util.List;

import com.docencia.aed.entity.Author;
import com.docencia.aed.entity.Book;

public interface IAuthorService {

    /**
     * 
     * @return
     */
    List<Author> findAll();

    /**
     * 
     * @param id
     * @return
     */
    Author findById(Long id);

    /**
     * 
     * @param author
     * @return
     */
    Author create(Author author);
    
    /**
     * 
     * @param authorId
     * @return
     */
    List<Book> findBooksByAuthor(Long authorId);

}
