package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Viewer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViewerRepository extends JpaRepository<Viewer, Long> {

    List<Viewer> findAllByPositionOrderByFirstName(String position);

    List<Viewer> findByFirstNameOrLastName(String firstName, String lastName);

    List<Viewer> findByFirstNameIgnoreCase(String firstName);
}