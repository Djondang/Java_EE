package com.school.spring.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.school.spring.jpa.model.ClassRoom;
import com.school.spring.jpa.repository.ClassRoomRepository;
import com.school.spring.jpa.repository.ClassRoomServiceInt;

@Service
public class ClassRoomService implements ClassRoomServiceInt{
	
	@Autowired(required = false)
	ClassRoomRepository cRepository;
    
	@Override
	public ClassRoom AddClass(ClassRoom C) {
		cRepository.save(C);
		return C;
	}

	@Override
	public void DeleteAllClass(ClassRoom deleteAll) {
		cRepository.delete(deleteAll);
		
	}

	@Override
	public void DeleteClass(Long id) {
	     cRepository.deleteById(id);	
	}

	@Override
	public List<ClassRoom> getAllClass() {
		return (List<ClassRoom>) cRepository.findAll();
	}

	@Override
	public ClassRoom UpdateClass(ClassRoom C) {
		return cRepository.save(C);
	}

}
