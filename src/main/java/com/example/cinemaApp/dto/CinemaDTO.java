package com.example.cinemaApp.dto;

import com.example.cinemaApp.models.Manager;

public class CinemaDTO {

    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private Manager manager;

    /*
     * @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY, cascade =
     * CascadeType.ALL) private final Set<Auditorium> auditoriums = new HashSet<>();
     * 
     * // ! RASPORED ODRZAVANJA FILMOVA ZAJEDNO SA CENAMA ZA SVAKU PROJEKCIJU
     * 
     * @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY, cascade =
     * CascadeType.ALL) private final Set<Projection> projectionsSchedule = new
     * HashSet<>();
     * 
     * public Cinema(String name, String address, String phoneNumber, String email,
     * Manager manager) { this.name = name; this.address = address; this.phoneNumber
     * = phoneNumber; this.email = email; this.manager = manager; }
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
    /*
     * 
     * public Set<Auditorium> getAuditoriums() { return auditoriums; }
     * 
     * public Set<Projection> getProjectionsSchedule() { return projectionsSchedule;
     * }
     */
}