package com.tiendaonline.service;

import com.tiendaonline.model.Cliente;
import com.tiendaonline.model.LineaPedido;
import com.tiendaonline.model.Pedido;
import com.tiendaonline.repository.ClienteRepository;
import com.tiendaonline.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Pedido crearPedido(Long clienteId, String estado, List<LineaPedido> lineas) {
        if (clienteId == null) {
            throw new IllegalArgumentException("clienteId no puede ser null");
        }
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("estado no puede ser null ni vacío");
        }
        if (lineas == null || lineas.isEmpty()) {
            throw new IllegalArgumentException("lineas no pueden ser nulas ni vacías");
        }

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        Pedido pedido = new Pedido(LocalDateTime.now(), estado, cliente);

        for (LineaPedido linea : lineas) {
            linea.setPedido(pedido);
            pedido.getLineas().add(linea);
        }

        return pedidoRepository.save(pedido);
    }

    public Pedido findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id no puede ser null");
        }
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
    }
}
