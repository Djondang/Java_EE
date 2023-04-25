package com.school.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.spring.jpa.model.School;
import com.school.spring.jpa.repository.SchoolServiceInt;

@RestController
public class SchoolController{
	
	@Autowired
	SchoolServiceInt schoolService;
	//pour afficher la liste des écoles
	@GetMapping("/schools")
	@ResponseBody
	public List<School> getAllSchools(Integer page, Integer size){
		List<School> list= schoolService.getAllSchool(page, size);
		return list;
	}
	
	@GetMapping("/school/{school_Name}")
	public ResponseEntity<List<School>> findByName(@RequestParam String school_Name) {
		try {
			List<School> schools = schoolService.findBySchool_Name(school_Name);

			if (schools.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(schools, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//pour ajouter une école
	@PostMapping("/add")
	@ResponseBody
	public School AddSchool(@RequestBody School add) {
		return schoolService.AddSchool(add);
	}
	//pour la supression une école
	@DeleteMapping("delete/{id}")
	@ResponseBody
	public void deleteSchool(@PathVariable("id") Long idSchool) {
		schoolService.DeleteSchool(idSchool);
	}
	
	//pour mettre à jour une école
	@PutMapping("/update/{id}")
	public School UpdateSchool(@PathVariable Long id, @RequestBody School school) {
		school.setId(id);
		return schoolService.UpdateSchool(school);
	}
	
	
}
