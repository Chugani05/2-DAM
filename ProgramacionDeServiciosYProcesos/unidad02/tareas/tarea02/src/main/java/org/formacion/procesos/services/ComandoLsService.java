package org.formacion.procesos.services;

import org.formacion.procesos.domain.ProcessType;
import org.formacion.procesos.services.abstracts.ComandoServiceAbstract;
import org.springframework.stereotype.Component;

@Component
public class ComandoLsService extends ComandoServiceAbstract {

    public ComandoLsService() {
        this.setTipo(ProcessType.PS);
        this.setRegExp("^((-(la|l|a))|\s*)$");
    }
}
