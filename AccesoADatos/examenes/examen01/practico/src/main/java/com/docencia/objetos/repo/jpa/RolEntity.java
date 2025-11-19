package com.docencia.objetos.repo.jpa;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

@Entity
@Table(name = "roles")
public class RolEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre", nullable = false, unique = true)
  private String nombre;

  @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<AlumnoEntity> alumnos = new ArrayList<>();

  /**
  * Constructor por defecto
  */
  public RolEntity() {
  }

  /**
   * Constructor con la propiedad id
   * @param id del rol
   */
  public RolEntity(Long id, String nombre) {
    this.id = id;
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

  public List<AlumnoEntity> getAlumnos() {
    return alumnos;
  }

  public void setAlumnos(List<AlumnoEntity> alumnos) {
    this.alumnos = alumnos;
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
    RolEntity other = (RolEntity) obj;
    return Objects.equals(id, other.id);
  }
}
