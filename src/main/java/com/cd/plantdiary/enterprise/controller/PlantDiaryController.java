package com.cd.plantdiary.enterprise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cd.plantdiary.enterprise.dto.Specimen;
import com.cd.plantdiary.enterprise.service.ISpecimenService;

/***
 * Class controller
 * @author cd
 *
 */
@RestController
@RequestMapping("/")
public class PlantDiaryController {
	
	@Autowired
	ISpecimenService specimenService;
	
	@GetMapping("start")
	public String home() {
		return "start";
	}	
	
	/***
	 * Gets all specimen
	 * 
	 * 200: success
	 * 
	 * @param specimen
	 * @return ResponseEntity
	 */
	@GetMapping("specimens")
	@ResponseBody
	public List<Specimen> fetchAll() {		
		return specimenService.fetchAll();	
	}
	
	/***
	 * Get specimen by id
	 * 
	 * 201: success
	 * 409: unable
	 * @param specimen
	 * @return ResponseEntity
	 */
	@GetMapping("specimens/{id}")	
	public ResponseEntity getSpecimenById(
			@PathVariable String id
			) {	
		
		Specimen foundSpecimen = specimenService.fetchById(Integer.parseInt(id));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity(foundSpecimen, headers, HttpStatus.OK);	 
		
	}
	
	/***
	 * Create a new specimen from new points
	 * 
	 * 201: success
	 * 409: unable
	 * @param specimen
	 * @return ResponseEntity
	 */
	@PostMapping(value="specimens", consumes = "application/json", produces= "application/json")
	public Specimen createSpecimen(
			@RequestBody Specimen specimen
			) {
		
		Specimen createdSpecimen = null;
		try {
			createdSpecimen = specimenService.save(specimen);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return createdSpecimen;		
	}

	
	@DeleteMapping(value="specimens/{id}")
	public ResponseEntity deleteSpecimen(
			@PathVariable String id
			) {		
		
		try {
			specimenService.delete(Integer.parseInt(id));
			return new ResponseEntity(HttpStatus.OK);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);	
		}		
			
	}
	

}
