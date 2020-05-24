package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.Movie;
import com.example.cinemaApp.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    public Movie findOne(Long id) {
        Movie movie = this.movieRepo.getOne(id);
        return movie;
    }

    public List<Movie> findAll() {
        List<Movie> movies = this.movieRepo.findAll();
        return movies;
    }

    public Movie save(Movie movie) {
        return this.movieRepo.save(movie);
    }
}