package com.docencia.rest.domain;

import java.util.List;
import java.util.Map;

import java.util.Objects;

/**
 * Class DetalleProducto
 * 
 * Clase del dominio que representa el detalle asociado a un producto.
 * 
 * Se encarga de almacenar y transportar la información adicional o extendida
 * de un producto dentro de la aplicación. 
 * 
 * En esta capa (domain) solo se definen atributos, constructores, getters, 
 * setters, equals, hashCode y toString, sin usar anotaciones de base de datos.
 * 
 * Los métodos (getter, setter, equals, hashCode) y constructores 
 * (vacío, con ID y completo) deben generarse mediante "Source Actions".
 * 
 * Nota: Es recomendable generar el hashCode utilizando:
 *     return Objects.hash(id);
 * 
 * @author: Chugani05
 */
public class DetalleProducto {
    
    private int id;
    private int productoId;
    private String descripcionLarga;
    private Map<String, String> especificacionesTecnicas;
    private List<String> tags;

    /**
     * Constructor vacío de la clase.
     */
    public DetalleProducto() {
    }

    /**
     * Constructor con parametros de la clase.
     * @param id
     * @param productoId
     * @param descripcionLarga
     * @param especificacionesTecnicas
     * @param tags
     */
    public DetalleProducto(int id, int productoId, String descripcionLarga, Map<String,String> especificacionesTecnicas, List<String> tags) {
        this.id = id;
        this.productoId = productoId;
        this.descripcionLarga = descripcionLarga;
        this.especificacionesTecnicas = especificacionesTecnicas;
        this.tags = tags;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductoId() {
        return this.productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getDescripcionLarga() {
        return this.descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public Map<String,String> getEspecificacionesTecnicas() {
        return this.especificacionesTecnicas;
    }

    public void setEspecificacionesTecnicas(Map<String,String> especificacionesTecnicas) {
        this.especificacionesTecnicas = especificacionesTecnicas;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public DetalleProducto id(int id) {
        setId(id);
        return this;
    }

    public DetalleProducto productoId(int productoId) {
        setProductoId(productoId);
        return this;
    }

    public DetalleProducto descripcionLarga(String descripcionLarga) {
        setDescripcionLarga(descripcionLarga);
        return this;
    }

    public DetalleProducto especificacionesTecnicas(Map<String,String> especificacionesTecnicas) {
        setEspecificacionesTecnicas(especificacionesTecnicas);
        return this;
    }

    public DetalleProducto tags(List<String> tags) {
        setTags(tags);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DetalleProducto)) {
            return false;
        }
        DetalleProducto detalleProducto = (DetalleProducto) o;
        return id == detalleProducto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", productoId='" + getProductoId() + "'" +
            ", descripcionLarga='" + getDescripcionLarga() + "'" +
            ", especificacionesTecnicas='" + getEspecificacionesTecnicas() + "'" +
            ", tags='" + getTags() + "'" +
            "}";
    }
    
}
