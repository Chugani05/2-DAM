package com.tiendaonline.service;

import com.tiendaonline.model.ClienteDetalles;
import com.tiendaonline.repository.ClienteDetallesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteDetallesService {

    private final ClienteDetallesRepository detallesRepository;

    public ClienteDetallesService(ClienteDetallesRepository detallesRepository) {
        this.detallesRepository = detallesRepository;
    }

    public Optional<ClienteDetalles> findByClienteId(int clienteId) {
        if (clienteId == null) {
            throw new IllegalArgumentException("clienteId no puede ser null");
        }
        return detallesRepository.findByClienteId(clienteId);
    }

    public ClienteDetalles saveDetallesForCliente(int clienteId, ClienteDetalles detalles) {
        if (clienteId == null) {
            throw new IllegalArgumentException("clienteId no puede ser null");
        }
        if (detalles == null) {
            throw new IllegalArgumentException("detalles no puede ser null");
        }
        detalles.setClienteId(clienteId);
        return detallesRepository.save(detalles);
    }
}
