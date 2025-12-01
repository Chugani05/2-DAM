package com.docencia.rest.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docencia.rest.domain.Producto;
import com.docencia.rest.exception.ResourceNotFoundException;
import com.docencia.rest.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Class ProductosController
 * Es el controlador que gestina los "end points" relacionados con los productos.
 * 
 * @author Chugani05
 */
@RestController
@RequestMapping("/api/v1/productos")
@Tag(name = "Productos", description = "Operaciones sobre productos")
public class ProductosController {

    private ProductoService productoService;

    @Autowired
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Operation(summary = "Get all productos")
    @GetMapping("/")
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable(value = "id") int productoId)
            throws ResourceNotFoundException {
        Producto producto = productoService.findById(productoId).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(producto);
    }

    @Operation(summary = "Delete Producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Producto not found")
    })
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProductoById(@PathVariable(value = "id") int productoId)
            throws ResourceNotFoundException {
        boolean respuesta = productoService.deleteById(productoId);
        Map<String, Boolean> response = new HashMap<>();
        if (respuesta == false) {
            response.put("deleted", Boolean.FALSE);
            return response;
        }
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @Operation(summary = "Insert producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/add/")
    public Producto createUser(@Valid @RequestBody Producto producto) {
        return productoService.save(producto);
    }

    /**
     * Ejemplo creado durante practica
     * End point, url + views
     * @param precio
     * @return
     */
    @Operation(summary = "Get producto by precio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto found successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @GetMapping("/all?precio={precio}")
    public List<Producto> getAllByPrice(@PathVariable(value="price") BigDecimal precio) {
        return productoService.findAllByPrecio(precio);
    }

}
