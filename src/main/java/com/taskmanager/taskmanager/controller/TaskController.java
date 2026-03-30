package com.taskmanager.taskmanager.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TaskController {

    private final TaskService service;

    @PostMapping
    public Task create(@RequestBody Task task){
        return service.save(task);
    }

    @GetMapping
    public List<Task> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Task getOne(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id,@RequestBody Task task){
        task.setId(id);
        return service.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}