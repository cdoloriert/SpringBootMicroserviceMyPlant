package com.cd.plantdiary.enterprise.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cd.plantdiary.enterprise.dto.LabelValue;
import com.cd.plantdiary.enterprise.dto.Photo;
import com.cd.plantdiary.enterprise.dto.Plant;
import com.cd.plantdiary.enterprise.dto.Specimen;
import com.cd.plantdiary.enterprise.service.ISpecimenService;


@RestController
public class PlantDiaryController {

	Logger log = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	ISpecimenService specimenService;

	@GetMapping(value = { "/", "/index" })
	public ModelAndView index(Model model) {
		ModelAndView modelAndView = new ModelAndView("index");
		Specimen specimen = new Specimen();

		specimen.setDescription("new specimen");
		specimen.setLatitude("12.33");
		specimen.setLongitude("2.44");
		specimen.setPlantId(1000);
		specimen.setSpecimenId(1004);

		modelAndView.addObject("specimen", specimen);
		return modelAndView;
	}

	@GetMapping("/sustainability")
	public ModelAndView sustainability(Model model) {
		ModelAndView modelAndView = new ModelAndView("sustainability");
		modelAndView.addObject("", null);
		return modelAndView;
	}

	/***
	 * Gets all specimen
	 * 
	 * 200: success
	 * 
	 * @param specimen
	 * @return ResponseEntity
	 */
	@GetMapping("/specimens")
	@ResponseBody
	public List<Specimen> fetchAll() {
		return specimenService.fetchAll();
	}

	/***
	 * Get specimen by id
	 * 
	 * 201: success 409: unable
	 * 
	 * @param specimen
	 * @return ResponseEntity
	 */
	@GetMapping("/specimens/{id}")
	public ResponseEntity getSpecimenById(@PathVariable String id) {

		Specimen foundSpecimen = specimenService.fetchById(Integer.parseInt(id));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity(foundSpecimen, headers, HttpStatus.OK);
	}

	/***
	 * Create a new specimen from new points
	 * 
	 * 201: success 409: unable
	 * 
	 * @param specimen
	 * @return ResponseEntity
	 */
	@PostMapping(value = "/specimens", consumes = "application/json", produces = "application/json")
	public ResponseEntity createSpecimen(@RequestBody Specimen specimen) {
		Specimen createdSpecimen = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			createdSpecimen = specimenService.save(specimen);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity(createdSpecimen, headers, HttpStatus.OK);
	}

	@DeleteMapping(value = "/specimens/{id}")
	public ResponseEntity deleteSpecimen(@PathVariable String id) {

		log.debug("entering specimen endpoint");
		try {
			specimenService.delete(Integer.parseInt(id));
			log.info("specimen was deleted");
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("unable to delete" + id + e.getMessage(), e);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/plants", consumes = "application/json", produces = "application/json")
	public ResponseEntity searchPlants(
			@RequestParam(value = "searchTerm", required = false, defaultValue = "None") String searchTerm) {

		ModelAndView modelAndView = new ModelAndView("index");

		try {
			List<Plant> fetchedPlants = specimenService.fetchPlants(searchTerm);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity(fetchedPlants, headers, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/plants")
	public ModelAndView searchPlantsForForm(
			@RequestParam(value = "searchTerm", required = false, defaultValue = "None") String searchTerm) {

		ModelAndView modelAndView = null;

		try {
			List<Plant> plants = specimenService.fetchPlants(searchTerm);
			modelAndView = new ModelAndView("plants");
			modelAndView.addObject("plants", plants);
			return modelAndView;
		} catch (IOException e) {
			e.printStackTrace();
			modelAndView = new ModelAndView("error");
		}
		return modelAndView;
	}

	@GetMapping("/plantNamesAutocomplete")
	@ResponseBody
	public List<LabelValue> plantNamesAutocomplete(
			@RequestParam(value = "term", required = false, defaultValue = "") String term) {

		List<LabelValue> allPlantNames = new ArrayList<LabelValue>();

		try {
			List<Plant> fetchedPlants = specimenService.fetchPlants(term);

			for (Plant plant : fetchedPlants) {
				LabelValue labelValue = new LabelValue();
				labelValue.setLabel(plant.toString());
				labelValue.setValue(plant.getId());
				allPlantNames.add(labelValue);
			}
			return allPlantNames;
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<LabelValue>();
		}
	}

	@PostMapping("/saveSpecimen")
	public ModelAndView saveSpecimen(Specimen specimen, @RequestParam("imageFile") MultipartFile imageFile) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			Specimen createdSpecimen = specimenService.save(specimen);
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView = new ModelAndView("error");
			return modelAndView;
		}
		//modelAndView = new ModelAndView("index");
		
		Photo photo = new Photo();
		try {			
			photo.setFileName(imageFile.getOriginalFilename());
			//photo.setPath("/photo/");
			photo.setSpecimen(specimen);
			specimenService.saveImage(imageFile, photo);
			modelAndView = new ModelAndView("success");
			
		} catch (IOException e) {
			e.printStackTrace();
			modelAndView = new ModelAndView("error");
			return modelAndView;
		}
		
		modelAndView.addObject("specimen", specimen);
		modelAndView.addObject("photo", photo);
		
		return modelAndView;
	}
	
	@GetMapping(value = "/specimensByPlant/{plantId}")
	public ModelAndView specimensByPlant(@PathVariable("plantId") int plantId) {
		ModelAndView modelAndView = new ModelAndView("specimenDetails");			
		List<Specimen> specimens = specimenService.fetchSpecimensByPlantId(plantId);		
		modelAndView.addObject("specimens", specimens);	

		return modelAndView;
	}
	

}
