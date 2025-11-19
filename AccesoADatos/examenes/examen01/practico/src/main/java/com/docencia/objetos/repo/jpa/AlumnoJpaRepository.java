package com.docencia.objetos.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public interface AlumnoJpaRepository extends JpaRepository<AlumnoEntity, Long> {
  boolean existsByEmail(String email);
}
