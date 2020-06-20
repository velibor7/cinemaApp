package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.Movie;
import com.example.cinemaApp.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface MovieService {

    Movie findOne(Long id);

    List<Movie> findAll();

    Movie save(Movie movie);
}