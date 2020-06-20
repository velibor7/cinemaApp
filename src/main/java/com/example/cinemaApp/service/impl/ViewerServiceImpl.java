package com.example.cinemaApp.service.impl;

import java.util.List;

import com.example.cinemaApp.models.Viewer;
import com.example.cinemaApp.repository.ViewerRepository;
import com.example.cinemaApp.service.ViewerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewerServiceImpl implements ViewerService {

    @Autowired
    private ViewerRepository viewerRepo;

    public Viewer findOne(Integer id) {
        Viewer viewer = this.viewerRepo.getOne(id);
        return viewer;
    }

    public List<Viewer> findAll() {
        List<Viewer> viewers = this.viewerRepo.findAll();
        return viewers;
    }

    public Viewer save(Viewer viewer) {
        return this.viewerRepo.save(viewer);
    }
}