package org.formacion.procesos.services;

import org.formacion.procesos.domain.ProcessType;
import org.formacion.procesos.services.abstracts.ComandoServiceAbstract;
import org.springframework.stereotype.Component;

@Component
public class ComandoLsService extends ComandoServiceAbstract {

    public ComandoLsService() {
        this.setTipo(ProcessType.PS);
    }

    @Override
    public void imprimeMensaje() {
        System.out.println("Estoy llamando a ControllerLs");
    }

    @Override
    public boolean validar(String[] arrayComando) {
        if (super.validarComando()) {
            return false;
        }
        String parametro = arrayComando[1];
        return true;
    }
}
