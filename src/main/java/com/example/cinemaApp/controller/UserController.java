package com.example.cinemaApp.controller;

import java.util.List;
import java.util.Objects;

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
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<User> login(@RequestBody UserDTO userDTO) {
        // System.out.print("hit");
        // return new ResponseEntity<>();
        // System.out.println(userDTO);

        // ! ovde moze da ga ne nadje, kasnije fix
        User foundUser = userService.findByEmail(userDTO.getEmail());
        User returnUser = new User("fail");

        System.out.println(foundUser.getPassword());
        System.out.println(userDTO.getPassword());

        String foundPW = foundUser.getPassword();
        String idkPW = userDTO.getPassword();

        if (Objects.equals(foundPW, idkPW)) {
            // return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
            System.out.println("USAO");
            returnUser = foundUser;
        }

        return new ResponseEntity<>(returnUser, HttpStatus.ACCEPTED);
        // ! acc - created
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "id") Integer id) {
        User user = this.userService.findOne(id);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setName(user.getFirstname());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setPosition(user.getPosition());

        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }

}
