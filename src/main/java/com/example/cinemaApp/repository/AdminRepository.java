package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    // List<Admin> findAllByPositionOrderByName(String position);

    List<Admin> findByFirstnameOrSurname(String firstName, String lastName);

    // List<Admin> findByNameIgnoreCase(String firstName);
}