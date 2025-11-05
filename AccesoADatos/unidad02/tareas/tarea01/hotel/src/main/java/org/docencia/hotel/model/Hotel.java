package org.docencia.hotel.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @Column(name = "id", nullable = false)
    @NotBlank
    private String id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "address", nullable = false)
    @NotBlank
    private String address;

    @OneToMany(mappedBy = "hotel")
    private List<Hotel> rooms = new ArrayList<>();

    
    public Hotel() {
    }

    public Hotel(String id, @NotBlank String name, @NotBlank String address, List<Hotel> rooms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rooms = rooms;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Hotel> getRooms() {
        return rooms;
    }

    public void setRooms(List<Hotel> rooms) {
        this.rooms = rooms;
    }
}