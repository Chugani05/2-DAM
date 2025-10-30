package pgv.tarea02.proc_cli_application.services.interfaces;

public interface ICommandService {

    public void processCommand(String command);


    public boolean validate(String command);


    public boolean executeCommand();


    public void printOutput();
}
