package pgv.tarea02.proc_cli_application.services.interfaces;

public interface ICommandService {

    /**
     * It receives the line, validates it, and executes it.
     * @param command It's the input line.
     */
    public void processCommand(String command);


    /**
     * This is the function that validates the the main part and it's parameters.
     * @param command It's the input line.
     * @return It returns true if valid, and false otherwise.
     */
    public boolean validate(String command);


    /**
     * Creates a process and executes it.
     * @return It returns true if executed, and false otherwise.
     */
    public boolean executeCommand();


    /**
     * Prepares the process output, prints it, and saves it to a newly created file.
     * @param process The process.
     */
    public void printOutput(Process process);
}
