package com.example.cinemaApp.service.impl;

import java.util.List;

import com.example.cinemaApp.models.Projection;
import com.example.cinemaApp.repository.ProjectionRepository;
import com.example.cinemaApp.service.ProjectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectionServiceImpl implements ProjectionService {

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