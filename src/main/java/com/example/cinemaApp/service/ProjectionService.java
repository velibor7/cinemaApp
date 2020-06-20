package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.Projection;
import com.example.cinemaApp.repository.ProjectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ProjectionService {

    Projection findOne(Long id);

    List<Projection> findAll();

    Projection save(Projection projection);
}