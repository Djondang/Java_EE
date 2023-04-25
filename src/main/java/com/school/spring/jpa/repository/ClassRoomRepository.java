package com.school.spring.jpa.repository;


import org.springframework.data.repository.CrudRepository;

import com.school.spring.jpa.model.ClassRoom;

public interface ClassRoomRepository extends CrudRepository<ClassRoom, Long>{
	
	ClassRoom findById(int id);

}
