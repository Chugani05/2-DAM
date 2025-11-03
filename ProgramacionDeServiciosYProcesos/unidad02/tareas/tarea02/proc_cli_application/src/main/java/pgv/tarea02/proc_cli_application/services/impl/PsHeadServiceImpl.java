package pgv.tarea02.proc_cli_application.services.impl;

import org.springframework.stereotype.Service;

import pgv.tarea02.proc_cli_application.domain.Job;
import pgv.tarea02.proc_cli_application.services.abstracts.CommandServiceAbstract;

/**
 * Class PsHeadServiceImpl
 * @author chugani05
 * Implementation of the CommandServiceAbstract class for the ps command.
 */
@Service
public class PsHeadServiceImpl extends CommandServiceAbstract{

    public PsHeadServiceImpl() {
        setType(Job.PS);
        setRegex("^(aux\\s+\\|\\s+head)$");
    }
}
