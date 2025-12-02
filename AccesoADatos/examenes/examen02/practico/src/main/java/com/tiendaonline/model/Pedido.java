package com.tiendaonline.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {

    private int id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cliente")
    private Cliente cliente;

    /**
     * Constructor vacío de la clase.
     */
    public Pedido() {
    }

    /**
     * Constructor con identificador único de la clase.
     */
    public Pedido(int id) {
        this.id = id;
    }
    
    /**
     * Constructor con los parametros de la clase.
     * @param id Identificador del pedido.
     * @param estado Estado del pedido.
     * @param cliente Cliente del pedido.
     */
    public Pedido(int id, String estado, Cliente cliente) {
        this.id = id;
        this.estado = estado;
        this.cliente = cliente;
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
        Pedido other = (Pedido) obj;
        return id == other.id;
    }

    
}
