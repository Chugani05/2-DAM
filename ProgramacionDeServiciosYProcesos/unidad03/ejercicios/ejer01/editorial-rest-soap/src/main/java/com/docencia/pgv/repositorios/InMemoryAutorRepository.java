package com.docencia.pgv.repositorios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.docencia.pgv.modelo.Autor;
import com.docencia.pgv.repositorios.interfaces.AutorRepository;


@Repository
public class InMemoryAutorRepository implements AutorRepository {

    private final List<Autor> datos = new ArrayList<>();
    private final AtomicLong secuencia;

    public InMemoryAutorRepository() {
        datos.add(new Autor(1L, "Gabriel García Márquez", "Colombia"));
        datos.add(new Autor(2L, "Isabel Allende", "Chile"));
        datos.add(new Autor(3L, "Julio Cortázar", "Argentina"));

        long max = datos.stream()
                .map(Autor::getId)
                .max(Comparator.naturalOrder())
                .orElse(0L);

        this.secuencia = new AtomicLong(max);
    }

    @Override
    public List<Autor> findAll() {
        return new ArrayList<>(datos);
    }

    @Override
    public Optional<Autor> findById(Long id) {
        if (id == null) return Optional.empty();
        return datos.stream().filter(a -> id.equals(a.getId())).findFirst();
    }

    @Override
    public Autor save(Autor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("autor no puede ser null");
        }

        if (autor.getId() == null) {
            autor.setId(secuencia.incrementAndGet());
            datos.add(autor);
            return autor;
        }

        // actualizar (replace)
        deleteById(autor.getId());
        datos.add(autor);
        return autor;
    }

    @Override
    public boolean deleteById(Long id) {
        if (id == null) return false;
        return datos.removeIf(a -> id.equals(a.getId()));
    }

    @Override
    public void deleteAll() {
        datos.clear();
    }
}
