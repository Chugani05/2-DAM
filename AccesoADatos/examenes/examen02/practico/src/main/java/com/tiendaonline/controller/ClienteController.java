package com.tiendaonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendaonline.model.Cliente;
import com.tiendaonline.service.ClienteDetallesService;
import com.tiendaonline.service.ClienteService;

@RestController
@RequestMapping(("/api/v1/clientes"))
public class ClienteController {

    private ClienteService clienteService;
    private ClienteDetallesService clienteDetallesService;

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public ClienteDetallesService getClienteDetallesService() {
        return clienteDetallesService;
    }

    @GetMapping("/")
    public List<Cliente> findAllSortedByNombre() {
        return clienteService.findAllSortedByNombre();
    }

    @GetMapping("/{id}")
    public ClienteDetallesService findByClienteId(@PathVariable(value = "id") int clienteId) {
        Cliente cliente = clienteDetallesService.findByClienteId(clienteId);
        return ClienteDetallesService.ok().body(cliente);
    }

    @PostMapping("/")
    
    @PutMapping("/cliente/{id}")
    
    @DeleteMapping("/cliente/{id}")

    @PostMapping("/clientes/{id}/detalles")

    @PostMapping("pedidos/cliente/{clienteId}")

     @GetMapping("/pedidos/{id}")
}
