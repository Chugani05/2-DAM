package org.formacion.procesos.controller;

import org.formacion.procesos.controller.abstracts.ComandoControllerAbstract;
import org.formacion.procesos.domain.ProcessType;
import org.springframework.stereotype.Component;

@Component
public class ComandoControllerLs extends ComandoControllerAbstract {

    public ComandoControllerLs() {
        this.setTipo(ProcessType.PS);
    }

    @Override
    public void imprimeMensaje() {
        System.out.println("Estoy llamando a ControllerLs");
    }    
}
