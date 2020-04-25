package com.example.cinemaApp.models;

import java.util.Set;
import java.util.*;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Viewer extends User {

    /**
     *
     */
    private static final long serialVersionUID = -3370823760102065702L;

    // ! da li je name povezan sa mappedBy?!??!?!?!?!?!?
    // ! treba promeniti ove names
    // watched movies
    @ManyToMany
    @JoinTable(name = "movies_watched", joinColumns = @JoinColumn(name = "viewer_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private Set<Movie> watchedMovies = new HashSet<>();

    // reserved movies but not watched yet
    @ManyToMany
    @JoinTable(name = "movies_reserved", joinColumns = @JoinColumn(name = "viewer_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private Set<Movie> reservedMovies = new HashSet<>();

    // ! LISTA OCENA

    public Viewer() {
        super();
    }

}