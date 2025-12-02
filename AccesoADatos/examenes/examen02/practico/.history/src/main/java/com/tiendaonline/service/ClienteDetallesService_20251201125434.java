package com.tiendaonline.service;

import com.tiendaonline.model.Pedido;
import com.tiendaonline.service.interfaces.IClienteDetallesService;

import org.springframework.stereotype.Service;

@Service
public class ClienteDetallesService implements IClienteDetallesService{

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
