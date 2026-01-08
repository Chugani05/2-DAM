package com.docencia.pgv.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.docencia.pgv.interfaces.AutorService;
import com.docencia.pgv.modelo.Autor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Class AutorRestController
 * Es el controlador que gestina los "end points" relacionados con los autores.
 * 
 * @author Chugani05
 */
@RestController
@RequestMapping("/api/autores")
@Tag(name = "Autores", description = "Operaciones sobre autores")
public class AutorRestController {

    private AutorService service;

    @Autowired
    public void setService(AutorService service) {
        this.service = service;
    }

    
    @Operation(summary = "Get all authors")
    @GetMapping("")
    public List<Autor> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Get author by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Author not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Autor> findByIdOrThrow(@PathVariable(value = "id") Long id) {
        Autor autor = service.findByIdOrThrow(id);
        return ResponseEntity.ok().body(autor);
    }

    @Operation(summary = "Create author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Author not found")
    })
    @PostMapping("")
    public Autor create(@Valid @RequestBody Autor autor) {
        return service.create(autor);
    }


    @Operation(summary = "Delete author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Author not found")
    })
    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) {
        service.delete(id); 
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
