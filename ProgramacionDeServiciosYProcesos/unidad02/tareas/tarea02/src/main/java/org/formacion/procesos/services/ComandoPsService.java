package org.formacion.procesos.services;

import org.formacion.procesos.domain.ProcessType;
import org.formacion.procesos.services.abstracts.ComandoServiceAbstract;
import org.springframework.stereotype.Component;

@Component
public class ComandoPsService extends ComandoServiceAbstract {

    public ComandoPsService() {
        this.setTipo(ProcessType.PS);
    }

    @Override
    public void imprimeMensaje() {
        System.out.println("Estoy llamando a ControllerPs");
    }

    @Override
    public boolean validar(String[] arrayComando) {
        if (!getComando().toUpperCase().equals(getTipoToString())) {
            System.out.println("El comando es invalido");
            return false;
        }
        return true;
    }
}
