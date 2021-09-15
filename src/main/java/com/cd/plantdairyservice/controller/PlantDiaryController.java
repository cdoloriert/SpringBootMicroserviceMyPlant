package com.cd.plantdairyservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.plantdairyservice.dto.Specimen;

/***
 * Class controller
 * @author cd
 *
 */
@RestController
@RequestMapping("/")
public class PlantDiaryController {
	
	@GetMapping("start")
	public String home() {
		return "start";
	}	
	
	@GetMapping("specimens")
	public ResponseEntity getAll() {		
		return new ResponseEntity(HttpStatus.OK);		
	}
	
	@GetMapping("specimens/{id}")
	public ResponseEntity getSpecimenById(
			@PathVariable String id
			) {		
		return new ResponseEntity(HttpStatus.OK);		
	}
	
	/***
	 * Create a new specimen
	 * 
	 * 201: success
	 * 409: unable
	 * @param specimen
	 * @return ResponseEntity
	 */
	@PostMapping(value="specimens", consumes = "application/json", produces= "application/json")
	public ResponseEntity createSpecimen(
			@RequestBody Specimen specimen
			) {		
		return new ResponseEntity(HttpStatus.OK);		
	}
	
	@DeleteMapping(value="specimens/{id}")
	public ResponseEntity createSpecimen(
			@PathVariable String id
			) {		
		return new ResponseEntity(HttpStatus.OK);		
	}
	

}
