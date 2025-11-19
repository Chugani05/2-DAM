package com.docencia.objetos.repo.json;

import com.docencia.objetos.domain.Rol;
import com.docencia.objetos.repo.interfaces.RolRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class RolJsonFileRepository implements RolRepository {
    private final Path path;
    private final ObjectMapper mapper;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * Constructor con las propiedades path y mapper
     * @param path del fichero
     * @param mapper objeto mapper
     */
    public RolJsonFileRepository(Path path, ObjectMapper mapper) {
        this.path = path;
        this.mapper = mapper;
    }

    /**
     * Metodo para verificar si existe un fichero y si no lo crea
     */
    public Path verificarFichero() {
        URL resource = getClass().getClassLoader().getResource("");
        return Paths.get(resource.getPath());
    }
    
    @Override
    public List<Rol> findAll() {
        lock.readLock().lock();
        try {
            return Collections.unmodifiableList(readAllInternal());
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Optional<Rol> findById(Long id) {
        Rol rol = new Rol(id);
        List<Rol> roles = findAll();
        int posicion = roles.indexOf(rol);
        if (posicion < 0) {
            return null;
        }
        return Optional.of(roles.get(posicion));
    }

    @Override
    public Optional<Rol> findByNombre(String nombre) {
        return null;
    }

    @Override
    public Rol save(Rol rol) {
        lock.writeLock().lock();
        try {
            List<Rol> notes = findAll();
            if (rol.getId() == null) {
                return rol;
            }
            notes.removeIf(n -> Objects.equals(n.getId(), rol.getId()));
            notes.add(rol);
            writeAllInternal(notes);
            return rol;
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        lock.writeLock().lock();
        try {
            List<Rol> notes = readAllInternal();
            boolean removed = notes.removeIf(note -> Objects.equals(note.getId(), id));
            if (removed) {
                writeAllInternal(notes);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public long count() {
        return 0;
    }

    private List<Rol> readAllInternal() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0) return new ArrayList<>();
            Rol[] arrayNotes = mapper.readValue(Files.readAllBytes(path), Rol[].class);
            return new ArrayList<>(Arrays.asList(arrayNotes));
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo JSON", e);
        }
    }

    private void writeAllInternal(List<Rol> items) {
        try {
            byte[] bytes = mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(items);
            Files.write(path, bytes,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException("Error escribiendo JSON", e);
        }
    }
}
