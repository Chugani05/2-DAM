package com.docencia.rest.domain;

import java.math.BigDecimal;

import java.util.Objects;



/**
 * Class Producto
 * Es la clase del dominio que representa un producto dentro del sistema.
 * 
 * @author Chugani05
 */
public class Producto {
    
    private int id;
    private String nombre;
    private BigDecimal precio;
    private int stock;
    private DetalleProducto detalleProducto;

    public Producto() {
    }

    public Producto(int id) {
        this.id = id;
    }


    public Producto(int id, String nombre, BigDecimal precio, int stock, DetalleProducto detalleProducto) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.detalleProducto = detalleProducto;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return this.precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public DetalleProducto getDetalleProducto() {
        return this.detalleProducto;
    }

    public void setDetalleProducto(DetalleProducto detalleProducto) {
        this.detalleProducto = detalleProducto;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Producto)) {
            return false;
        }
        Producto producto = (Producto) o;
        return id == producto.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio, stock, detalleProducto);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", precio='" + getPrecio() + "'" +
            ", stock='" + getStock() + "'" +
            ", detalleProducto='" + getDetalleProducto() + "'" +
            "}";
    }
   

}
