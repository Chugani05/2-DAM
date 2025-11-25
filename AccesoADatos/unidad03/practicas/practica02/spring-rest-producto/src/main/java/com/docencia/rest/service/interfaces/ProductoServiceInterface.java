package com.docencia.rest.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.docencia.rest.modelo.Producto;

public interface ProductoServiceInterface {
    public Optional<Producto> find(Producto producto);
    public Optional<Producto> findById(int id);

    public List<Producto> findAll();

    public Producto save (Producto producto);

    public boolean delete (Producto producto);
    public boolean deleteById (int id);

}
