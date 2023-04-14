package com.school.spring.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.spring.jpa.model.School;

public interface SchoolRepository extends JpaRepository<School, Long>{
	
	/*@Override
	default Optional<School> findById(Long id) {	
		// TODO Auto-generated method stub
		return Optional.empty();
	}*/
	
	Optional<School> findById(Long id);

}
