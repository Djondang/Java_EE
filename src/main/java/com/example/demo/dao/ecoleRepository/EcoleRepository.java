package com.example.demo.dao.ecoleRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Ecole;

@Repository
public interface EcoleRepository extends CrudRepository<Ecole, Long> {
    // Définition de méthodes spécifiques pour le repository
}