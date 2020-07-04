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

    // ! treba da se promeni u date
    @Column
    private String day;

    @Column
    private String time;

    @Column
    private Integer price;

    @OneToOne()
    Movie movie;

    // connection with cinema
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Cinema cinema;

    // @ManyToOne()
    // private Auditorium auditorium;

    // list of auditoriums where this movie is projected
    // @ManyToMany(mappedBy = "projectionsList")
    // private Set<Auditorium> auditoriums = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    // public Set<Auditorium> getAuditoriums() {
    // return auditoriums;
    // }

    // public void setAuditoriums(Set<Auditorium> auditoriums) {
    // this.auditoriums = auditoriums;
    // }

}