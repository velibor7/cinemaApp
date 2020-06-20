package com.example.cinemaApp.service.impl;

import java.util.List;

import com.example.cinemaApp.models.User;
import com.example.cinemaApp.repository.UserRepository;
import com.example.cinemaApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    public User findOne(Integer id) {
        User user = this.userRepo.getOne(id);
        return user;
    }

    public List<User> findAll() {
        List<User> users = this.userRepo.findAll();
        return users;
    }

    public User save(User user) {
        return this.userRepo.save(user);
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}