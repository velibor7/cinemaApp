package com.example.cinemaApp.controller;

import java.util.List;

import com.example.cinemaApp.dto.CinemaDTO;
import com.example.cinemaApp.models.Cinema;
import com.example.cinemaApp.service.CinemaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/cinema")
@CrossOrigin(origins = "http://localhost:4200")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    // @GetMapping("/")
    // public String welcome() {
    // return "home.html";
    // }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cinema>> getCinemas() {
        // ! podsetnik: koriscen je JsonIgnore u modelu, zato sto dolazi do beskonacne
        // rekurzije
        List<Cinema> cinemas;
        cinemas = cinemaService.findAll();

        // List<CinemaDTO> cinemaDTOS = new ArrayList<>();

        // for (Cinema cinema : cinemas) {
        // CinemaDTO cinemaDTO = new CinemaDTO(cinema.getId(), cinema)

        // }

        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity createCinema(@RequestBody CinemaDTO cinemaDTO) {
        return new ResponseEntity<>(cinemaDTO, HttpStatus.CREATED);
        // ! acc - created return new ResponseEntity<>(, HttpStatus.ACCEPTED);
    }

    // * brisanje
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cinema> deleteCinema(@PathVariable Integer id) {
        Cinema cinema = cinemaService.findOne(id);

        if (cinema == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cinema.getAuditoriums().clear();

        cinemaService.delete(id);

        return new ResponseEntity<Cinema>(cinema, HttpStatus.OK);
    }

    // * izmena
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cinema> editCinema(@PathVariable Integer id) {
        Cinema cinema = cinemaService.findOne(id);

        // ! menjanje cinemaa

        return new ResponseEntity<Cinema>(cinema, HttpStatus.OK);
    }

}