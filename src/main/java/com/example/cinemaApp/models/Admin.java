package com.example.cinemaApp.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class Admin extends User {
    private static final long serialVersionUID = 1L;
}