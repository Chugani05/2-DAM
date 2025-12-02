package com.tiendaonline.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    private int id;

    private String nombre;
    private String email;
    private List<Pedido> pedidos;

    public Cliente() {
    }

    
}
