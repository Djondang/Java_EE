package com.school.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.school.spring.jpa.model.School;
import com.school.spring.jpa.model.ClassRoom;
import com.school.spring.jpa.repository.ClassRoomRepository;
import com.school.spring.jpa.repository.SchoolRepository;

@SpringBootApplication

public class SchoolApplication implements CommandLineRunner{
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
		}
	@Autowired
	SchoolRepository schoolRepository;

	@Autowired
	ClassRoomRepository roomRepository;

	@Override
	
	public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
		System.out.println("Tranquil !");
		
		for (int i = 5; i<=10; i++) {
			int classN = (int)(Math.random()*(101-20));
			School school = new School();
			school.setSchool_Name("Ecole"+i);
			school.setAddress("default address");
			school.setClass_Number(classN);
			schoolRepository.save(school);
			for (int j = 1; j<=classN; j++) {
				String[] rooms = {"A","B","C"};
				ClassRoom room = new ClassRoom();
				for (int r=0; r<rooms.length; r++) {
					for (int y=20;y<=100; y++) {
						room.setClassName(rooms[r]+ j);
						room.setDescription("default description");
						room.setSchool(school);
						roomRepository.save(room);
						}
					}
			}
		}
	}

}