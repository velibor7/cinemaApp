package com.example.cinemaApp.dto;

public class AuditoriumDTO {

    private Integer id;
    private Integer capacity;
    private String label;

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

    // private Cinema cinema;

    // !wrong sadrzi film i broj rezervisanih karata za datu projekciju
    // @ManyToMany
    // @JoinTable(name = "movies", joinColumns = @JoinColumn(name = "auditorium_id",
    // referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name =
    // "movie_id", referencedColumnName = "id"))
    // private Set<Movie> movies = new HashSet<>();

    // * list of projections in this auditorium
    // private Set<Projection> projectionsList = new HashSet<>();

}