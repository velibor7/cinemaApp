package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // List<User> findAllByPosition
    // List<User> findAllByPositionOrderByFirstName(String position);

    /*
     * Traži sve zaposlene po imenu ili prezimenu.
     */
    // List<User> findByFirstNameOrLastName(String firstName, String lastName);

    /*
     * Traži sve zaposlene po imenu, ignorišu se mala i velika slova.
     */
    // List<User> findByFirstNameIgnoreCase(String firstName);

    /*
     * Traži sve zaposlene po nazivu departmana.
     */
    // List<User> findByDepartmentName(String departmentName);
}