package com.grokonez.jwtauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.entitys.Machine;
import com.grokonez.jwtauthentication.entitys.MoreData;
import com.grokonez.jwtauthentication.repository.MachineRepository;
import com.grokonez.jwtauthentication.repository.MoreDataRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/data")

public class MoreDataController {

	@Autowired
	MoreDataRepository moreDataRepository;
	
	@GetMapping("/list")
	public List<MoreData> getALLMchines(){
		return this.moreDataRepository.findAll();
	}
	
}
