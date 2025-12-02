package com.docencia.restejercicio.repository;

import com.docencia.restejercicio.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {



    public List<User> findAll() {
        return null;
    }

    public Optional<User> findById(Long id) {
        return null;
    }

    public User save(User user) {
        return null;
    }

    public void deleteById(Long id) {
        
    }

    public boolean existsById(Long id) {
        return false;
    }
}
