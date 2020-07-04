package com.example.cinemaApp.models;

import javax.persistence.*;
import java.util.*;

@Entity
@DiscriminatorValue("2")
public class Manager extends User {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cinema> cinemas = new ArrayList<Cinema>();

    public void addCinema(Cinema cinema) {
        this.cinemas.add(cinema);
        // ? sta mi jos treba ovde
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }
}