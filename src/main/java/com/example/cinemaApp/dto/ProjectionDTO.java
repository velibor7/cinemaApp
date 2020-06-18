package com.example.cinemaApp.dto;

public class ProjectionDTO {

    private Integer id;
    private String day;
    private String time;
    private Integer price;
    // Movie movie;

    // connection with cinema
    // private Cinema cinema;

    // list of auditoriums where this movie is projected
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

    /*
     * 
     * public Movie getMovie() { return movie; }
     * 
     * public void setMovie(Movie movie) { this.movie = movie; }
     * 
     * public Cinema getCinema() { return cinema; }
     * 
     * public void setCinema(Cinema cinema) { this.cinema = cinema; }
     * 
     * public Set<Auditorium> getAuditoriums() { return auditoriums; }
     * 
     * public void setAuditoriums(Set<Auditorium> auditoriums) { this.auditoriums =
     * auditoriums; }
     */
}