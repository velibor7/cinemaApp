package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.Cinema;
import com.example.cinemaApp.repository.CinemaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface CinemaService {

    Cinema findOne(Long id);

    List<Cinema> findAll();

    Cinema save(Cinema cinema);
}