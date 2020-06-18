package com.example.cinemaApp.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String firstname;

    @Column
    private String surname;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private String dateOfBirth;

    @Column
    private String role;

    @Column
    private Boolean active;

    public User() {
    }

    public User(String username, String password, String name, String surname, String role, String phoneNumber,
            String email, String dateOfBirth, Boolean active) {
        this.username = username;
        this.password = password;
        this.firstname = name;
        this.surname = surname;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.active = active;
    }

    public User(Long id, String username, String password, String name, String surname, String role, String phoneNumber,
            String email, String dateOfBirth, Boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = name;
        this.surname = surname;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return firstname;
    }

    public void setName(String name) {
        this.firstname = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
