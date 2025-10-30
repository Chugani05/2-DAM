package pgv.tarea02.proc_cli_application.services.abstracts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pgv.tarea02.proc_cli_application.domain.Job;
import pgv.tarea02.proc_cli_application.services.interfaces.ICommandService;

public abstract class CommandServiceAbstract implements ICommandService {

    private static Logger logger = LoggerFactory.getLogger(CommandServiceAbstract.class);


    private String command;
    private Job type;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getType() {
        if (type == null) {
            return null;
        }
        return type.toString();
    }

    public void setType(Job type) {
        this.type = type;
    }

    public void processCommand(String command) {
        if (!validate(command)) {
            logger.error("Invalid command");
            return;
        }
        logger.info("Executing " + getType() + " service: " + command);
    }

    public boolean validate(String command) {
        String word = command.split("\\s+")[0];
        if (!word.equals(getType().toLowerCase())) {
            return false;
        }
        if ()
        return true;
    }

    public boolean executeCommand() {
        // TODO Auto-generated method stub
        return false;
    }

    public void printOutput() {
        // TODO Auto-generated method stub
        
    }
}
