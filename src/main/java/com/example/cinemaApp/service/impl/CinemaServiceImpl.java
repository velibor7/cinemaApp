package com.example.cinemaApp.service.impl;

import java.util.List;

import com.example.cinemaApp.models.Cinema;
import com.example.cinemaApp.models.Manager;
import com.example.cinemaApp.repository.CinemaRepository;
import com.example.cinemaApp.service.CinemaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepo;

    public Cinema findOne(Integer id) {
        Cinema cinema = this.cinemaRepo.getOne(id);
        return cinema;
    }

    public List<Cinema> findAll() {
        List<Cinema> cinemas = this.cinemaRepo.findAll();
        return cinemas;
    }

    public List<Cinema> findByManager(Manager manager) {
        List<Cinema> cinemas = this.cinemaRepo.findByManager(manager);
        return cinemas;
    }

    public Cinema save(Cinema cinema) {
        return this.cinemaRepo.save(cinema);
    }

    public Cinema delete(Integer id) {
        Cinema cinema = cinemaRepo.getOne(id);
        if (cinema != null) {
            this.cinemaRepo.delete(cinema);
        }
        return cinema;
    }
}