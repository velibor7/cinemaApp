package com.example.cinemaApp.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.cinemaApp.dto.AuditoriumDTO;
import com.example.cinemaApp.dto.CinemaDTO;
import com.example.cinemaApp.models.Auditorium;
import com.example.cinemaApp.models.Cinema;
import com.example.cinemaApp.service.AuditoriumService;
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

    @Autowired
    private AuditoriumService auditoriumService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CinemaDTO>> getCinemas() {
        // ! podsetnik: koriscen je JsonIgnore u modelu, zato sto dolazi do beskonacne
        // rekurzije
        List<Cinema> cinemas = cinemaService.findAll();

        List<CinemaDTO> cinemasDTOS = new ArrayList<>();

        for (Cinema cinema : cinemas) {
            CinemaDTO cinemaDTO = new CinemaDTO(cinema.getId(), cinema.getName(), cinema.getAddress(),
                    cinema.getPhoneNumber(), cinema.getEmail());
            cinemasDTOS.add(cinemaDTO);
            // nema managera zbog beskonacne rekurzije, nisu ni potrebni
        }

        return new ResponseEntity<List<CinemaDTO>>(cinemasDTOS, HttpStatus.OK);
    }

    // treba da prepravim u create cisto da svuda bude isto
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<CinemaDTO> createCinema(@RequestBody CinemaDTO cinemaDTO) {

        Cinema cinema = new Cinema(cinemaDTO.getName(), cinemaDTO.getAddress(), cinemaDTO.getPhoneNumber(),
                cinemaDTO.getEmail(), cinemaDTO.getManager());

        Cinema newCinema = cinemaService.save(cinema);

        CinemaDTO newCinemaDTO = new CinemaDTO(newCinema.getId(), newCinema.getName(), newCinema.getAddress(),
                newCinema.getPhoneNumber(), newCinema.getEmail(), newCinema.getManager());

        return new ResponseEntity<>(newCinemaDTO, HttpStatus.CREATED);
    }

    // * brisanje
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cinema> deleteCinema(@PathVariable Integer id) {
        Cinema cinema = cinemaService.findOne(id);

        if (cinema == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cinema.getAuditoriums().clear();
        // i managere

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

    // * lista auditoriuma od bioskopa sa id-em
    @RequestMapping(value = "/{id}/auditoriumlist", method = RequestMethod.GET)
    public ResponseEntity<List<AuditoriumDTO>> getCinemasAuditoriums(@PathVariable Integer id) {

        Cinema cinema = cinemaService.findOne(id);

        List<Auditorium> auditoriums = this.auditoriumService.findByCinema(cinema);
        List<AuditoriumDTO> auditoriumsDTOS = new ArrayList<>();

        for (Auditorium auditorium : auditoriums) {
            AuditoriumDTO auditoriumDTO = new AuditoriumDTO(auditorium.getId(), auditorium.getCapacity(),
                    auditorium.getLabel());
            auditoriumsDTOS.add(auditoriumDTO);
        }

        return new ResponseEntity<List<AuditoriumDTO>>(auditoriumsDTOS, HttpStatus.OK);
    }

}