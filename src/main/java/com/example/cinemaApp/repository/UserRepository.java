package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // List<User> findAllByPosition
    // List<User> findAllByPositionOrderByFirstName(String position);

    List<User> findByFirstnameOrSurname(String firstName, String lastName);

    // List<User> findByFirstnameIgnoreCase(String firstName);

    List<User> findByPosition(String position);

    User findByUsername(String username);

    User findByEmail(String email);
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