package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Manager;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    // List<Manager> findAllByPositionOrderByFirstName(String position);

    // List<Manager> findByFirstNameOrLastName(String firstName, String lastName);

    // List<Manager> findByFirstNameIgnoreCase(String firstName);
}