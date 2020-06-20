package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    // List<Admin> findAllByPositionOrderByName(String position);

    // List<Admin> findByNameOrLastName(String firstName, String lastName);

    // List<Admin> findByNameIgnoreCase(String firstName);
}