package pgv.tarea02.proc_cli_application.services.abstracts;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pgv.tarea02.proc_cli_application.domain.Job;
import pgv.tarea02.proc_cli_application.services.interfaces.ICommandService;

public abstract class CommandServiceAbstract implements ICommandService {

    private static Logger logger = LoggerFactory.getLogger(CommandServiceAbstract.class);


    private String command;
    private Job type;
    private String regex;

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

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public void processCommand(String command) {
        if (!validate(command)) {
            logger.error("Invalid command");
            return;
        }
        logger.info("Executing " + getType() + " service: " + command);
    }

    public boolean validate(String command) {
        String[] segments = command.split("\\s+");
        if (!segments[0].equals(getType().toLowerCase())) {
            return false;
        }
        String parametersLine = "";
        if (segments.length > 1) {
            String[] parameters = Arrays.copyOfRange(segments, 1, segments.length);
            parametersLine = String.join(" ", parameters);
        }
        Pattern pattern = Pattern.compile(getRegex());
        Matcher matcher = pattern.matcher(parametersLine.trim());
        return matcher.matches();
    }

    public boolean executeCommand() {
        // TODO Auto-generated method stub
        return false;
    }

    public void printOutput() {
        // TODO Auto-generated method stub
        
    }
}
