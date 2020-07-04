package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

    // List<Cinema> findAllByPositionOrderByFirstName(String position);

    // List<Cinema> findByFirstNameOrLastName(String firstName, String lastName);

    // List<Cinema> findByFirstNameIgnoreCase(String firstName);

    // List<Cinema> findAll();
}