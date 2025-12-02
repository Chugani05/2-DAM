package com.docencia.restejercicio.controller;

import com.docencia.restejercicio.model.Task;
import com.docencia.restejercicio.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Class TaskController
 * Es el controlador que gestina los "end points" relacionados con las tareas.
 * 
 * @author Chugani05
 */
@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tareas", description = "Operaciones sobre tareas")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public void settaskRepository(TaskService taskService) {
        this.taskService = taskService;
    }


    @Operation(summary = "Get all tasks")
    @GetMapping("/")
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @Operation(summary = "Get task by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable(value = "id") Long taskId) {
        Task task = taskService.getById(taskId);
        return ResponseEntity.ok().body(task);
    }

    @Operation(summary = "Create task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping("/")
    public Task create(@Valid @RequestBody Task task) {
        return taskService.create(task);
    }

    @Operation(summary = "Update task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task updated successfully"),
            @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable(value = "id") Long taskId,
                                           @Valid @RequestBody Task taskDetails) {
        final Task updatedtask = taskService.update(taskId, taskDetails);
        return ResponseEntity.ok(updatedtask);
    }

    @Operation(summary = "Delete task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Task not found")
    })
    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long taskId) {
        taskService.delete(taskId); 
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
