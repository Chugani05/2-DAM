package pgv.tarea02.proc_cli_application.repositories.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pgv.tarea02.proc_cli_application.repositories.interfaces.JobRepository;
import pgv.tarea02.proc_cli_application.services.abstracts.CommandServiceAbstract;

@Repository
public class FileJobRepository implements JobRepository {

    private static Logger logger = LoggerFactory.getLogger(CommandServiceAbstract.class);

    private File directory;

    public FileJobRepository() {
        directory = new File("outputs/");
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public File getDirectory() {
        return directory;
    }

    public void setDirectory(File directory) {
        this.directory = directory;
    }

    @Override
    public boolean createFile(Path filepath) {
        try {
            Files.createFile(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean existsFile(Path filepath) {
        File file = new File(filepath.toString());
        return file.exists();
    }

    @Override
    public boolean writeFile(String jobType, List<String> stdOutput, List<String> errorOutput) {
        String fileName = jobType + "-" + LocalDateTime.now().toString() + ".txt";
        Path filePath = Paths.get(directory.toString()+ "/" + fileName);
        if (!existsFile(filePath)) {
            createFile(filePath);
        }
        try (var bufferedWriter = new BufferedWriter(new FileWriter(filePath.toString()))) {
            stdOutput.forEach(line -> {
                try {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    logger.error("Something happend while writing the standard output!!", e);
                }
            });
            errorOutput.forEach(line -> {
                try {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    logger.error("Something happend while writing the error output!!", e);
                }
            });
        } catch (IOException e) {
            logger.error("Something happend while writing in the file!!", e);
        }
        return true;
    }
}
