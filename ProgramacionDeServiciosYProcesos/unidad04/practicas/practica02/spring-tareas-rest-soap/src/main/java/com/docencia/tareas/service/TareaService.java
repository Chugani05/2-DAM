package com.docencia.tareas.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.docencia.tareas.model.Tarea;
import com.docencia.tareas.repositories.ITareaRepository;
import com.docencia.tareas.repositories.TareaRepository;

@Service
public class TareaService implements ITareaService{

    private ITareaRepository repository;

    public TareaService(TareaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tarea> listarTodas() {
        return this.repository.all();
    }

    @Override
    public Tarea buscarPorId(Long id) {
        if (id == null) {
            return null;
        }
        Tarea tarea = new Tarea(id);
        return repository.findBy(tarea);
    }

    @Override
    public Tarea crearTarea(String titulo, String descripcion) {
        long id = UUID.randomUUID().getLeastSignificantBits();
        Tarea tarea = new Tarea(id, titulo, descripcion, false);
        return repository.add(tarea);
    }

    @Override
    public Tarea actualizarTarea(Long id, String titulo, String descripcion, Boolean completada) {
        if (id == null) {
            return null;
        }
        Tarea tarea = new Tarea(id, titulo, descripcion, completada);
        return repository.update(tarea);
    }

    @Override
    public boolean eliminarTarea(Long id) {
        if (id == null) {
            return false;
        }
        Tarea tarea = new Tarea(id);
        return repository.delete(tarea);
    }
}
