package com.tiendaonline.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cliente_detalles")
public class ClienteDetalles {

    @Id
    private String id;

    private int clienteId;

    private String telefono;

    private List<Direccion> direcciones;

    private Preferencias preferencias;

    private String notasInternas;

    public ClienteDetalles() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public Preferencias getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(Preferencias preferencias) {
        this.preferencias = preferencias;
    }

    public String getNotasInternas() {
        return notasInternas;
    }

    public void setNotasInternas(String notasInternas) {
        this.notasInternas = notasInternas;
    }
}
