package com.docencia.rest.modelo;

import java.math.BigDecimal;

import java.util.Objects;

import jakarta.persistence.*;

/**
 * relacional
 */
@Entity
@Table(name = "productos")
public class ProductoEntity {
    
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "stock")
    private int stock;

    public ProductoEntity() {
    }

    public ProductoEntity(int id) {
        this.id = id;
    }

    public ProductoEntity(String nombre, BigDecimal precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductoEntity other = (ProductoEntity) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
