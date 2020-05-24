package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.User;

import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepo;

    public User findOne(Long id) {
        User user = this.movieRepo.getOne(id);
        return user;
    }

    public List<User> findAll() {
        List<User> users = this.movieRepo.findAll();
        return users;
    }

    public User save(User user) {
        return this.movieRepo.save(user);
    }
}