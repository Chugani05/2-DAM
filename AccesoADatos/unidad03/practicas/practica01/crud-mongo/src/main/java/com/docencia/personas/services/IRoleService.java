package com.docencia.personas.services;

import com.docencia.personas.model.Rol;

public interface IRoleService {
    public Rol save(Rol rol);
    public Rol findBy(Rol rol);
    public boolean delete(Rol rol);
}
