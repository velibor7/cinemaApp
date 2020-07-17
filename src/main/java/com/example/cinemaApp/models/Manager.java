package com.example.cinemaApp.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.*;

@Entity
@DiscriminatorValue("2")
public class Manager extends User {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Cinema> cinemas = new ArrayList<Cinema>();

    // ! methods
    public void addCinema(Cinema cinema) {
        this.cinemas.add(cinema);
        // ? sta mi jos treba ovde
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public Manager() {
    }

    public Manager(String username, String password, String firstname, String surname, String phoneNumber, String email,
            String dateOfBirth, String position, Boolean active) {
        super(username, password, firstname, surname, phoneNumber, email, dateOfBirth, position, active);
    }
}