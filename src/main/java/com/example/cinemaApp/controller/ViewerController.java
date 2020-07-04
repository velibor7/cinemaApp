package com.example.cinemaApp.controller;

import java.util.List;

import com.example.cinemaApp.models.User;
import com.example.cinemaApp.models.Viewer;
import com.example.cinemaApp.service.ViewerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/api/viewer")
@CrossOrigin(origins = "http://localhost:4200")
public class ViewerController {
    @Autowired
    private ViewerService viewerService;

    // @GetMapping("/")
    // public String welcome() {
    // return "home.html";
    // }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Viewer>> getViewers() {
        List<Viewer> viewers;
        viewers = viewerService.findAll();

        return new ResponseEntity<>(viewers, HttpStatus.OK);
    }

}