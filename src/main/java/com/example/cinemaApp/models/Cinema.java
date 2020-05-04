package com.example.cinemaApp.models;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Cinema implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String adress;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    // ! eager - sve odma, lazy tek kad pozovemo neku metdou
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Manager manager;

    // * lista sala
    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Auditorium> auditoriums = new HashSet<>();

    // ! RASPORED ODRZAVANJA FILMOVA ZAJEDNO SA CENAMA ZA SVAKU PROJEKCIJU
    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Projection> projectionsSchedule = new HashSet<>();

}