package com.example.cinemaApp.models;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Auditorium implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer capacity;

    // oznaka sale
    @Column
    private String label;

    // ? da li je potrebno da bude dvosmerna veza sale i bioskopa?
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Cinema cinema;

    // !wrong sadrzi film i broj rezervisanih karata za datu projekciju
    // @ManyToMany
    // @JoinTable(name = "movies", joinColumns = @JoinColumn(name = "auditorium_id",
    // referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name =
    // "movie_id", referencedColumnName = "id"))
    // private Set<Movie> movies = new HashSet<>();

    // * list of projections in this auditorium
    @ManyToMany
    @JoinTable(name = "projections", joinColumns = @JoinColumn(name = "auditorium_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "projection_id", referencedColumnName = "id"))
    private Set<Projection> projectionsList = new HashSet<>();
}