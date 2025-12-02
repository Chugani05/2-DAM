package com.docencia.restejercicio.service;

import com.docencia.restejercicio.model.Task;
import com.docencia.restejercicio.repository.TaskRepository;


import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Class TaskService
 * Es el servicio que gestiona la lógica relacionada con las tareas.
 * 
 * @author Chugani05 
 */
@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAll() {
        return repository.findAll();
    }

    public Task getById(Long id) {
        // return repository.findById(id);
        return null;
    }

    public Task create(Task task) {
        return repository.save(task);
    }

    public Task update(Long id, Task update) {
        // Task task = repository.getById(id);
        // task.setTitle(update.getTitle());
        // task.setDescription(update.getDescription());
        // task.setDone(update.isDone());
        // return repository.save(task);
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
