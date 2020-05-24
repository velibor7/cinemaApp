package com.example.cinemaApp.controller;

import com.example.cinemaApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String welcome() {
        return "home.html";
    }

}