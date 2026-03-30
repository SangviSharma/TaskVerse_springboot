package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.model.User;
import com.taskmanager.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // REGISTER
    public User register(User user){
        return repo.save(user);
    }

    // LOGIN
    public User login(String email, String password){

        Optional<User> user = repo.findByEmail(email);

        if(user.isPresent()
            && user.get().getPassword().equals(password)){
            return user.get();
        }

        return null;
    }
}