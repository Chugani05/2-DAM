package org.formacion.procesos.components;

import org.formacion.procesos.components.interfaces.IFicheroComponent;
import org.formacion.procesos.repository.interfaces.IAlmacenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("component")
public class FicheroComponent implements IFicheroComponent {

    @Autowired
    @Qualifier("ficheroRepository")
    IAlmacenamientoRepository ficheroRepository;

    @Autowired
    @Qualifier("baseDatosRepository")
    IAlmacenamientoRepository bbddRepository;

    @Override
    public String mensaje() {
        return ficheroRepository.saludar() + " " + bbddRepository.saludar();
    }

}
