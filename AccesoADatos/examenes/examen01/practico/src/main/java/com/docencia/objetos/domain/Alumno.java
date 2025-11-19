package com.docencia.objetos.domain;

import java.util.Objects;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Alumno {
  private Long id;
  private String nombre;
  private String email;
  private String ciclo;
  private Rol rol;   

 /**
  * Constructor por defecto
  */
  public Alumno() {
  }

  /**
   * Constructor con la propiedad id
   * @param id del alumno
   */
  public Alumno(Long id) {
    this.id = id;
  }

  /**
   * Constuctor con todas las propiedades menos el rol
   * @param id del alumno
   * @param nombre del alumno
   * @param email del alumno
   * @param ciclo del alumno
   */
  public Alumno(Long id, String nombre, String email, String ciclo) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.ciclo = ciclo;
  }

  /**
   * Constuctor con todas las propiedades
   * @param id del alumno
   * @param nombre del alumno
   * @param email del alumno
   * @param ciclo del alumno
   * @param rol del alumno
   */
  public Alumno(Long id, String nombre, String email, String ciclo, Rol rol) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.ciclo = ciclo;
    this.rol = rol;
  }

  /**
   * Getters and Setters
   */
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCiclo() {
    return ciclo;
  }

  public void setCiclo(String ciclo) {
    this.ciclo = ciclo;
  }

  public Rol getRol() {
    return rol;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
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
    Alumno other = (Alumno) obj;
    return Objects.equals(id, other.id);
  }
}