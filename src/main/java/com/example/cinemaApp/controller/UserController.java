package com.example.cinemaApp.controller;

import com.example.cinemaApp.dto.UserDTO;
import com.example.cinemaApp.models.User;
import com.example.cinemaApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    // @Autowired
    // private UserService userService;

    // @GetMapping("/")
    // public String welcome() {
    // return "home.html";
    // }

    // ! AUTH

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<UserDTO> add(@RequestBody UserDTO userDTO) {
        // System.out.print("hit");
        // return new ResponseEntity<>();
        // System.out.println(userDTO);

        // ! acc - created
        return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
    }
}
