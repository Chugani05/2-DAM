package com.docencia.objetos.repo.jpa;

import java.util.Objects;
import jakarta.persistence.*;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

@Entity
@Table(name="alumnos")
public class AlumnoEntity {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre")
  private String nombre;
  
  @Column(name = "email", unique = true)
  private String email;
  
  @Column(name = "ciclo")
  private String ciclo;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "rol_id", nullable = false)
  private RolEntity rol;

  /**
  * Constructor por defecto
  */
  public AlumnoEntity() {
  }

  /**
   * Constuctor con todas las propiedades menos el rol
   * @param id del alumno
   * @param nombre del alumno
   * @param email del alumno
   * @param ciclo del alumno
   */
  public AlumnoEntity(Long id, String nombre, String email, String ciclo) {
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
  public AlumnoEntity(Long id, String nombre, String email, String ciclo, RolEntity rol) {
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

  public RolEntity getRol() {
    return rol;
  }

  public void setRol(RolEntity rol) {
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
    AlumnoEntity other = (AlumnoEntity) obj;
    return Objects.equals(id, other.id);
  }
}
