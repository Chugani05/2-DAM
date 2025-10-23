package org.formacion.procesos.repositories;

import org.formacion.procesos.repositories.interfaces.CrudInterface;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.nio.file.File;
import java.nio.file.Path;
import java.nio.file.Paths;


@Repository
public class FileRepository implements CrudInterface {

    private static Logger logger = LoggerFactory.getLogger(FileRepository.class);
    static String fileName;
    static Path path;

    @Autowired
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileRepository() {
        if (fileName == null) {
            fileName = "mis_procesos.txt";
        }
        URL resource = getClass().getClassLoader().getResource(fileName);
        path = Paths.get(resource.getPath());

    }

    @Override
    public boolean add(String text) {
        try {
            File.write(path, text.getBytes(), StandardOperation.APPEND);
            return true;
        } catch (Exception e) {
            logger.error("Se ha producido un error almacenando en el fichero", e);
        }
        return false;
    }

}
