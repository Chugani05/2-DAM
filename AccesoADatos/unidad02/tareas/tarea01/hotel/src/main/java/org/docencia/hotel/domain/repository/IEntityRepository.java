package org.docencia.hotel.domain.repository;

public interface IEntityRepository {
    /**
     * Check if exists by ID.
     * @param id ID.
     * @return It returns true if created, and false otherwise.
     */
    public boolean exists(int id);

    /**
     * Delete by ID.
     * @param id ID.
     * @return It returns true if created, and false otherwise.
     */
    public boolean delete(int id);
}
