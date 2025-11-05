package org.docencia.hotel.domain.repository;

import java.util.ArrayList;

import org.docencia.hotel.model.Hotel;

public interface IHotelRepository extends IEntityRepository{

    /**
     * Retrieves a hoitel by its ID.
     * @param id Hotel ID.
     * @return It returns true if created, and false otherwise.
     */
    Hotel findById(String id);

    /**
     * Retrieves the list of hotel.
     * @return List of all the hotels.
     */
    ArrayList<Hotel> findAll();

    /**
     * Creates or updates a hotel depending on whether it already exists or not.
     * @param hotel The hotel to save/update.
     * @return The saved/updated hotel.
     */
    Hotel save(Hotel hotel);
}
