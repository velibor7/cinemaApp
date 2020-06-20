package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // List<User> findAllByPosition
    // List<User> findAllByPositionOrderByFirstName(String position);

    /*
     * Traži sve zaposlene po imenu ili prezimenu.
     */
    List<User> findByFirstnameOrSurname(String firstName, String lastName);

    /*
     * Traži sve zaposlene po imenu, ignorišu se mala i velika slova.
     */

    List<User> findByFirstnameIgnoreCase(String firstName);

    /*
     * Traži sve zaposlene po nazivu departmana.
     */
    // List<User> findByDepartmentName(String departmentName);

    User findByUsername(String username);
}
/*
 * Repository je interfejs koji služi za komunikaciju sa bazom iz koje izvlači
 * podatke.
 * 
 * Metode za pretragu počinju sa findBy, dok u nastavku sadrže nazive atributa
 * iz modela koji mogu da se konkateniraju sa And, Or, Between, LessThan,
 * GreaterThan, Like, itd. uz dodavanje pomoćnih uslova poput Containing,
 * AllIgnoringCase, itd.
 */