package com.primetradebackend.controller;

import com.primetradebackend.entity.Task;
import com.primetradebackend.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task, Authentication auth) {

        String email = auth.getName();
        Task createdTask = taskService.createTask(task, email);

        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/my")
    public ResponseEntity<List<Task>> getMyTasks(Authentication auth) {

        String email = auth.getName();
        return ResponseEntity.ok(taskService.getUserTasks(email));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {

        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {

        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody Task task) {

        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);
        return ResponseEntity.ok("Task Deleted Successfully");
    }
}
