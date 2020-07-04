package com.example.cinemaApp.controller;

import java.util.List;

import com.example.cinemaApp.models.Projection;
import com.example.cinemaApp.service.ProjectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/api/projection")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectionController {

    @Autowired
    private ProjectionService projectionService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Projection>> getProjections() {
        List<Projection> projections;
        projections = projectionService.findAll();
        // fali dto
        return new ResponseEntity<>(projections, HttpStatus.OK);
    }

}