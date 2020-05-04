package com.example.cinemaApp.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Manager extends User {
    /**
     *
     */
    private static final long serialVersionUID = 165796034736062476L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Cinema> cinemas = new HashSet<>();
}