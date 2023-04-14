package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ecoleRepository.EcoleRepository;
import com.example.demo.entities.Ecole;

@Service
public class EcoleServiceImpl implements EcoleService {
	
	@Autowired
	
     EcoleRepository RepEcole;
     
	@Override
	
	public Ecole AjouterEcole(Ecole u) {
		RepEcole.save(u);
		return u;
	}

	@Override
	public void DeleteEcole(Ecole u) {
		RepEcole.delete(u);
		
	}

	@Override
	public void DeleteEcole(Long id) {
	     RepEcole.deleteById(id);
		
	}

	@Override
	public List<Ecole> getAllEcole() {
		
		return (List<Ecole>) RepEcole.findAll();
	}

}
