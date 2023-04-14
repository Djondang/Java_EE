package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String niveau;

    // Constructeur par défaut
    public Classe() {
    }

    // Constructeur avec le niveau en paramètre
    public Classe(String niveau) {
        this.niveau = niveau;
    }

    // Getters et Setters pour l'ID et le niveau
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}