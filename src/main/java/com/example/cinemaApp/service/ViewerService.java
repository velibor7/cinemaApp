package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.Viewer;
import com.example.cinemaApp.repository.ViewerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ViewerService {

    Viewer findOne(Integer id);

    List<Viewer> findAll();

    Viewer save(Viewer viewer);
}