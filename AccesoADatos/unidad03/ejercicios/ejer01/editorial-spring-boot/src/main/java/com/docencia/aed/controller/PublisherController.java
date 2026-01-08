package com.docencia.aed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docencia.aed.entity.Publisher;
import com.docencia.aed.service.impl.PublisherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Class PublisherController
 * Es el controlador que gestina los "end points" relacionados con los editoriales.
 * 
 * @author Chugani05
 */
@RestController
@RequestMapping("/api/publisher")
@Tag(name = "Publishers", description = "Operaciones sobre publisher")
public class PublisherController {

    private PublisherService service;

    @Autowired
    public void setService(PublisherService service) {
        this.service = service;
    }

    
    @Operation(summary = "Get all publishers")
    @GetMapping("")
    public List<Publisher> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Create publisher")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Publisher created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("")
    public Publisher create(@Valid @RequestBody Publisher publisher) {
        return service.create(publisher);
    }
}
