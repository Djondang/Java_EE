package com.school.spring.jpa.model;

import jakarta.persistence.*;

@Entity
public class School {
	
	@Id
	private Long id;
	@Column(unique = true)
	private String School_Name;
	private int ClassNumber;
	@Column(unique = true)
	private String address;
	
	public School() {
		// TODO Auto-generated constructor stub
	}

	public School(String school_Name, int classNumber, String address) {
		super();
		School_Name = school_Name;
		ClassNumber = classNumber;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSchool_Name() {
		return School_Name;
	}

	public void setSchool_Name(String school_Name) {
		School_Name = school_Name;
	}

	public int getClassNumber() {
		return ClassNumber;
	}

	public void setClassNumber(int classNumber) {
		ClassNumber = classNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
