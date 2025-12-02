package com.docencia.restejercicio.model;

import java.util.Objects;

/**
 * Class User
 * Clase que representa al usuario.
 * 
 * @author Chugani05
 */
public class User {

    private Long id;
    private String username;
    private String email;

    /**
     * Constructor vacío de la clase.
     */
    public User() {
    }

    /**
     * Constructor con identificador único de la clase.
     * @param id
     */
    public User(Long id) {
        this.id = id;
    }

    /**
     * Constructor con los parametros de la clase.
     * @param id Identificador del usuario.
     * @param username nombre de usuario.
     * @param email Correo electrónico del usuario.
     */
    public User(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
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
        User other = (User) obj;
        return Objects.equals(id, other.id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
