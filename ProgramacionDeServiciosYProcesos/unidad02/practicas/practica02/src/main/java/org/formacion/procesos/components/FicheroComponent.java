package org.formacion.procesos.components;

import org.formacion.procesos.repository.IFicheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("component")
public class FicheroComponent implements IFicheroComponent {

    @Autowired
    @Qualifier("ficheroRepository")
    IFicheroRepository ficheroRepository;

    @Autowired
    @Qualifier("baseDatosRepository")
    IFicheroRepository bbddRepository;

    @Override
    public String mensaje() {
        return ficheroRepository.saludar() + " " + bbddRepository.saludar();
    }

}
