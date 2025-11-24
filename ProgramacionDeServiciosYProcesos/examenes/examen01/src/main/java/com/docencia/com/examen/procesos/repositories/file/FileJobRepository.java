package com.docencia.com.examen.procesos.repositories.file;

import java.io.IOException;
import java.net.URL;
import java.nio.file.*;

import org.springframework.stereotype.Repository;

import com.docencia.com.examen.procesos.repositories.interfaces.JobRepository;

@Repository
public class FileJobRepository implements JobRepository {
    

    public FileJobRepository() {
        try {
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public FileJobRepository(String loggerFileName) {
        try {
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public boolean add(String content) {

        try {
            
        } catch (Exception e) {
        }
        return false;
    }
}
