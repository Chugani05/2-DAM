package com.docencia.pgv.interfaces;

import java.util.List;
import com.docencia.pgv.modelo.Libro;

public interface LibroService {

    /**
     * Encontrar todos los libros
     * @return Devuelve una lista de todos los libros.
     */
    List<Libro> findAll();

    /**
     * Encontrar un libro por su ID.
     * @param id Indentificador unico del libro.
     * @return Devuelve un libro.
     */
    Libro findByIdOrThrow(Long id);

    /**
     * Encontrar libros por la ID del autor.
     * @param idAutor Indentificador unico del autor.
     * @return Devuelve una lista de todos libros relacionados a la ID del autor.
     */
    List<Libro> findByAutorOrThrow(Long idAutor);

    /**
     * Crear un nuevo libro.
     * @param libro Este parametro representa otros dos parametros del libro (titulo, anio de publicacion y id del autor).
     * @return Devuelve un nuevo libro con todos sus parametros.
     */
    Libro create(Libro libro);

    /**
     * Eliminar un libro por su ID.
     * @param id Indentificador unico del libro.
     */
    void delete(Long id);
}
