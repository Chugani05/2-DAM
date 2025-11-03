package pgv.tarea02.proc_cli_application.services.abstracts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pgv.tarea02.proc_cli_application.domain.Job;
import pgv.tarea02.proc_cli_application.repositories.file.FileJobRepository;
import pgv.tarea02.proc_cli_application.services.interfaces.ICommandService;

public abstract class CommandServiceAbstract implements ICommandService {

    private static Logger logger = LoggerFactory.getLogger(CommandServiceAbstract.class);

    private String command;
    private Job type;
    private String regex;

    FileJobRepository fileJobRepository;
    
    @Autowired
    public void setFileJobRepository(FileJobRepository fileJobRepository) {
        this.fileJobRepository = fileJobRepository;
    }

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
        this.setCommand(command);
        this.executeCommand();
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
        ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c", this.getCommand());
        processBuilder.redirectErrorStream(false);
        try {
            Process process = processBuilder.start();
            logger.info("Executing " + getType() + " service: " + command);
            printOutput(process);
        } catch (Exception e) {
            logger.error("Something happend while executing process!!", e);
            return false;
        }
        return true;
    }

    public void printOutput(Process process) {
        List<String> stdOutput = null;
        List<String> errorOutput = null;

        try (var bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            stdOutput = bufferedReader.lines().map(line -> "[OUT] " + line).toList();
            stdOutput.forEach(System.out::println);
        } catch (IOException e) {
            logger.error("Something happend while printing standard output!!", e);
        }

        try (var bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            errorOutput = bufferedReader.lines().map(line -> "[ERR] " + line).toList();
            errorOutput.forEach(System.out::println);
        } catch (IOException e) {
            logger.error("Something happend while printing error output!!", e);
        }

        fileJobRepository.writeFile(getType().toLowerCase(), stdOutput, errorOutput);
    }
}
