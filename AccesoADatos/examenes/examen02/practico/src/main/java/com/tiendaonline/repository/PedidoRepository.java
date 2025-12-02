package com.tiendaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendaonline.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    Pedido save(Integer clienteId, String estado);

    
}