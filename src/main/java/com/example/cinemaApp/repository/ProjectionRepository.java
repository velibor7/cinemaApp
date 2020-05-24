package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Projection;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {

    // List<Projection> findAllByPositionOrderByFirstName(String position);

    // List<Projection> findByFirstNameOrLastName(String firstName, String
    // lastName);

    // List<Projection> findByFirstNameIgnoreCase(String firstName);
}