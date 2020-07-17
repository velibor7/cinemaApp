package com.example.cinemaApp.service.impl;

import java.util.List;

import com.example.cinemaApp.models.Auditorium;
import com.example.cinemaApp.models.Cinema;
import com.example.cinemaApp.repository.AuditoriumRepository;
import com.example.cinemaApp.service.AuditoriumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    @Autowired
    private AuditoriumRepository auditoriumRepo;

    public Auditorium findOne(Integer id) {
        Auditorium auditorium = this.auditoriumRepo.getOne(id);
        return auditorium;
    }

    public List<Auditorium> findAll() {
        List<Auditorium> auditoriums = this.auditoriumRepo.findAll();
        return auditoriums;
    }

    public List<Auditorium> findByCinema(Cinema cinema) {
        List<Auditorium> auditoriums = this.auditoriumRepo.findByCinema(cinema);
        return auditoriums;
    }

    public Auditorium save(Auditorium auditorium) {
        return this.auditoriumRepo.save(auditorium);
    }

    public Auditorium delete(Integer id) {
        Auditorium auditorium = auditoriumRepo.getOne(id);
        if (auditorium != null) {
            this.auditoriumRepo.delete(auditorium);
        }
        return auditorium;
    }
}