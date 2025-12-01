package com.docencia.rest.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.rest.modelo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
