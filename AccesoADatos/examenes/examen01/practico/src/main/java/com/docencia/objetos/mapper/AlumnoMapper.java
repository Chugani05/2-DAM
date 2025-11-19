package com.docencia.objetos.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.docencia.objetos.domain.Alumno;
import com.docencia.objetos.repo.jpa.AlumnoEntity;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class AlumnoMapper {
    
    /**
     * Metodo para convertir un AlumnoEntity a un Alumno
     * @param alumnoEntity a covertir en Alumno
     * @return un Alumno
     */
    public static Alumno to(AlumnoEntity alumnoEntity) {
        Alumno alumno = new Alumno(
            alumnoEntity.getId(),
            alumnoEntity.getNombre(),
            alumnoEntity.getEmail(),
            alumnoEntity.getCiclo()
        );
        return alumno;
    }

    /**
     * Metodo para convertir un Alumno a un AlumnoEntity
     * @param alumno a covertir en AlumnoEntity
     * @return un AlumnoEntity
     */
    public static AlumnoEntity to(Alumno alumno) {
        AlumnoEntity alumnoEntity = new AlumnoEntity(
            alumno.getId(),
            alumno.getNombre(),
            alumno.getEmail(),
            alumno.getCiclo()
        );
        return alumnoEntity;
    }

    /**
     * Metodo para convertir un List<AlumnoEntity> a List<Alumno>
     * @param alumnoEntities a convertir en List<Alumno>
     * @return un List<Alumno>
     */
    public static List<Alumno> toAlumnos(List<AlumnoEntity> alumnoEntities) {
        List<Alumno> alumnos = new ArrayList<>();
        if (alumnoEntities.isEmpty()) {
            return alumnos;
        }
        for (AlumnoEntity alumnoEntity : alumnoEntities) {
            alumnos.add(to(alumnoEntity));
        }
        return alumnos;
    }

    /**
     * Metodo para convertir un List<AlumnoEntity> a List<Alumno>
     * @param alumnoEntities a convertir en List<Alumno>
     * @return un List<Alumno>
     */
    public static List<AlumnoEntity> to(List<Alumno> alumnos) {
        List<AlumnoEntity> alumnosEntities = new ArrayList<>();
        if (alumnosEntities.isEmpty()) {
            return alumnosEntities;
        }
        for (Alumno alumno : alumnos) {
            alumnosEntities.add(to(alumno));
        }
        return alumnosEntities;
    }
}
