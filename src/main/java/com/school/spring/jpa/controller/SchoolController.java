package com.school.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.spring.jpa.model.School;
import com.school.spring.jpa.repository.SchoolServiceInt;

@RestController
public class SchoolController{
	
	@Autowired
	SchoolServiceInt schoolService;
	
	@GetMapping("/schools")
	@ResponseBody
	public List<School> getAllSchools(){
		List<School> list= schoolService.getAllSchool();
		return list;
		
	}
	@PostMapping("/add")
	@ResponseBody
	public School AddSchool(@RequestBody School add) {
		return schoolService.AddSchool(add);
	}
	
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
