package com.docencia.personas.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.personas.model.Rol;
import com.docencia.personas.repository.RolRepository;
import com.docencia.personas.services.IRoleService;

@Service()
public class RolService implements IRoleService{

    private RolRepository rolRepository;

    @Autowired
    public void setRolRepository(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol findBy(Rol rol) {
        // Mapper Optional -> Rol (MapStruct)
        return rolRepository.findById(rol.getId()).orElse(null);
    }

    @Override
    public boolean delete(Rol rol) {
        rolRepository.delete(rol);
        return false;
    }

}
