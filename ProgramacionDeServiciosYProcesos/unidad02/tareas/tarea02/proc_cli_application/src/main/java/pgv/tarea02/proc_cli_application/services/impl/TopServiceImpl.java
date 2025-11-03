package pgv.tarea02.proc_cli_application.services.impl;

import org.springframework.stereotype.Service;

import pgv.tarea02.proc_cli_application.domain.Job;
import pgv.tarea02.proc_cli_application.services.abstracts.CommandServiceAbstract;

/**
 * Class TopServiceImpl
 * @author chugani05
 * Implementation of the CommandServiceAbstract class for the top command.
 */
@Service
public class TopServiceImpl extends CommandServiceAbstract{

    public TopServiceImpl() {
        setType(Job.TOP);
        setRegex("^(-n\\s*1\\s+-b)$");
    }
}
