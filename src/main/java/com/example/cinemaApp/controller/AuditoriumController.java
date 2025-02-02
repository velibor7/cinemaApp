package com.example.cinemaApp.controller;

import java.util.List;

import com.example.cinemaApp.service.AuditoriumService;
import com.example.cinemaApp.service.CinemaService;
import com.example.cinemaApp.dto.AuditoriumDTO;
import com.example.cinemaApp.models.Auditorium;
import com.example.cinemaApp.models.Cinema;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/auditorium")
@CrossOrigin(origins = "http://localhost:4200")
public class AuditoriumController {
    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Auditorium>> getAuditoriums() {
        List<Auditorium> auditoriums;
        auditoriums = auditoriumService.findAll();

        // List<AuditoriumDTO> auditoriumDTOS = new ArrayList<>();

        // for (Auditorium auditorium : auditoriums) {
        // AuditoriumDTO auditoriumDTO = new AuditoriumDTO(auditorium.getId(),
        // auditorium)

        // }

        return new ResponseEntity<>(auditoriums, HttpStatus.OK);
    }

    // * kreiranje
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
    public ResponseEntity<AuditoriumDTO> createAuditorium(@RequestBody AuditoriumDTO auditoriumDTO) {

        Auditorium auditorium = new Auditorium(auditoriumDTO.getCapacity(), auditoriumDTO.getLabel());

        Auditorium newAuditorium = auditoriumService.save(auditorium);

        AuditoriumDTO newAuditoriumDTO = new AuditoriumDTO(newAuditorium.getId(), newAuditorium.getCapacity(),
                newAuditorium.getLabel());

        return new ResponseEntity<>(newAuditoriumDTO, HttpStatus.ACCEPTED);
    }

    // * brisanje
    @RequestMapping(value = "/{cinemaId}/{audId}", method = RequestMethod.DELETE)
    public ResponseEntity<Auditorium> deleteAuditorium(@PathVariable Integer cinemaId, @PathVariable Integer audId) {
        Cinema cinema = cinemaService.findOne(cinemaId);

        Auditorium auditorium = auditoriumService.findOne(audId);

        if (auditorium == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cinema.getAuditoriums().remove(auditorium);
        auditoriumService.delete(audId);

        return new ResponseEntity<Auditorium>(auditorium, HttpStatus.OK);
    }

    // * izmena
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Auditorium> editAuditorium(@PathVariable Integer id) {
        Auditorium auditorium = auditoriumService.findOne(id);

        // ! menjanje auditoriuma

        return new ResponseEntity<Auditorium>(auditorium, HttpStatus.OK);
    }

    // * lista bioskopa od ovog auditoriuma
    // @RequestMapping(value = "/{id}/cinemalist", method = RequestMethod.GET)
    // public ResponseEntity<List<Cinema>> getAuditoriumsCinemas(@PathVariable
    // Integer id) {
    // Auditorium auditorium = auditoriumService.findOne(id);

    // List<Cinema> cinemas = this.cinemaService.findByAuditorium(auditorium);

    // return new ResponseEntity<List<Cinema>>(cinemas, HttpStatus.OK);
    // }

}