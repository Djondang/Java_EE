package com.school.spring.jpa.repository;

import java.util.List;

import com.school.spring.jpa.model.ClassRoom;

public interface ClassRoomServiceInt {
	
	//For Classroom
	ClassRoom AddClass(ClassRoom add);
	void DeleteAllClass(ClassRoom deleteAll);
    void DeleteClass(Long id);
    List<ClassRoom> getAllClass();
	ClassRoom UpdateClass(ClassRoom C);

}
