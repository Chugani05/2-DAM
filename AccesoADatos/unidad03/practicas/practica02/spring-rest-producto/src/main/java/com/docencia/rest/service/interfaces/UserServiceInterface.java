package com.docencia.rest.service.interfaces;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.docencia.rest.exception.ResourceNotFoundException;
import com.docencia.rest.modelo.User;

public interface UserServiceInterface {
    public List<User> getAllUsers();

    public User getUserById(@PathVariable(value = "id") int userId) throws ResourceNotFoundException;

    public User createUser(@Validated @RequestBody User user);

    public User updateUser(@PathVariable(value = "id") int userId,
            @Validated @RequestBody User userDetails) throws ResourceNotFoundException;

    public boolean deleteUser(@PathVariable(value = "id") int userId) throws ResourceNotFoundException;

}
