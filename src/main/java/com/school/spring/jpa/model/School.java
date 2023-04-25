package com.school.spring.jpa.model;

//import java.util.List;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;

@Entity
public class School {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String school_Name;
	private String address;
	private Integer class_Number;

	//@OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
	//private List<ClassRoom> classRoom;
	

	public School() {
		// TODO Auto-generated constructor stub
	}

	public School(String school_Name, String address, Integer class_Number) {
		super();
		this.school_Name = school_Name;
		this.address = address;
		this.class_Number = class_Number;
		//this.classRoom = classRoom;
	}

	//Setter and getter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSchool_Name() {
		return school_Name;
	}

	public void setSchool_Name(String school_Name) {
		this.school_Name = school_Name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getClass_Number() {
		return class_Number;
	}

	public void setClass_Number(Integer class_Number) {
		this.class_Number = class_Number;
	}
/*
	public List<ClassRoom> getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(List<ClassRoom> classRoom) {
		this.classRoom = classRoom;
	}

	*/
	
}
