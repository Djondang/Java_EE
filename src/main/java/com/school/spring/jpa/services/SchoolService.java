package com.school.spring.jpa.services;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.data.domain.Page; 
import org.springframework.data.domain.PageRequest; 
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam; 
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
	public List<School> getAllSchool(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) { 
		Pageable paging = PageRequest.of(page, size); 
		Page<School> pagedResult = schoolRepository.findAll(paging); 
		return pagedResult.getContent(); 
	}
	
	@Override
	public School UpdateSchool(School school) {
		// TODO Auto-generated method stub
		return schoolRepository.save(school);
	}

	@Override
	public List<School> findBySchool_Name(String school_Name) {
		// TODO Auto-generated method stub
	
		return schoolRepository.findBySchool_Name(school_Name);

	}

}
