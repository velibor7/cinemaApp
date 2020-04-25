package com.example.cinemaApp.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

import org.hibernate.validator.cfg.context.Cascadable;

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

    @ManyToMany(mappedBy = "watchedMovies")
    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JoinTable(name = "watchedMovies", joinColumns = @JoinColumn(name =
    // "user_id", referencedColumnName = "id"), inverseJoinColumns =
    // @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    // private Set<Viewer> viewersWhoWatched = new HashSet<>();
    private Set<Viewer> watched;

    // !? GDE SE KORISTI RESERVED
    @ManyToMany(mappedBy = "reservedMovies")
    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JoinTable(name = "watchedMovies", joinColumns = @JoinColumn(name =
    // "user_id", referencedColumnName = "id"), inverseJoinColumns =
    // @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    // private Set<Viewer> viewersWhoReserved = new HashSet<>();
    private Set<Viewer> reserved;

    @ManyToMany(mappedBy = "movies")
    private Set<Auditorium> auditoriumsWhereMovieIs = new HashSet<>();

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