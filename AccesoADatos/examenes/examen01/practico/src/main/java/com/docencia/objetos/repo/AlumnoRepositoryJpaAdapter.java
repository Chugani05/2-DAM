package com.docencia.objetos.repo;

import com.docencia.objetos.domain.Alumno;
import com.docencia.objetos.domain.Rol;
import com.docencia.objetos.mapper.AlumnoMapper;
import com.docencia.objetos.repo.interfaces.AlumnoRepository;
import com.docencia.objetos.repo.jpa.AlumnoEntity;
import com.docencia.objetos.repo.jpa.AlumnoJpaRepository;
import com.docencia.objetos.repo.jpa.RolEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Profile("h2")
public class AlumnoRepositoryJpaAdapter implements AlumnoRepository {

  private final AlumnoJpaRepository jpa;

  public AlumnoRepositoryJpaAdapter(AlumnoJpaRepository jpa) {
    this.jpa = jpa;
  }

  @Override
  public List<Alumno> findAll() {
    List<AlumnoEntity> alumnoEntities = jpa.findAll();
    return AlumnoMapper.toAlumnos(alumnoEntities);
  }

  @Override
  public Optional<Alumno> findById(Long id) {
    return null;
  }

  @Override
  public Alumno save(Alumno alumno) {
    return null;
  }

  @Override
  public boolean existsByEmail(String email) {
    return jpa.existsByEmail(email);
  }

  @Override
  public void deleteById(Long id) {
    
  }

  @Override
  public long count() {
    return 0;
  }

}
