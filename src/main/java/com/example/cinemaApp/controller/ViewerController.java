package com.example.cinemaApp.controller;

import java.util.List;

import com.example.cinemaApp.dto.ViewerDTO;
import com.example.cinemaApp.models.Viewer;
import com.example.cinemaApp.models.Viewer;
import com.example.cinemaApp.service.ViewerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    // public ResponseEntity<ViewerDTO> getViewer(@PathVariable(name = "id") Integer
    // id) {
    // Viewer viewer = this.viewerService.findOne(id);

    // ViewerDTO viewerDTO = new ViewerDTO();
    // viewerDTO.setId(viewer.getId());
    // viewerDTO.setViewername(viewer.getViewername());
    // viewerDTO.setName(viewer.getFirstname());
    // viewerDTO.setSurname(viewer.getSurname());
    // viewerDTO.setEmail(viewer.getEmail());
    // viewerDTO.setPhoneNumber(viewer.getPhoneNumber());
    // viewerDTO.setPosition(viewer.getPosition());

    // return new ResponseEntity<>(viewerDTO, HttpStatus.OK);

    // }

}