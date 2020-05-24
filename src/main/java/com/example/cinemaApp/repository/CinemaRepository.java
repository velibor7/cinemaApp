package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Cinema;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // List<Cinema> findAllByPositionOrderByFirstName(String position);

    // List<Cinema> findByFirstNameOrLastName(String firstName, String lastName);

    // List<Cinema> findByFirstNameIgnoreCase(String firstName);
}