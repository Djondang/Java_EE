package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Ecole;
import com.example.demo.service.EcoleService;

@RestController
public class EcoleControllers {

	@Autowired
	EcoleService ecoleService;
	
	@GetMapping("/Ecoles")
	@ResponseBody
	public List<Ecole> getAllEcoles(){
		List<Ecole> list= ecoleService.getAllEcole();
		return list;
		
	}
	@PostMapping("/AjouterEcole")
	@ResponseBody
	public Ecole AjouterEcole(@RequestBody Ecole u) {
		return ecoleService.AjouterEcole(u);
	}
	
	@DeleteMapping("deleteUser/{id}")
	@ResponseBody
	public void deleteEcole(@PathVariable("id") Long idEcole) {
		ecoleService.DeleteEcole(idEcole);
	}
	
	
	
	
	
	
	
	
	
}
