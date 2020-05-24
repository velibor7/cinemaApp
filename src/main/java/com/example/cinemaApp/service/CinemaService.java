package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.Cinema;
import com.example.cinemaApp.repository.CinemaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepo;

    public Cinema findOne(Long id) {
        Cinema cinema = this.cinemaRepo.getOne(id);
        return cinema;
    }

    public List<Cinema> findAll() {
        List<Cinema> cinemas = this.cinemaRepo.findAll();
        return cinemas;
    }

    public Cinema save(Cinema cinema) {
        return this.cinemaRepo.save(cinema);
    }
}