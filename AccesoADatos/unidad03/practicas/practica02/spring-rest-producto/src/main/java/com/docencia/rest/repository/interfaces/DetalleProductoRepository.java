package com.docencia.rest.repository.interfaces;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.docencia.rest.modelo.DetalleProductoDocument;


public interface DetalleProductoRepository extends MongoRepository<DetalleProductoDocument, Integer> {
    Optional<DetalleProductoDocument> findByProductoId(int productoId);
    boolean deleteByProductoId(int productoId);
}
