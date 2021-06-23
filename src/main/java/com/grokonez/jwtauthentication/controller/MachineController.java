package com.grokonez.jwtauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.entitys.Machine;
import com.grokonez.jwtauthentication.repository.MachineRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/machines")
public class MachineController {
	
	
	@Autowired
	MachineRepository machineRepository;
	
	@GetMapping("/list")
	public List<Machine> getALLMchines(){
		return this.machineRepository.findAll();
	}
	
	
	 @PostMapping("/add")
	 public Machine addNewMachine(@RequestBody Machine vm ){
		 return this.machineRepository.save(vm);
		 
	 }
	
	
	
	 @GetMapping("/delete/{id}")
	 public void deleteMachine(@PathVariable(value ="id") Long id){
		
			 
			 Machine x = this.machineRepository.findById(id).get();
			 this.machineRepository.delete(  x  );
			
	 }

}
