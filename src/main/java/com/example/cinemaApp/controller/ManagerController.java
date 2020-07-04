package com.example.cinemaApp.controller;

import java.util.List;

import com.example.cinemaApp.models.Manager;
import com.example.cinemaApp.service.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/api/manager")
@CrossOrigin(origins = "http://localhost:4200")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    // @GetMapping("/")
    // public String welcome() {
    // return "home.html";
    // }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Manager>> getManagers() {
        List<Manager> managers;
        managers = managerService.findAll();

        return new ResponseEntity<>(managers, HttpStatus.OK);
    }
}