package com.docencia.objetos.repo.interfaces;

import com.docencia.objetos.domain.Alumno;
import java.util.List;
import java.util.Optional;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public interface AlumnoRepository {
  List<Alumno> findAll();
  Optional<Alumno> findById(Long id);
  Alumno save(Alumno alumno);
  boolean existsByEmail(String email);
  void deleteById(Long id);
  long count();
}
