package com.docencia.aed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docencia.aed.entity.Author;
import com.docencia.aed.entity.Book;
import com.docencia.aed.service.impl.AuthorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Class AuthorController
 * Es el controlador que gestina los "end points" relacionados con los autores.
 * 
 * @author Chugani05
 */
@RestController
@RequestMapping("/api/authors")
@Tag(name = "Authors", description = "Operaciones sobre authores")
public class AuthorController {

    private AuthorService service;

    @Autowired
    public void setService(AuthorService service) {
        this.service = service;
    }

    
    @Operation(summary = "Get all authors")
    @GetMapping("")
    public List<Author> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Get author by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Author not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable(value = "id") Long id) {
        Author author = service.findById(id);
        return ResponseEntity.ok().body(author);
    }

    @Operation(summary = "Create author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("")
    public Author create(@Valid @RequestBody Author author) {
        return service.create(author);
    }

    @Operation(summary = "Get books of author by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Books found successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @GetMapping("/{id}/books")
    public List<Book> findBooksByAuthor(@PathVariable(value = "id") Long authorId) {
        return findBooksByAuthor(authorId);
    }
}
