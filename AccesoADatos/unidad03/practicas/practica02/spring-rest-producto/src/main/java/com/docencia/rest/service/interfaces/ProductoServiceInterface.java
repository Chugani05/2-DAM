package com.docencia.rest.service.interfaces;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.docencia.rest.domain.Producto;

public interface ProductoServiceInterface {
    
    /**
     * Busca un producto según los atributos proporcionados en el objeto Producto.
     * Normalmente se utiliza cuando se quiere buscar por más de un campo.
     *
     * @param producto Objeto con los datos a usar para la búsqueda.
     * @return Optional con el producto encontrado, o vacío si no existe.
     */
    Optional<Producto> find(Producto producto);

    /**
     * Busca un producto por su identificador único.
     *
     * @param id Identificador del producto.
     * @return Optional con el producto encontrado, o vacío si no existe.
     */
    Optional<Producto> findById(int id);

    /**
     * Obtiene la lista completa de productos almacenados.
     *
     * @return Lista con todos los productos.
     */
    List<Producto> findAll();

    /**
     * Guarda o actualiza un producto en la base de datos.
     *
     * @param producto Producto a guardar.
     * @return El producto guardado o actualizado.
     */
    Producto save(Producto producto);

    /**
     * Elimina un producto mediante el objeto completo.
     *
     * @param producto Producto a eliminar.
     * @return true si la eliminación fue exitosa, false si no se pudo eliminar.
     */
    boolean delete(Producto producto);

    /**
     * Elimina un producto utilizando su identificador.
     *
     * @param id Identificador del producto a eliminar.
     * @return true si fue eliminado correctamente, false si no existe o no se pudo eliminar.
     */
    boolean deleteById(int id);

    /**
     * Busca todos los productos que tengan un precio específico.
     *
     * @param precio Precio a comparar.
     * @return Lista de productos cuyo precio coincide con el indicado.
     */
    List<Producto> findAllByPrecio(BigDecimal precio);
}
