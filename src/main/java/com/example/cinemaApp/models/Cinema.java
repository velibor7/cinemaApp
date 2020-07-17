package com.example.cinemaApp.models;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;

@Entity
public class Cinema implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 12345;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    // ! eager - sve odma, lazy tek kad pozovemo neku metdou
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    // @JsonView(View.DetailView.class)
    // @JsonIgnore
    @JsonManagedReference
    private Manager manager;

    // * lista sala
    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonManagedReference
    private final Set<Auditorium> auditoriums = new HashSet<>();

    // ! RASPORED ODRZAVANJA FILMOVA ZAJEDNO SA CENAMA ZA SVAKU PROJEKCIJU
    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private final Set<Projection> projectionsSchedule = new HashSet<>();

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

    public Set<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public Set<Projection> getProjectionsSchedule() {
        return projectionsSchedule;
    }

}