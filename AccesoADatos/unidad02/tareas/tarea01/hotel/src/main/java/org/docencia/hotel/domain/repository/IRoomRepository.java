package org.docencia.hotel.domain.repository;

import java.util.List;

import org.docencia.hotel.model.Hotel;
import org.docencia.hotel.model.Room;

public interface IRoomRepository extends IEntityRepository{

    /**
     * Retrieves a room by its ID.
     * @param id Room ID.
     * @return It returns true if created, and false otherwise.
     */
    public Room findById(String id);

    /**
     * Retrieves the list of rooms.
     * @return List of all the rooms.
     */
    public List<Room> findAll();

    /**
     * Creates or updates a room depending on whether it already exists or not.
     * @param Room The room to save/update.
     * @return The saved/updated room.
     */
    public Room save(Room room);

    /**
     * Retrieves all the rooms of an hotel.
     * @param hotel Hotel entity from which its rooms will be retrieved.
     * @return List of all the rooms of an hotel
     */
    public List<Room> getRoomsByHotel(Hotel hotel);
}
