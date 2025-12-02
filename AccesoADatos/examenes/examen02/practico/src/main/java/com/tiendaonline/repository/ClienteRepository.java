package com.tiendaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendaonline.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    
}
