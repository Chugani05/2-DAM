package com.docencia.files.repo;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.docencia.files.model.Note;
public class FileNoteRepository extends FileNoteAbstractRepository {
    
    private String nameFile;
    private Path path;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public FileNoteRepository() {
        this.nameFile = "note-repository.txt";
        try {
            this.path = verifyFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Si existe y no es un directorio
     * Si no existe lo creo
     * 
     * @throws IOException
     */
    private Path verifyFile()  {
        URL resourceUrl;
        resourceUrl = getClass().getClassLoader().getResource(nameFile);
        return Paths.get(resourceUrl.getPath());
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public Note findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Note> findAll() {
        lock.readLock().lock();
        try {
            return Collections.unmodifiableList(readAllInternal());
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Note find(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public Note save(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private List<Note> readAllInternal() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0) return new ArrayList<>();
            Note[] arrayNotes = mapper.readValue(Files.readAllBytes(path), Note[].class);
            return new ArrayList<>(Arrays.asList(arrayNotes));
        } catch (Exception e) {
            throw new RuntimeException("Error reading File", e);
        }
    }
}
