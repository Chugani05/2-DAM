package com.tiendaonline.service;

import com.tiendaonline.model.Cliente;
import com.tiendaonline.model.Pedido;
import com.tiendaonline.service.interfaces.IPedidoService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService implements IPedidoService{

    @Override
    public Pedido crearPedido(Integer clienteId, String estado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearPedido'");
    }

    @Override
    public Pedido findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    
}
