package com.docencia.rest.repository.interfaces;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.docencia.rest.modelo.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer>{

    /**
     * Ejemplo de una busqueda especifica.
     */
    List<ProductoEntity> findAllByPrecio(BigDecimal precio);
}
