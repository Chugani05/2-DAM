package com.tiendaonline.service;

import com.tiendaonline.model.Cliente;
import com.tiendaonline.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAllSortedByNombre() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .sorted(Comparator.comparing(Cliente::getNombre, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public Optional<Cliente> findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id no puede ser null");
        }
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("cliente no puede ser null");
        }
        return clienteRepository.save(cliente);
    }

    public void deleteById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id no puede ser null");
        }
        clienteRepository.deleteById(id);
    }
}
