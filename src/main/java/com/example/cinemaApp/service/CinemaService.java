package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.Cinema;
import com.example.cinemaApp.models.Manager;
import com.example.cinemaApp.repository.CinemaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface CinemaService {

    Cinema findOne(Integer id);

    List<Cinema> findAll();

    List<Cinema> findByManager(Manager manager);

    Cinema save(Cinema cinema);

    Cinema delete(Integer id);
}