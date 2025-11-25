package com.docencia.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.rest.modelo.Producto;

@Repository
public interface ProductoRepository  extends JpaRepository<Producto, Integer>{

}
