package com.example.cinemaApp.controller;

import com.example.cinemaApp.dto.CinemaDTO;
import com.example.cinemaApp.service.CinemaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/cinema")
@CrossOrigin(origins = "http://localhost:4200")
public class CinemaController {
    // @Autowired
    // private CinemaService cinemaService;

    // @GetMapping("/")
    // public String welcome() {
    // return "home.html";
    // }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity add(@RequestBody CinemaDTO cinemaDTO) {
        return new ResponseEntity<>(cinemaDTO, HttpStatus.CREATED);
        // ! acc - created return new ResponseEntity<>(, HttpStatus.ACCEPTED);
    }

}