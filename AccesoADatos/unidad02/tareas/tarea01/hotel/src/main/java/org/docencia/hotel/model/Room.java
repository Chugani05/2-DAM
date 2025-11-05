package org.docencia.hotel.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "room_number", nullable = false)
    private int roomNumber;

    @Column(name = "room_type", nullable = false)
    @NotBlank
    private String roomType;

    @Column(name = "price_per_night", nullable = false)
    private int pricePerNight;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "room")
    private List<Room> bookings = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "guest")
    private Room room;


    public Room() {
    }

    public Room(int id, int roomNumber, @NotBlank String roomType, int pricePerNight, Hotel hotel, List<Room> bookings,
            Room room) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.hotel = hotel;
        this.bookings = bookings;
        this.room = room;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
