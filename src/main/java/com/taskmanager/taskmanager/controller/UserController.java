package com.taskmanager.taskmanager.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.taskmanager.taskmanager.model.User;
import com.taskmanager.taskmanager.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService service;

    // ================= REGISTER =================
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.save(user);
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public User login(@RequestBody User user){
        return service.login(user.getEmail(), user.getPassword());
    }

    // ================= CRUD =================
    @GetMapping
    public List<User> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id,@RequestBody User user){
        user.setId(id);
        return service.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}