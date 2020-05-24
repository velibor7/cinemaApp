package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // List<Movie> findAllByPositionOrderByFirstName(String position);

    // List<Movie> findByFirstNameOrLastName(String firstName, String lastName);

    // List<Movie> findByFirstNameIgnoreCase(String firstName);
}