package com.docencia.objetos.repo.interfaces;

import com.docencia.objetos.domain.Rol;

import java.util.List;
import java.util.Optional;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public interface RolRepository {

    List<Rol> findAll();
    Optional<Rol> findById(Long id);
    Optional<Rol> findByNombre(String nombre);
    Rol save(Rol rol);
    void deleteById(Long id);
    long count();
}
