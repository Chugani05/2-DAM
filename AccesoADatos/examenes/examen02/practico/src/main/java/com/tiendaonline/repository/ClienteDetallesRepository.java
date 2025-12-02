package com.tiendaonline.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tiendaonline.model.ClienteDetalles;


public interface ClienteDetallesRepository extends MongoRepository<ClienteDetalles, Integer> {

    Optional<ClienteDetalles> findByClienteId(int clienteId);
    boolean deleteByClienteId(int clienteId);
    ClienteDetalles save(ClienteDetalles detalles, int clienteId);
}
