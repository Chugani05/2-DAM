package com.docencia.objetos.domain;

import java.util.Objects;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Rol {

  private Long id;
  private String nombre;

  /**
  * Constructor por defecto
  */
  public Rol() {
  }

  /**
   * Constructor con la propiedad id
   * @param id del rol
   */
  public Rol(Long id) {
    this.id = id;
  }

  /**
   * Constuctor con todas las propiedades
   * @param id del rol
   * @param nombre del rol
   */
  public Rol(Long id, String nombre) {
    this.id = id;
    this.nombre = nombre;
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
    Rol other = (Rol) obj;
    return Objects.equals(id, other.id);
  }
}
