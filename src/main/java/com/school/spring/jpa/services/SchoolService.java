package com.school.spring.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.spring.jpa.model.School;
import com.school.spring.jpa.repository.SchoolRepository;
import com.school.spring.jpa.repository.SchoolServiceInt;

@Service
public class SchoolService implements SchoolServiceInt{
	
	@Autowired
	
    SchoolRepository schoolRepository;
    
	@Override
	
	public School AddSchool(School school) {
		schoolRepository.save(school);
		return school;
	}

	@Override
	public void DeleteAllSchool(School deleteAll) {
		schoolRepository.delete(deleteAll);
		
	}

	@Override
	public void DeleteSchool(Long id) {
	     schoolRepository.deleteById(id);	
	}

	@Override
	public List<School> getAllSchool() {
		return (List<School>) schoolRepository.findAll();
	}

	@Override
	public School UpdateSchool(School school) {
		// TODO Auto-generated method stub
		return schoolRepository.save(school);
	}

}
