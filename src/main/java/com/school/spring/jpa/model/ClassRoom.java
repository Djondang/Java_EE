package com.school.spring.jpa.model;

//import jakarta.persistence.CascadeType;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class ClassRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String className;
	private String description;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "school_id")
	//@JsonIgnoreProperties("classRoom")
	@ManyToOne  
    @JoinTable( name = "T_School_Class_Associations",
                joinColumns = @JoinColumn( name = "class_id" ),
                inverseJoinColumns = @JoinColumn( name = "school_id" ) )
	private School school;
	
	
	public ClassRoom() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ClassRoom(String className, String description, School school) {
		super();
		this.className = className;
		this.description = description;
		this.school = school;
	}
	
	// Setter and getter

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	
	
	
}
