package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Ecole;

public interface EcoleService {
    Ecole AjouterEcole(Ecole u);
    void DeleteEcole(Ecole u);
    void DeleteEcole(Long id);
    List<Ecole> getAllEcole();
    
}
