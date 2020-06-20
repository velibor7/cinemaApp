package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    // List<Movie> findAllByPositionOrderByFirstName(String position);

    // List<Movie> findByFirstNameOrLastName(String firstName, String lastName);

    // List<Movie> findByFirstNameIgnoreCase(String firstName);
}