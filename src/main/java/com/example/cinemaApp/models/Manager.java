package com.example.cinemaApp.models;

import javax.persistence.*;
import java.util.*;

@Entity
@DiscriminatorValue("2")
public class Manager extends User {
    /**
     *
     */
    // private static final long serialVersionUID = 165796034736062476L;

    private static final long serialVersionUID = 1L;

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Integer id;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Cinema> cinemas = new HashSet<>();
}