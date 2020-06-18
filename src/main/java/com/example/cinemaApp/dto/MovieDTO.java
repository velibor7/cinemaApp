package com.example.cinemaApp.dto;

public class MovieDTO {

    private Integer id;
    private String name;
    private String description;
    private String genre;
    private Integer duration;
    private Long grade;

    // private Set<Viewer> peopleWatched = new HashSet<>();
    // private Set<Viewer> peopleReserved = new HashSet<>();

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
}