package com.example.cinemaApp.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

    // ? Koji je odnos manager bioskop?

    // private Manager manager;

    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Auditorium> auditoriums = new HashSet<>();

    // RASPORED ODRZAVANJA FILMOVA ZAJEDNO SA CENAMA ZA SVAKU PROJEKCIJU

}