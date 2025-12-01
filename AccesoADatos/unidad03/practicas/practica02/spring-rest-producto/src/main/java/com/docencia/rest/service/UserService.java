package com.docencia.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.docencia.rest.exception.ResourceNotFoundException;
import com.docencia.rest.modelo.User;
import com.docencia.rest.repository.interfaces.UserRepository;
import com.docencia.rest.service.interfaces.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface{

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(@PathVariable(value = "id") int userId) throws ResourceNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
    }

    public User createUser(@Validated @RequestBody User user) {
        return userRepository.save(user);
    }

    public User updateUser(@PathVariable(value = "id") int userId,
                                           @Validated @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setName(userDetails.getName());
        return userRepository.save(user);
    }

    public boolean deleteUser(@PathVariable(value = "id") int userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        userRepository.delete(user);
        return true;
    }
}
