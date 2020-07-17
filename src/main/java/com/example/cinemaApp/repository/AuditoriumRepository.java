package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Auditorium;
import com.example.cinemaApp.models.Cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {

    List<Auditorium> findByCinema(Cinema cinema);

    // List<Auditorium> findAllByPositionOrderByFirstName(String position);

    // List<Auditorium> findByFirstNameOrLastName(String firstName, String
    // lastName);

    // List<Auditorium> findByFirstNameIgnoreCase(String firstName);
}