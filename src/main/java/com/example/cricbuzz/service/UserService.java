package com.example.cricbuzz.service;

import com.example.cricbuzz.model.User;
import com.example.cricbuzz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User findUser(String username){
        return userRepository.findByUsername(username);
    }

}
