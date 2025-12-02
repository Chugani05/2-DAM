package com.docencia.restejercicio.service;

import com.docencia.restejercicio.model.User;
import com.docencia.restejercicio.repository.UserRepository;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Class UserService
 * Es el servicio que gestiona la lógica relacionada con el usuario.
 * 
 * @author Chugani05 
 */
@Service
public class UserService {

    private final UserRepository repository;

    public UserService (UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        // return repository.findById(id);
        return null;
    }

    public User create(User user) {
       return repository.save(user);
    }

    public User update(Long id, User update) {
        // User user = repository.findById(id);
        // user.setId(update.getId());
        // user.setUsername(update.getUsername());
        // user.setEmail(update.getEmail());
        // return repository.save(user);
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
