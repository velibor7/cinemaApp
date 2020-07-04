package com.example.cinemaApp.models;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Movie implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 7105706263256547451L;

    // === FIELDS ===
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String genre;

    @Column
    private Integer duration;

    @Column
    private Long grade;

    // ? lista ljudi koji su gledali film
    @ManyToMany(mappedBy = "watchedMovies")
    private List<Viewer> peopleWatched = new ArrayList<>();

    // ? lista ljudi koji su rezervisali film
    @ManyToMany(mappedBy = "reservedMovies")
    private List<Viewer> peopleReserved = new ArrayList<>();

    // ! METHODS

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Movie [description=" + description + ", duration=" + duration + ", genre=" + genre + ", grade=" + grade
                + ", id=" + id + ", name=" + name + "]";
    }

}