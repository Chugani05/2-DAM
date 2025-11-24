package com.docencia.personas.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "rol")
public class Rol {

    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    public String getId() {
        verificarParametro(id, "ID");
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        verificarParametro(nombre, "NOMBRE");
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Contructor vacío de la clase
     */
    public Rol() {
    }

    /**
     * Contructor con el identificador del Rol.
     * @param id identificador único de rol
     */
    public Rol(String id) {
        this.id = id;
    }

    /**
     * Constructor de la clase con propiedades.
     * @param id identificador único. Ejemplo ROL-1
     * @param nombre nombre del rol
     * @exception IllegalArgument Si uno de los parametros es null/blank
     */
    public Rol(String id, String nombre) {
        verificarParametro(id, "ID");
        verificarParametro(nombre, "NOMBRE");
        this.id = id;
        this.nombre = nombre;
    }

    
    private void verificarParametro(String valor, String etiqueta) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(etiqueta);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass())
            return false;
        Rol other = (Rol) obj;
        return Objects.equals(id, other.id);
    }
}
