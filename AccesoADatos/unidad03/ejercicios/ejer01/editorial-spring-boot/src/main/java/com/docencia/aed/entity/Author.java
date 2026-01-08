package com.docencia.aed.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @NotBlank
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "country")
    private String country;
    
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    /**
     * Contructor vacio de la clase.
     */
    public Author() {
    }

    /**
     * Constructor con identificador unico de la clase.
     * @param id
     */
    public Author(Long id) {
        this.id = id;
    }

    /**
     * Contructor con parametros de la clase.
     * @param id
     * @param name
     * @param country
     * @param books
     */
    public Author(Long id, String name, String country, List<Book> books) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.books = books;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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
        Author other = (Author) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Author [id=" + id + ", name=" + name + ", country=" + country + ", books=" + books + "]";
    }
}
