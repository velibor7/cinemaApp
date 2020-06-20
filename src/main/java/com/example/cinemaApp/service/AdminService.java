package com.example.cinemaApp.service;

import java.util.List;

import com.example.cinemaApp.models.Admin;
import com.example.cinemaApp.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface AdminService {

    Admin findOneById(Integer id);

    Admin save(Admin admin);
}