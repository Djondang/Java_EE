package com.school.spring.jpa.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.school.spring.jpa.model.School;

public interface SchoolRepository extends JpaRepository<School, Long>{
	
	Optional<School> findById(int id);

	Page<School> findAll(Pageable paging);
	
	List<School> findBySchool_Name(String school_Name);

	//Page<School> findAll(Pageable paging);


}
