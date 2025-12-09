package com.docencia.tareas.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.docencia.tareas.model.Tarea;
import com.docencia.tareas.service.TareaService;

@RestController
@RequestMapping("/api/tareas")
public class TareaRestController {

    private final TareaService service;

    public TareaRestController(TareaService service) {
        this.service = service;
    }


    @GetMapping
    public List<Tarea> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> buscarPorId(@PathVariable Long id) {
        Tarea tarea = service.buscarPorId(id);
        if (tarea == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarea);
    }

    public record CrearTareaRequest(String titulo, String descripcion) {}
    public record ActualizarTareaRequest(String titulo, String descripcion, Boolean completada) {}

    @PostMapping
    public ResponseEntity<Tarea> crear(@RequestBody CrearTareaRequest request) {
        if (request == null || request.titulo() == null || request.titulo().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Tarea creada = service.crearTarea(request.titulo(), request.descripcion());
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizar(@PathVariable Long id, @RequestBody ActualizarTareaRequest request) {
        Tarea actualizada = service.actualizarTarea(
            id,
            request.titulo(),
            request.descripcion(),
            request.completada()
        );
        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean ok = service.eliminarTarea(id);
        if (!ok) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
