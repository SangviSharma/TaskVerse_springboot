package com.taskmanager.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.taskmanager.taskmanager.model.User;
import com.taskmanager.taskmanager.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    // ================= REGISTER / SAVE =================
    public User save(User user){
        return repo.save(user);
    }

    // ================= LOGIN =================
    public User login(String email,String password){

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Invalid password");
        }

        return user;
    }

    // ================= GET ALL =================
    public List<User> getAll(){
        return repo.findAll();
    }

    // ================= GET ONE =================
    public User getById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // ================= DELETE =================
    public void delete(Long id){
        repo.deleteById(id);
    }
}