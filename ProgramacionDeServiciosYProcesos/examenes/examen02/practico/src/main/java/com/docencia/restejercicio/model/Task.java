package com.docencia.restejercicio.model;

import java.util.Objects;

/**
 * Class Task
 * Clase que representa las tareas.
 * 
 * @author Chugani05
 */
public class Task {

    private Long id;
    private String title;
    private String description;
    private boolean done;
    
    /**
     * Constructor vacío de la clase.
     */
    public Task() {
    }

    /**
     * Constructor con identificador único de la clase.
     * @param id Itentificador único de la clase
     */
    public Task(Long id) {
        this.id = id;
    }

    /**
     * Constructor con los parametros de la clase.
     * @param id Identificador de la tare.
     * @param title Título de la tarea.
     * @param description Descrpción de la tarea.
     * @param done Parámetro que confirma si una tarea está hecha o no mediante un booleano.
     */
    public Task(Long id, String title, String description, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        return Objects.equals(id, other.id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    
}
