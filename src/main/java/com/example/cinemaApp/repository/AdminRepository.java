package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    List<Admin> findAllByPositionOrderByFirstName(String position);

    List<Admin> findByFirstNameOrLastName(String firstName, String lastName);

    List<Admin> findByFirstNameIgnoreCase(String firstName);
}