package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.ecoleRepository.EcoleRepository;

import com.example.demo.entities.Ecole;

@SpringBootApplication

public class DemoApplication implements CommandLineRunner{

  @Autowired

  private EcoleRepository ecoleRepository;

  public static void main(String[] args) {

    SpringApplication.run(DemoApplication.class, args);
  }

  @Override

  public void run(String... args) throws Exception {

    // TODO Auto-generated method stub

    for (int i = 5; i < 10; i++) {

      Ecole e = new Ecole(); 

      e.setNom("Ecole" + i);

      e.setAdresse("Ecole" + i);

      ecoleRepository.save(e);

    }

    for (long j = 0; j < 100; j++) {

      Optional<Ecole> ecole = ecoleRepository.findById(j+1);

      System.out.println(ecole);

    }

  }

}