package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Projection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Integer> {

    // List<Projection> findAllByPositionOrderByFirstName(String position);

    // List<Projection> findByFirstNameOrLastName(String firstName, String
    // lastName);

    // List<Projection> findByFirstNameIgnoreCase(String firstName);
}