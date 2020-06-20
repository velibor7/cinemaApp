package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.Auditorium;
import com.example.cinemaApp.repository.AuditoriumRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface AuditoriumService {

    // @Autowired
    // private AuditoriumRepository auditoriumRepo;

    Auditorium findOne(Long id) {
        // Auditorium auditorium = this.auditoriumRepo.getOne(id);
        // return auditorium;
    }

    List<Auditorium> findAll() {
        // List<Auditorium> auditoriums = this.auditoriumRepo.findAll();
        // return auditoriums;
    }

    Auditorium save(Auditorium auditorium) {
        // return this.auditoriumRepo.save(auditorium);
    }
}