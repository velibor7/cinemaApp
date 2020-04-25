package com.example.cinemaApp.models;

import java.util.*;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer capacity;

    @Column
    private String label;

    // sadrzi film i broj rezervisanih karata za datu projekciju
    @ManyToMany
    @JoinTable(name = "movies", joinColumns = @JoinColumn(name = "auditorium_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private Set<Movie> movies = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Cinema cinema;

    // TERMINSKA LISTA PROJEKCIJA
}