package com.docencia.pgv.repositorios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.docencia.pgv.modelo.Libro;
import com.docencia.pgv.repositorios.interfaces.LibroRepository;


@Repository
public class InMemoryLibroRepository implements LibroRepository {

    private final List<Libro> datos = new ArrayList<>();
    private final AtomicLong secuencia;

    public InMemoryLibroRepository() {
        datos.add(new Libro(1L, "Cien años de soledad", 1967, 1L));
        datos.add(new Libro(2L, "El amor en los tiempos del cólera", 1985, 1L));
        datos.add(new Libro(3L, "La casa de los espíritus", 1982, 2L));
        datos.add(new Libro(4L, "Rayuela", 1963, 3L));

        long max = datos.stream()
                .map(Libro::getId)
                .max(Comparator.naturalOrder())
                .orElse(0L);

        this.secuencia = new AtomicLong(max);
    }

    @Override
    public List<Libro> findAll() {
        return new ArrayList<>(datos);
    }

    @Override
    public Optional<Libro> findById(Long id) {
        if (id == null) return Optional.empty();
        return datos.stream().filter(l -> id.equals(l.getId())).findFirst();
    }

    @Override
    public List<Libro> findByIdAutor(Long idAutor) {
        List<Libro> res = new ArrayList<>();
        if (idAutor == null) return res;
        for (Libro l : datos) {
            if (idAutor.equals(l.getIdAutor())) {
                res.add(l);
            }
        }
        return res;
    }

    @Override
    public Libro save(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("libro no puede ser null");
        }

        if (libro.getId() == null) {
            libro.setId(secuencia.incrementAndGet());
            datos.add(libro);
            return libro;
        }

        deleteById(libro.getId());
        datos.add(libro);
        return libro;
    }

    @Override
    public boolean deleteById(Long id) {
        if (id == null) return false;
        return datos.removeIf(l -> id.equals(l.getId()));
    }

    @Override
    public void deleteAll() {
        datos.clear();
    }
}
