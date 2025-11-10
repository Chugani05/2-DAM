package org.docencia.hotel.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.docencia.hotel.model.Booking;
import org.docencia.hotel.model.Room;

public interface IBookingRepository  extends IEntityRepository{
    
    /**
     * Retrieves a booking by its ID.
     * @param id Booking ID.
     * @return It returns true if created, and false otherwise.
     */
    public Booking findById(String id);

    /**
     * Retrieves the list of bookings.
     * @return List of all the reservations.
     */
    public List<Booking> findAll();

    /**
     * Creates or updates a booking depending on whether it already exists or not.
     * @param Booking The booking to save/update.
     * @return The saved/updated booking.
     */
    public Booking save(Booking booking);
    
    /**
     * obtain all reservations for a specific room within a given date range
     * @param room Room to check.
     * @param checkIn Check-in date.
     * @param checkOut Check-out date.
     * @return List of reservations for a specific room within a given date range.
     */
    public List<Booking> findRoomBookings(Room room, LocalDateTime checkIn, LocalDateTime checkOut);
}
