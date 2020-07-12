package com.example.cinemaApp.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javassist.SerialVersionUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(insertable = false, updatable = false)
    private Integer user_type;

    @Column(unique = true)
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
    private String position;

    @Column
    private Boolean active;

    public User() {
    }

    public User(String username, String password, String firstname, String surname, String phoneNumber, String email,
            String dateOfBirth, String position, Boolean active) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.active = active;
    }

    public User(String username) {
        this.username = username;
        this.password = "";
        this.firstname = "";
        this.surname = "";
        this.phoneNumber = "";
        this.email = "";
        this.dateOfBirth = "";
        this.position = "";
        this.active = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
