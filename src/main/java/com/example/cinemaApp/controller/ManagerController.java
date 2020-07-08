package com.example.cinemaApp.controller;

import java.util.List;

import com.example.cinemaApp.dto.ManagerDTO;
import com.example.cinemaApp.models.Manager;
import com.example.cinemaApp.models.User;
import com.example.cinemaApp.service.ManagerService;
import com.example.cinemaApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/api/manager")
@CrossOrigin(origins = "http://localhost:4200")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getManagers() {
        List<User> managers;

        managers = userService.findByPosition("manager");

        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<ManagerDTO> createManager(@RequestBody ManagerDTO managerDTO) {

        Manager manager = new Manager(managerDTO.getUsername(), managerDTO.getPassword(), managerDTO.getName(),
                managerDTO.getSurname(), managerDTO.getPhoneNumber(), managerDTO.getEmail(), "01.01.2020.",
                managerDTO.getPosition(), managerDTO.getActive());

        Manager newManager = managerService.save(manager);

        ManagerDTO newManagerDTO = new ManagerDTO(newManager.getId(), newManager.getUsername(),
                newManager.getPassword(), newManager.getFirstname(), newManager.getSurname(),
                newManager.getPhoneNumber(), newManager.getEmail(), "01.01.2020.", newManager.getPosition(),
                newManager.getActive());

        return new ResponseEntity<>(newManagerDTO, HttpStatus.ACCEPTED);
    }
}