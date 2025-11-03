package pgv.tarea02.proc_cli_application.repositories.interfaces;

import java.nio.file.Path;
import java.util.List;

public interface JobRepository {
    public boolean createFile(Path filepath);
    public boolean writeFile(String jobType, List<String> stdOutput, List<String> errorOutput);
    public boolean existsFile(Path filepath);
}
