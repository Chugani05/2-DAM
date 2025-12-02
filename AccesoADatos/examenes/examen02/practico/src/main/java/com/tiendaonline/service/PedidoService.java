package com.tiendaonline.service;

import com.tiendaonline.model.ClienteDetalles;
import com.tiendaonline.model.Pedido;
import com.tiendaonline.repository.PedidoRepository;
import com.tiendaonline.service.interfaces.IPedidoService;

import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class PedidoService implements IPedidoService{

    private PedidoRepository pedidoRepository;

    @Override
    public Pedido crearPedido(Integer clienteId, String estado) {
        return pedidoRepository.save(clienteId, estado);
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id);
    }

    
}
