package com.example.cinemaApp.dto;

public class ManagerDTO {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String dateOfBirth;
    private String position;
    private Boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public ManagerDTO(Integer id, String username, String password, String name, String surname, String phoneNumber,
            String email, String dateOfBirth, String position, Boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.active = active;
    }

    public ManagerDTO() {
    }

}