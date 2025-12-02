package com.tiendaonline.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Class Cliente
 * Clase que representa a un cliente.
 * 
 * @author Chugani05
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    private int id;

    private String nombre;
    private String email;
    private List<Pedido> pedidos;

    /**
     * Constructor vacío de la clase.
     */
    public Cliente() {
    }

    /**
     * Constructor con los parametros de la clase.
     * @param id Identificador del cliente.
     * @param nombre Nombre del cliente.
     * @param email Email del cliente.
     * @param pedidos Lista de pedidos realizados por el cliente.
     */
    public Cliente(int id, String nombre, String email, List<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.pedidos = pedidos;
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
        Cliente other = (Cliente) obj;
        return id == other.id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "pedidos", nullable = false)
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
