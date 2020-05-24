package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.User;
import com.example.cinemaApp.models.Viewer;
import com.example.cinemaApp.repository.viewerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewerService {
    @Autowired
    private ViewerRepository viewerRepo;

    public Viewer findOne(Long id) {
        Viewer viewer = this.viewerRepo.getOne(id);
        return viewer;
    }

    public List<Viewer> findAll() {
        List<User> users = this.viewerRepo.findAll();
        return users;
    }

    public User save(User user) {
        return this.viewerRepo.save(user);
    }
}