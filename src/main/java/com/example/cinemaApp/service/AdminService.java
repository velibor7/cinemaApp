package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.Admin;
import com.example.cinemaApp.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin findOne(Long id) {
        Admin admin = this.adminRepository.getOne(id);
        return admin;
    }

    public List<Admin> findAll() {
        List<Admin> admins = this.adminRepository.findAll();
        return admins;
    }

    public Admin save(Admin admin) {
        return this.adminRepository.save(admin);
    }
}