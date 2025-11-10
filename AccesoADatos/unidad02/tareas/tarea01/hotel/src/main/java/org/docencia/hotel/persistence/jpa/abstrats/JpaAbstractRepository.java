package org.docencia.hotel.persistence.jpa.abstrats;

import java.util.List;

import org.docencia.hotel.persistence.jpa.interfaces.CrudInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public abstract class JpaAbstractRepository<TYPE, ID> implements CrudInterface<TYPE, ID> {

    public JpaRepository<TYPE, ID> repository;

    public JpaAbstractRepository(JpaRepository<TYPE, ID> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public boolean delete(ID id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean exists(ID id) {
        return repository.existsById(id);
    }

    @Override
    public List<TYPE> findAll() {
        return repository.findAll();
    }

    @Override
    public TYPE findById(ID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public abstract TYPE save(TYPE entity);
}
