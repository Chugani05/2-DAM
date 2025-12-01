package com.docencia.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.docencia.rest.domain.Producto;
import com.docencia.rest.modelo.DetalleProductoDocument;
import com.docencia.rest.modelo.ProductoEntity;

/**
 * Es el mapper que transforma entre el dominio Producto y su entidad, 
 * incluyendo la conversión del detalle del producto.
 */
@Mapper(componentModel = "spring", uses = { DetalleProductoMapper.class })
public interface ProductoMapper {

    ProductoEntity toEntity(Producto source);

    Producto toDomain(ProductoEntity source);
    
    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "detalleProducto", source = "detalle")
    Producto toDomain(ProductoEntity entity, DetalleProductoDocument detalle);

} 