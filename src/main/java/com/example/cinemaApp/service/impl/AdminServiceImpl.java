package com.example.cinemaApp.service.impl;

import com.example.cinemaApp.models.Admin;
import com.example.cinemaApp.repository.AdminRepository;
import com.example.cinemaApp.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findOneById(Integer id) {
        Admin admin = adminRepository.getOne(id);

        if (admin == null) {
            return null;
        }

        return admin;
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }
}