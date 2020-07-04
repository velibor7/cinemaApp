package com.example.cinemaApp.models;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import javax.persistence.*;

@Entity
@DiscriminatorValue("1")
public class Viewer extends User {

    private static final long serialVersionUID = 1L;

    // ! da li je name povezan sa mappedBy?!??!?!?!?!?!?
    // ! treba promeniti ove names

    // lista odgledanih filmova
    @ManyToMany
    @JoinTable(name = "movies_watched", joinColumns = @JoinColumn(name = "viewer_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private Set<Movie> watchedMovies = new HashSet<Movie>();

    // reserved movies but not watched yet
    @ManyToMany
    @JoinTable(name = "movies_reserved", joinColumns = @JoinColumn(name = "viewer_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private List<Movie> reservedMovies = new ArrayList<Movie>();

    // ! LISTA OCENA

    public Viewer() {
        super();
    }
}