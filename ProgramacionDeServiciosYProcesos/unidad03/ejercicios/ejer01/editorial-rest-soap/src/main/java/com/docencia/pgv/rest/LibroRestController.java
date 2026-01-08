package com.docencia.pgv.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.docencia.pgv.interfaces.LibroService;
import com.docencia.pgv.modelo.Libro;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Class LibroRestController
 * Es el controlador que gestina los "end points" relacionados con los libros.
 * 
 * @author Chugani05
 */
@RestController
@RequestMapping("/api/libros")
@Tag(name = "Libros", description = "Operaciones sobre libros")
public class LibroRestController {

    private LibroService service;

    @Autowired
    public void setService(LibroService service) {
        this.service = service;
    }

    
    @Operation(summary = "Get all books")
    @GetMapping("")
    public List<Libro> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Get books by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Libro> findByIdOrThrow(@PathVariable(value = "id") Long id) {
        Libro libro = service.findByIdOrThrow(id);
        return ResponseEntity.ok().body(libro);
    }

    @Operation(summary = "Get books by author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Author's books not found")
    })
    @GetMapping("/autor/{idAutor}")
    public List<Libro> findByAutorOrThrow(@PathVariable(value = "id") Long idAutor) {
        return service.findByAutorOrThrow(idAutor);
    }

    @Operation(summary = "Create book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @PostMapping("")
    public Libro create(@Valid @RequestBody Libro libro) {
        return service.create(libro);
    }


    @Operation(summary = "Delete book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) {
        service.delete(id); 
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
