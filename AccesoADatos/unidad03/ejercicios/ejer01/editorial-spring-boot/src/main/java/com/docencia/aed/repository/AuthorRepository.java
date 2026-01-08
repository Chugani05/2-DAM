package com.docencia.aed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docencia.aed.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
