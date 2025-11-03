package pgv.tarea02.proc_cli_application.services.impl;

import org.springframework.stereotype.Service;

import pgv.tarea02.proc_cli_application.domain.Job;
import pgv.tarea02.proc_cli_application.services.abstracts.CommandServiceAbstract;

/**
 * Class LsofServiceImpl
 * @author chugani05
 * Implementation of the CommandServiceAbstract class for the lsof command.
 */
@Service
public class LsofServiceImpl extends CommandServiceAbstract{

    public LsofServiceImpl() {
        setType(Job.LSOF);
        setRegex("^(-i)?$");
    }
}
