package com.docencia.aed.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @NotBlank
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "city")
    private String city;


    /**
     * Contructor vacio de la clase.
     */
    public Publisher() {
    }

    /**
     * Constructor con identificador unico de la clase.
     * @param id
     */
    public Publisher(Long id) {
        this.id = id;
    }

    /**
     * Contructor con parametros de la clase.
     * @param id
     * @param name
     * @param city
     */
    public Publisher(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
        Publisher other = (Publisher) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Publisher [id=" + id + ", name=" + name + ", city=" + city + "]";
    }

    
}
