package com.example.cinemaApp.dto;

import com.example.cinemaApp.models.Cinema;

public class AuditoriumDTO {

    private Integer id;
    private Integer capacity;
    private String label;
    private Cinema cinema;

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

    public AuditoriumDTO(Integer id, Integer capacity, String label) {
        this.id = id;
        this.capacity = capacity;
        this.label = label;
    }

    public AuditoriumDTO(Integer id, Integer capacity, String label, Cinema cinema) {
        this.id = id;
        this.capacity = capacity;
        this.label = label;
        this.cinema = cinema;
    }

    // !wrong sadrzi film i broj rezervisanih karata za datu projekciju
    // @ManyToMany
    // @JoinTable(name = "movies", joinColumns = @JoinColumn(name = "auditorium_id",
    // referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name =
    // "movie_id", referencedColumnName = "id"))
    // private Set<Movie> movies = new HashSet<>();

    // * list of projections in this auditorium
    // private Set<Projection> projectionsList = new HashSet<>();

}