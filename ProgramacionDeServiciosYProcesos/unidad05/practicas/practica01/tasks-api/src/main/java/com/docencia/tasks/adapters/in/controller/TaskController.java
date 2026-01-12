package com.docencia.tasks.adapters.in.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import com.docencia.tasks.adapters.in.api.TaskRequest;
import com.docencia.tasks.adapters.in.api.TaskResponse;
import com.docencia.tasks.adapters.mappers.TaskMapper;
import com.docencia.tasks.business.TaskService;
import com.docencia.tasks.domain.model.Task;
import com.docencia.tasks.entitys.TaskEntity;
import com.docencia.tasks.repository.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@Tag(name = "Tasks API")
@CrossOrigin
public class TaskController {

    private final TaskService service;
    private TaskMapper mapper;

    public TaskController(TaskService service) {
        this.service = service;
    }

    public void setMapper(TaskMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Get all tasks")
    public List<TaskResponse> getAll() {
        return null;
    }

    @PostMapping
    @Operation(summary = "Create new task")
    public TaskResponse create(@RequestBody TaskRequest taskRequest) {
        Task task = mapper.requestToTask(taskRequest);
        task = service.createTask(task);
        return mapper.taskToRequest(task);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update task")
    public TaskResponse update(@PathVariable Long id, @RequestBody TaskRequest task) {
        task.setCompletada(task.isCompletada());
        task.setTitulo(task.getTitulo());
        task.setDescripcion(task.getDescripcion());
        return null;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete task")
    public void delete(@PathVariable Long id) {
        // repo.deleteById(id);
    }
}
