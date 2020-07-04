package com.example.cinemaApp.models;

import java.io.Serializable;
import java.sql.Array;
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
    private List<Projection> projectionsList = new ArrayList<>();

    // * getters setters, etc
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public List<Projection> getProjectionsList() {
        return projectionsList;
    }

    public void setProjectionsList(List<Projection> projectionsList) {
        this.projectionsList = projectionsList;
    }

}