package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT a FROM Movie a WHERE " + "(LOWER(:name) IS NULL OR LOWER(a.name) like LOWER(:name)) AND "
            + "(LOWER(:description) IS NULL OR LOWER(a.description) like LOWER(:description)) AND "
            + "(LOWER(:genre) IS NULL OR LOWER(a.genre) like LOWER(:genre)) AND "
            + "(LOWER(:grade) IS NULL OR LOWER(a.grade) like LOWER(:grade)) AND "
            + "(LOWER(:duration) IS NULL OR LOWER(a.duration) like LOWER(:duration)) ")
    List<Movie> search(@Param("name") String name, @Param("description") String description,
            @Param("genre") String genre, @Param("grade") String grade, @Param("duration") String duration);

    // List<Movie> findAllByPositionOrderByFirstName(String position);

    // List<Movie> findByFirstNameOrLastName(String firstName, String lastName);

    // List<Movie> findByFirstNameIgnoreCase(String firstName);
}