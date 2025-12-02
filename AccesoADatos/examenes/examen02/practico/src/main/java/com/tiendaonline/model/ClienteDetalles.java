package com.tiendaonline.model;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

/**
 * Class DetalleProductoDocument
 * Es el documento que representa el detalle de los clientes almacenado en la base de datos.
 * 
 * @author Chugani05
 */
@Document(collection = "cliente_detalle")
public class ClienteDetalles {

    @Id
    private String id;
    private int clienteId;
    private String telefono;
    private String notasInternas;

    /**
     * Constructor vacío de la clase.
     */
    public ClienteDetalles() {
    }

    /**
     * Constructor con los parametros de la clase.
     * @param id Identificador de los detalles del cliente.
     * @param clienteId Identificador del cliente.
     * @param telefono Número de telefono del cliente.
     * @param notasInternas Notas internas del sistema.
     */
    public ClienteDetalles(String id, int clienteId, String telefono, String notasInternas) {
        this.id = id;
        this.clienteId = clienteId;
        this.telefono = telefono;
        this.notasInternas = notasInternas;
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
        ClienteDetalles other = (ClienteDetalles) obj;
        return Objects.equals(id, other.id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNotasInternas() {
        return notasInternas;
    }

    public void setNotasInternas(String notasInternas) {
        this.notasInternas = notasInternas;
    }
}
