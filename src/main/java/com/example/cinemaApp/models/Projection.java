package com.example.cinemaApp.models;

import java.io.Serializable;
import java.sql.Time;
import java.util.*;
import javax.persistence.*;

@Entity
public class Projection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date day;

    @Column
    private Time time;

    @Column
    private Integer price;

    @OneToOne()
    Movie movie;

    // connection with cinema
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Cinema cinema;

    // list of auditoriums where this movie is projected
    @ManyToMany(mappedBy = "projectionsList")
    private Set<Auditorium> auditoriums = new HashSet<>();
}