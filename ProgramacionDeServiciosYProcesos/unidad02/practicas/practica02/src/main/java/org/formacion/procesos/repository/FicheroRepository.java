package org.formacion.procesos.repository;

import org.springframework.stereotype.Repository;


@Repository("ficheroRepository")
public class FicheroRepository implements IFicheroRepository {

    @Override
    public String saludar() {
        return "Te estoy saludando desde el repositorio del fichero.";
    }

}
