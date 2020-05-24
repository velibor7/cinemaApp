package com.example.cinemaApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // @GetMapping("/movies")
    // public String getMovies(Model model) {
    // List<Movie> movieList = this
    // }

}