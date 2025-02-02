package com.example.cinemaApp.controller;

import java.util.List;

import com.example.cinemaApp.models.Movie;
import com.example.cinemaApp.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/api/movie")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies;
        movies = movieService.findAll();
        // fali dto
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    // public ResponseEntity<Movie> getMovie(@PathVariable Integer id) {

    // Movie movie = movieService.findOne(id);

    // return new ResponseEntity<>(movie, HttpStatus.OK);
    // }
}