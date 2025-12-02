package com.tiendaonline.service.interfaces;

import com.tiendaonline.model.Pedido;

public interface IPedidoService {

    /**
     * Crea un nuevo pedido para el cliente indicado y con el estado dado.
     *
     * @param clienteId id del cliente (no puede ser null)
     * @param estado    estado del pedido (no puede ser null ni vacío)
     * @return el pedido creado y persistido
     * @throws IllegalArgumentException si clienteId es null, estado es null/vacío
     *                                  o el cliente no existe
     */
    @Transactional
    Pedido crearPedido(Integer clienteId, String estado);

    /**
     * Busca un pedido por su identificador.
     *
     * @param id identificador del pedido (no puede ser null)
     * @return el pedido encontrado
     * @throws IllegalArgumentException si id es null o no se encuentra el pedido
     */
    Pedido findById(Long id);
}
