package org.docencia.hotel.persistence.jpa.interfaces;

import java.util.List;

public interface CrudInterface<TYPE, ID> {
    public boolean exists(ID id);
    public TYPE findById(ID id);
    public List<TYPE> findAll();
    public TYPE save(TYPE entity);
    public boolean delete(ID id);
}
