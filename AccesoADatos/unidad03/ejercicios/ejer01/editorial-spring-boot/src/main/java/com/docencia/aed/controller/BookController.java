package com.docencia.aed.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import com.docencia.aed.entity.Book;
import com.docencia.aed.service.impl.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Class BookController
 * Es el controlador que gestina los "end points" relacionados con los libros.
 * 
 * @author Chugani05
 */
@RestController
@RequestMapping("/api/books")
@Tag(name = "Books", description = "Operaciones sobre books")
public class BookController {

    private BookService service;

    @Autowired
    public void setService(BookService service) {
        this.service = service;
    }

    
    @Operation(summary = "Get all books")
    @GetMapping("")
    public List<Book> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Get book by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable(value = "id") Long id) {
        Book book = service.findById(id);
        return ResponseEntity.ok().body(book);
    }

    // @Operation(summary = "Create book with authorId")
    // @ApiResponses(value = {
    //         @ApiResponse(responseCode = "200", description = "Book created successfully"),
    //         @ApiResponse(responseCode = "400", description = "Bad request")
    // })
    // @PostMapping("?authorId={idAutor}")
    // public Book create(@Valid @RequestBody Book book) {
    //     return service.create(book);
    // }
}






