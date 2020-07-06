package com.example.cinemaApp.controller;

import java.util.List;

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
    @Autowired
    private UserService userService;

    // ! ovo je za registrovanje VIEWERA
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<UserDTO> add(@RequestBody UserDTO userDTO) {

        User user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getName(), userDTO.getSurname(),
                userDTO.getPhoneNumber(), userDTO.getEmail(), "01.01.2020.", userDTO.getPosition(),
                userDTO.getActive());

        User newUser = userService.save(user);

        UserDTO newUserDTO = new UserDTO(newUser.getId(), newUser.getUsername(), newUser.getPassword(),
                newUser.getFirstname(), newUser.getSurname(), newUser.getPhoneNumber(), newUser.getEmail(),
                "01.01.2020.", newUser.getPosition(), newUser.getActive());

        return new ResponseEntity<>(newUserDTO, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO) {
        // System.out.print("hit");
        // return new ResponseEntity<>();
        // System.out.println(userDTO);

        // ! acc - created
        return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    // public ResponseEntity<User> getUser() {

    // }

    // ? tehnicki ova metoda mi ni ne treba
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users;
        users = userService.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
