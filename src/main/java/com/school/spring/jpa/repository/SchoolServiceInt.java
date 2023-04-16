package com.school.spring.jpa.repository;

import java.util.List;

import com.school.spring.jpa.model.School;

public interface SchoolServiceInt {
	
	//For school	
	School AddSchool(School add);
    void DeleteAllSchool(School deleteAll);
    void DeleteSchool(Long id);
    List<School> getAllSchool();
	School UpdateSchool(School school);

}
