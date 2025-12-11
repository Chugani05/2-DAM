package com.docencia.tareas.model;

import java.util.Objects;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "alumno")
@XmlAccessorType(XmlAccessType.FIELD)
public class Alumno {

    private Long identificador;
    private String nombre;

    
    /**
     * 
     */
    public Alumno() {
    }

    /**
     * 
     * @param identificador
     */
    public Alumno(Long identificador) {
        this.identificador = identificador;
    }

    /**
     * 
     * @param identificador
     * @param nombre
     */
    public Alumno(Long identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }


    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alumno other = (Alumno) obj;
        return Objects.equals(identificador, other.identificador);
    }

    @Override
    public String toString() {
        return "Alumno [identificador=" + identificador + ", nombre=" + nombre + "]";
    }
}


