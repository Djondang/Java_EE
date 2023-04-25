package com.school.spring.jpa.repository;

import java.util.List;

import com.school.spring.jpa.model.School;

public interface SchoolServiceInt {
	
	//For school	
	School AddSchool(School add);
    void DeleteAllSchool(School deleteAll);
    void DeleteSchool(Long id);
    List<School> getAllSchool(Integer page, Integer size);
	School UpdateSchool(School school);
	List<School> findBySchool_Name(String school_Name);
	//List<School> findBySchool_Name(String school_Name, Integer page, Integer size);

}
