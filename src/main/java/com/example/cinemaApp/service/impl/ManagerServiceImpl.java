package com.example.cinemaApp.service.impl;

import java.util.List;

import com.example.cinemaApp.models.Manager;
import com.example.cinemaApp.repository.ManagerRepository;
import com.example.cinemaApp.service.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepo;

    public Manager findOne(Integer id) {
        Manager manager = this.managerRepo.getOne(id);
        return manager;
    }

    public List<Manager> findAll() {
        List<Manager> managers = this.managerRepo.findAll();
        return managers;
    }

    public Manager save(Manager manager) {
        return this.managerRepo.save(manager);
    }

    public Manager delete(Integer id) {
        Manager manager = managerRepo.getOne(id);
        if (manager != null) {
            managerRepo.delete(manager);
        }
        return manager;
    }
}