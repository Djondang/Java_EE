package com.school.spring.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.spring.jpa.model.School;
import com.school.spring.jpa.repository.SchoolRepository;


@Component
public class SchoolController implements CommandLineRunner{
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@GetMapping("/school")
	public ResponseEntity<List<School>> getAllSchool(@RequestParam(required = false) Long id) {
		try {
			List<School> Schools = new ArrayList<School>();

			if (id == null)
				schoolRepository.findAll().forEach(Schools::add);
			/*else
				schoolRepository.findById(id).forEach(Schools::add);*/

			if (Schools.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(Schools, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/schools/{id}")
	public ResponseEntity<School> getSchoolById(@PathVariable("id") long id) {
		Optional<School> SchoolData = schoolRepository.findById(id);

		if (SchoolData.isPresent()) {
			return new ResponseEntity<>(SchoolData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/schools")
	public ResponseEntity<School> createSchool(@RequestBody School school) {
		try {
			School _school = schoolRepository
					.save(new School(school.getSchool_Name(), school.getClassNumber(), school.getAddress()));
			return new ResponseEntity<>(_school, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/schools/{id}")
	public ResponseEntity<School> updateSchool(@PathVariable("id") long id, @RequestBody School School) {
		Optional<School> SchoolData = schoolRepository.findById(id);

		if (SchoolData.isPresent()) {
			School _school = SchoolData.get();
			_school.setSchool_Name(School.getSchool_Name());
			_school.setClassNumber(School.getClassNumber());
			_school.setAddress(School.getAddress());
			return new ResponseEntity<>(schoolRepository.save(_school), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/schools/{id}")
	public ResponseEntity<HttpStatus> deleteSchool(@PathVariable("id") long id) {
		try {
			schoolRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/schools")
	public ResponseEntity<HttpStatus> deleteAllSchool() {
		try {
			schoolRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//this.schoolRepository.save(new School("ICAM",10,"8 Avenue de la porte de Lyon"));
		System.out.println("Tranquille");
	}

	/*@GetMapping("/Schools/price")
	public ResponseEntity<List<School>> findByPrice(Double price) {
		try {
			List<School> Schools = schoolRepository.findByPrice(price);

			if (Schools.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Schools, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

}
