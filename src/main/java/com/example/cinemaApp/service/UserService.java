package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.User;
import com.example.cinemaApp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {

    User findOne(Integer id);

    List<User> findAll();

    User save(User user);

    User findByUsername(String username);
}