package com.tiendaonline.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


public class Pedido {

    private int id;
    private String estado;
    private Cliente cliente;

    public Pedido() {
    }

    
}
