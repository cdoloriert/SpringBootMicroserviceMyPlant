package com.cd.enterprise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PlantDiaryController {
	
	@GetMapping("start")
	public String home() {
		return "start";
	}	
	
	@GetMapping("specimens")
	public ResponseEntity fetchAll() {		
		return new ResponseEntity(HttpStatus.OK);		
	}
	
	
	

}
