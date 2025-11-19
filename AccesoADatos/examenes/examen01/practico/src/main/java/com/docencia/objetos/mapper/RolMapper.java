package com.docencia.objetos.mapper;

import com.docencia.objetos.domain.Rol;
import com.docencia.objetos.repo.jpa.RolEntity;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class RolMapper {

    /**
     * Metodo para convertir RolEntity en Rol
     * @param rolEntity a convertir en Rol
     * @return un Rol
     */
    public Rol to(RolEntity rolEntity) {
        Rol rol = new Rol(
            rolEntity.getId(),
            rolEntity.getNombre()
        );
        return rol;
    }

    /**
     * Metodo para convertir Rol en RolEntity
     * @param rol a convertir en RolEntity
     * @return un RolEntity
     */
    public RolEntity to(Rol rol) {
        RolEntity rolEntity = new RolEntity(
            rol.getId(),
            rol.getNombre()
        );
        return rolEntity;
    }
}
