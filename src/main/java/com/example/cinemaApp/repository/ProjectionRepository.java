package com.example.cinemaApp.repository;

import com.example.cinemaApp.models.Projection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Integer> {
    // sortiranje filmova rastuce po ceni
    @Query("SELECT a FROM Projection a ORDER BY a.price ASC")
    List<Projection> ascending();

    // sortiranje filmova opadajuce po ceni
    @Query("SELECT a FROM Projection a ORDER BY a.price DESC")
    List<Projection> descending();

    @Query("SELECT a FROM Projection a WHERE " + "(LOWER(:name) IS NULL OR LOWER(a.movie.name) like LOWER(:name)) AND "
            + "(LOWER(:description) IS NULL OR LOWER(a.movie.description) like LOWER(:description)) AND "
            + "(LOWER(:genre) IS NULL OR LOWER(a.movie.genre) like LOWER(:genre)) AND "
            + "(LOWER(:grade) IS NULL OR LOWER(a.movie.grade) like LOWER(:grade)) AND "
            + "(LOWER(:price) IS NULL OR LOWER(a.price) like LOWER(:price)) AND "
            + "(LOWER(:time) IS NULL OR LOWER(a.time) like LOWER(:time)) ")
    List<Projection> search(@Param("name") String name, @Param("description") String description,
            @Param("genre") String genre, @Param("price") String price, @Param("time") String time);

}