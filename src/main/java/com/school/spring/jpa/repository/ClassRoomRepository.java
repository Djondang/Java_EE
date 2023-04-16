package com.school.spring.jpa.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.school.spring.jpa.model.ClassRoom;

public interface ClassRoomRepository extends CrudRepository<ClassRoom, Long>{
	
	Optional<ClassRoom> findById(int id);

}
