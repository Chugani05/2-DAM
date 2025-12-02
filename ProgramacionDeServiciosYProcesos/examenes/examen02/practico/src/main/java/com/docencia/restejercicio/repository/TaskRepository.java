package com.docencia.restejercicio.repository;

import com.docencia.restejercicio.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository {


    public List<Task> findAll() {
        return null;
    }

    public Optional<Task> findById(Long id) {
       return null;
    }

    public Task save(Task task) {
        return null;
    }

    public void deleteById(Long id) {
        
    }

    public boolean existsById(Long id) {
        return false;
    }
}
