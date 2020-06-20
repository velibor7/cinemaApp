package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Viewer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewerRepository extends JpaRepository<Viewer, Integer> {

    // List<Viewer> findAllByPositionOrderByFirstName(String position);

    // List<Viewer> findByFirstNameOrLastName(String firstName, String lastName);

    // List<Viewer> findByFirstNameIgnoreCase(String firstName);
}