package com.tiendaonline.service;

import com.tiendaonline.model.Cliente;
import com.tiendaonline.repository.ClienteDetallesRepository;
import com.tiendaonline.repository.ClienteRepository;
import com.tiendaonline.service.interfaces.IClienteService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService{

    private ClienteRepository clienteRepository;
    private ClienteDetallesRepository clienteDetallesRepository;

    @Override
    public List<Cliente> findAllSortedByNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllSortedByNombre'");
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        Optional<Cliente> clientOptional = clienteRepository.findById(id);
        if (clientOptional.isEmpty()) {
            return Optional.empty();
        }
        return clientOptional;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Integer id) {
        Cliente cliente = new Cliente(id, null, null, null);
        delete(cliente);
    }

    public boolean delete(Cliente cliente) {
        if (cliente == null) {
            return false;
        }
        int id = cliente.getId();
        if (!clienteRepository.existsById(id)) {
            return false;
        }
        clienteRepository.deleteById(id);
        clienteDetallesRepository.deleteByClienteId(id);
        return true;
    }
}
