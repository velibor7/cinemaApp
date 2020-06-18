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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "api/movie")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // @GetMapping("/movies")
    // public String getMovies(Model model) {
    // List<Movie> movieList = this
    // }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getMovies() {
        // System.out.print("hit");
        // return new ResponseEntity<>();
        // System.out.println(userDTO);

        List<Movie> movies;

        movies = movieService.findAll();

        // ! acc - created
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

}