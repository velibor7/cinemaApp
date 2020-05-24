package com.example.cinemaApp.controller;

import com.example.cinemaApp.service.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/manager")
public class ManagerController {
    // @Autowired
    // private ManagerService managerService;

    // @GetMapping("/")
    // public String welcome() {
    // return "home.html";
    // }

}