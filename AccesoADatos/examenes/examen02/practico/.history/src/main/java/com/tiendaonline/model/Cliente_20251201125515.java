package com.tiendaonline.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private int id;

    private String nombre;
    private String email;
    private List<Pedido> pedidos;

    public Cliente() {
    }

    
}
