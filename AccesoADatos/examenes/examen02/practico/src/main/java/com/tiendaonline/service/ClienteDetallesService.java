package com.tiendaonline.service;

import com.tiendaonline.model.ClienteDetalles;
import com.tiendaonline.repository.ClienteDetallesRepository;
import com.tiendaonline.service.interfaces.IClienteDetallesService;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ClienteDetallesService implements IClienteDetallesService {

    private ClienteDetallesRepository clienteDetallesRepository;

    @Override
    public Optional<ClienteDetalles> findByClienteId(int clienteId) {
        Optional<ClienteDetalles> detalleOptional = clienteDetallesRepository.findByClienteId(clienteId);
        if (detalleOptional.isEmpty()) {
            return Optional.empty();
        }
        return detalleOptional;
    }

    @Override
    public ClienteDetalles saveDetallesForClientes(int clienteId, ClienteDetalles detalles) {
        return clienteDetallesRepository.save(detalles, clienteId);
    }
}
