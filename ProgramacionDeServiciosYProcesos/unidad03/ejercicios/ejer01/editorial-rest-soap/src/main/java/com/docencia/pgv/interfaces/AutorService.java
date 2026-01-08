package com.docencia.pgv.interfaces;

import java.util.List;
import com.docencia.pgv.modelo.Autor;

public interface AutorService {

    /**
     * Encontrar todos los autores
     * @return Devuelve una lista de todos los autores.
     */
    List<Autor> findAll();

    /**
     * Encontrar un autor por su ID.
     * @param id Indentificador unico del autor.
     * @return Devuelve un autor.
     */
    Autor findByIdOrThrow(Long id);

    /**
     * Crear un nuevo autor.
     * @param autor Este parametro representa otros dos parametros del autor (nombre y pais).
     * @return Devuelve un nuevo autor con todos sus parametros.
     */
    Autor create(Autor autor);

    /**
     * Eliminar un autor por su ID.
     * @param id Indentificador unico del autor.
     */
    void delete(Long id);
}
