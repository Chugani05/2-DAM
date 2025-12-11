package com.docencia.tareas.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.docencia.tareas.model.Alumno;
import com.docencia.tareas.model.Tarea;

@Mapper
public class TareaMapper {

    TareaMapper INSTANCE = Mappers.getMapper(TareaMapper.class);

    @Mappings({
        @Mapping(source = "id", target = "identificador"),
        @Mapping(source = "titulo", target = "nombre")
    })
    Alumno toAlumno(Tarea tarea);

    List<Alumno> toAlumnos(List<Tarea> tareas);
}
