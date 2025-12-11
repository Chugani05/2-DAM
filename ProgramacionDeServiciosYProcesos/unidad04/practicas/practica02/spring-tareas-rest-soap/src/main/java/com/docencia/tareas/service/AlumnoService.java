package com.docencia.tareas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docencia.tareas.mapper.TareaMapper;
import com.docencia.tareas.model.Tarea;
import com.docencia.tareas.repositories.ITareaRepository;
import com.docencia.tareas.repositories.TareaRepository;

@Service
public class AlumnoService implements IAlumnoService{

    private ITareaRepository repository;

    public AlumnoService(TareaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tarea> listarTodas() {
        return TareaMapper.INSTANCE.toAlumnos(repository.all());
    }

}
