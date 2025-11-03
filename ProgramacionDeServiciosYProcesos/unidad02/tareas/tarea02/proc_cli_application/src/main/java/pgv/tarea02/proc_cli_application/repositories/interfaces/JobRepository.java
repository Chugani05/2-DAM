package pgv.tarea02.proc_cli_application.repositories.interfaces;

import java.nio.file.Path;
import java.util.List;

public interface JobRepository {

    /**
     * Creates the file at the given filepath.
     * @param filepath Given filepath for the creation of the file.
     * @return It returns true if created, and false otherwise.
     */
    public boolean createFile(Path filepath);

    /**
     * Creates a file with the command name and the current date and time, and writes the standard output and error output to it.     * @param jobType command name.
     * @param stdOutput Standard output.
     * @param errorOutput Error output.
     * @return It returns true if it is written successfully, and false otherwise.
     */
    public boolean writeFile(String jobType, List<String> stdOutput, List<String> errorOutput);

    /**
     * Checks if the file exists.
     * @param filepath Path to check.
     * @return It returns true if exists, and false otherwise.
     */
    public boolean existsFile(Path filepath);
}
