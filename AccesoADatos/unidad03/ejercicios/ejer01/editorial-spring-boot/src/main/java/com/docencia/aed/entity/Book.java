package com.docencia.aed.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @NotBlank
    private Long id;

    @Column(name = "title", nullable = false)
    @NotBlank
    private String title;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id")
    private Author author;

    /**
     * Contructor vacio de la clase.
     */
    public Book() {
    }

    /**
     * Constructor con identificador unico de la clase.
     * @param id
     */
    public Book(Long id) {
        this.id = id;
    }

    /**
     * Contructor con parametros de la clase.
     * @param id
     * @param title
     * @param publicationYear
     * @param author
     */
    public Book(Long id, String title, Integer publicationYear, Author author) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
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

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
        Book other = (Book) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", publicationYear=" + publicationYear + ", author=" + author
                + "]";
    }
}
