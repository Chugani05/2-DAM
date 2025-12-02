package com.tiendaonline.service.interfaces;

import java.util.Optional;

import com.tiendaonline.model.ClienteDetalles;

public interface IClienteDetallesService {

    /**
     * 
     * @param clienteId
     * @return
     */
    public Optional<ClienteDetalles> findByClienteId(int clienteId);

    /**
     * 
     */
    public ClienteDetalles saveDetallesForClientes(int clienteId, ClienteDetalles detalles);
}
