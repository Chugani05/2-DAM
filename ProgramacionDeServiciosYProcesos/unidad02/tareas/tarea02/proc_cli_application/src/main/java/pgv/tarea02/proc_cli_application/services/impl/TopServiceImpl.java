package pgv.tarea02.proc_cli_application.services.impl;

import org.springframework.stereotype.Service;

import pgv.tarea02.proc_cli_application.domain.Job;
import pgv.tarea02.proc_cli_application.services.abstracts.CommandServiceAbstract;

@Service
public class TopServiceImpl extends CommandServiceAbstract{

    public TopServiceImpl() {
        setType(Job.TOP);
    }
}
