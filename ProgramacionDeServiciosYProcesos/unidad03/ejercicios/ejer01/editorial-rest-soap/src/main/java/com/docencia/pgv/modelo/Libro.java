package com.docencia.pgv.modelo;

public class Libro {

    private Long id;
    private String titulo;
    private Integer anioPublicacion;
    private Long idAutor;

    public Libro() {}

    public Libro(Long id, String titulo, Integer anioPublicacion, Long idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.idAutor = idAutor;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public Integer getAnioPublicacion() { return anioPublicacion; }
    public Long getIdAutor() { return idAutor; }

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAnioPublicacion(Integer anioPublicacion) { this.anioPublicacion = anioPublicacion; }
    public void setIdAutor(Long idAutor) { this.idAutor = idAutor; }
}
