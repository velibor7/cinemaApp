package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.Manager;
import com.example.cinemaApp.repository.ManagerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface ManagerService {

    Manager findOne(Integer id);

    List<Manager> findAll();

    Manager save(Manager manager);

    Manager delete(Integer id);
}