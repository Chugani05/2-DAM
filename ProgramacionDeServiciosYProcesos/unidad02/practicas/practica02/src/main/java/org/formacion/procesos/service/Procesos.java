package org.formacion.procesos.service;

import org.formacion.procesos.components.IFicheroComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Procesos {

    @Autowired
    IFicheroComponent componenteFichero;

    // Manera más actual
    // 
    // @Autowired
    // public void setComponentFichero(IFicheroComponent componenteFichero) {
        // this.componenteFichero = componenteFichero;
    // }

    public void ejecutar() {
        System.out.println("Ejecutando lógica del proceso...");
        System.out.println(componenteFichero.mensaje());
    }
    
}