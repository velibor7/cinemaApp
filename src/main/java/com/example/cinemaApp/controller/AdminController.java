package com.example.cinemaApp.controller;

import com.example.cinemaApp.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/admin")
public class AdminController {
    // @Autowired
    // private AdminService adminService;

    // @GetMapping("/")
    // public String welcome() {
    // return "home.html";
    // }

}