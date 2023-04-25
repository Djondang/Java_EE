package com.school.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;

import com.school.spring.jpa.model.ClassRoom;
//import com.school.spring.jpa.repository.ClassRoomRepository;
import com.school.spring.jpa.repository.ClassRoomServiceInt;

@RestController
public class ClassRoomController {
	
	@Autowired
	private ClassRoomServiceInt classRoomService;

	
	@GetMapping("/class")
	@ResponseBody
	public List<ClassRoom> getAllClassRooms(){
		List<ClassRoom> list= classRoomService.getAllClass();
		return list;
		
	}
	
	//pour ajouter une classe
	@PostMapping("/addclass")
	@ResponseBody
	public ClassRoom AddClassRoom(@RequestBody ClassRoom add) {
		return classRoomService.AddClass(add);
	}
	//pour la supression classe
	@DeleteMapping("deleteclass/{id}")
	@ResponseBody
	public void deleteClassRoom(@PathVariable("id") Long idClassRoom) {
		classRoomService.DeleteClass(idClassRoom);
	}
	
	//pour mettre à jour une classe
	@PutMapping("/updateclass/{id}")
	public ClassRoom UpdateClassRoom(@PathVariable Long id, @RequestBody ClassRoom C) {
		C.setId(id);
		return classRoomService.UpdateClass(C);
	}

}
