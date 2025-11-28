package com.docencia.rest.service.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.docencia.rest.exeception.ResourceNotFoundException;
import com.docencia.rest.modelo.User;

import jakarta.validation.Valid;

public interface UserServiceInterface {
    public List<User> getAllUsers();
    public User getUserById(@PathVariable(value = "id") int userId) throws ResourceNotFoundException;
    public User createUser(@Valid @RequestBody User user);
    public User updateUser(@PathVariable(value = "id") int userId, @Valid @RequestBody User userDetails) throws ResourceNotFoundException;
    public boolean deleteUser(@PathVariable(value = "id") int userId) throws ResourceNotFoundException;
}
