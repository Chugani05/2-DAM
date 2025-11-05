package org.docencia.hotel.domain.repository;

import java.util.ArrayList;

import org.docencia.hotel.model.Guest;

public interface IGuestRepository extends IEntityRepository{

    /**
     * Retrieves a guest by its ID.
     * @param id Guest ID.
     * @return It returns true if created, and false otherwise.
     */
    public Guest findById(String id);

    /**
     * Retrieves the list of guests.
     * @return List of all the guests.
     */
    public ArrayList<Guest> findAll();

    /**
     * Creates or updates a guest depending on whether it already exists or not.
     * @param Guest The guest to save/update.
     * @return The saved/updated guest.
     */
    public Guest save(Guest Guest);
}
