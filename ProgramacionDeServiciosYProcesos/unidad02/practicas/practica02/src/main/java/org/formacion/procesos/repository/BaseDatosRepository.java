package org.formacion.procesos.repository;

import org.formacion.procesos.repository.interfaces.IAlmacenamientoRepository;
import org.springframework.stereotype.Repository;

@Repository("baseDatosRepository")
public class BaseDatosRepository implements IAlmacenamientoRepository{
    
    @Override
    public String saludar() {
        return "Te estoy saludando desde el repositorio desde la bbdd.";
    }
}
