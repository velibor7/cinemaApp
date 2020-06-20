package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    // List<Manager> findAllByPositionOrderByFirstName(String position);

    // List<Manager> findByFirstNameOrLastName(String firstName, String lastName);

    // List<Manager> findByFirstNameIgnoreCase(String firstName);
}