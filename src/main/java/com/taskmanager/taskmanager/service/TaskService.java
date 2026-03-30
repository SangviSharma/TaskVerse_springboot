package com.taskmanager.taskmanager.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.repository.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repo;

    public Task save(Task task){
        return repo.save(task);
    }

    public List<Task> getAll(){
        return repo.findAll();
    }

    public Task getById(Long id){
        return repo.findById(id).orElseThrow();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}