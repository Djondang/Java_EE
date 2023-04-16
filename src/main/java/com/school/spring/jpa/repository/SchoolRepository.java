package com.school.spring.jpa.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.school.spring.jpa.model.School;

public interface SchoolRepository extends CrudRepository<School, Long>{
	
	Optional<School> findById(int id);


}
