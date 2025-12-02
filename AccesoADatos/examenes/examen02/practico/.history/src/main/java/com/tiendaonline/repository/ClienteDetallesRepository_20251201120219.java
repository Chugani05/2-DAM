package com.tiendaonline.repository;

import com.tiendaonline.model.ClienteDetalles;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClienteDetallesRepository extends MongoRepository<ClienteDetalles, String> {

    Optional<ClienteDetalles> findByClienteId(Long clienteId);
}
