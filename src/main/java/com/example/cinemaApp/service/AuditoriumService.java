package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.Auditorium;
import com.example.cinemaApp.repository.AuditoriumRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface AuditoriumService {

    Auditorium findOne(Integer id);

    List<Auditorium> findAll();

    Auditorium save(Auditorium auditorium);
}