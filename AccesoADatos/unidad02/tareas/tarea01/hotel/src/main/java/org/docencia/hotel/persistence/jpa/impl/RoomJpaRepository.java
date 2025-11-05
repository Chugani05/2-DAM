package org.docencia.hotel.persistence.jpa.impl;

import java.util.ArrayList;

import org.docencia.hotel.domain.repository.IRoomRepository;
import org.docencia.hotel.model.Hotel;
import org.docencia.hotel.model.Room;

public class RoomJpaRepository implements IRoomRepository{

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Room findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public ArrayList<Room> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Room save(Room Room) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public ArrayList<Room> getRoomsByHotel(Hotel hotel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRoomsByHotel'");
    }

}
