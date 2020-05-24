package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Auditorium;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {

    // List<Auditorium> findAllByPositionOrderByFirstName(String position);

    // List<Auditorium> findByFirstNameOrLastName(String firstName, String
    // lastName);

    // List<Auditorium> findByFirstNameIgnoreCase(String firstName);
}