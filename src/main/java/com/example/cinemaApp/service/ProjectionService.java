package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.Projection;
import com.example.cinemaApp.repository.ProjectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectionService {

    @Autowired
    private ProjectionRepository projectionRepo;

    public Projection findOne(Long id) {
        Projection projection = this.projectionRepo.getOne(id);
        return projection;
    }

    public List<Projection> findAll() {
        List<Projection> projections = this.projectionRepo.findAll();
        return projections;
    }

    public Projection save(Projection projection) {
        return this.projectionRepo.save(projection);
    }
}