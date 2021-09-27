package com.cd.plantdiary.enterprise.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cd.plantdiary.enterprise.dao.IPhotoDAO;
import com.cd.plantdiary.enterprise.dao.IPlantDAO;
import com.cd.plantdiary.enterprise.dao.ISpecimenDAO;
import com.cd.plantdiary.enterprise.dto.Photo;
import com.cd.plantdiary.enterprise.dto.Plant;
import com.cd.plantdiary.enterprise.dto.Specimen;

@Service
public class SpecimenService implements ISpecimenService{

	@Autowired
	private ISpecimenDAO specimenDAO;
	
	@Autowired
	private IPlantDAO plantDAO;
	
	@Autowired
	private IPhotoDAO photoDAO;
	
	public SpecimenService() {}
	
	public SpecimenService(ISpecimenDAO specimenDAO) {
		this.specimenDAO = specimenDAO;
	}	
	
	@Override
	@Cacheable(value="specimen", key="#id")
	public Specimen fetchById(int id) {
		return specimenDAO.fetch(id);
	}

	@Override
	public Specimen save(Specimen specimen) throws Exception {			
		return specimenDAO.save(specimen);			
	}

	@Override
	@Cacheable(value="specimens")
	public List<Specimen> fetchAll() {
		return specimenDAO.fetchAll();		
	}

	@Override
	@CacheEvict(value="specimen", key="#id")
	public void delete(int id) throws Exception {
		specimenDAO.delete(id);
		
	}

	@Override
	@Cacheable("plants")
	public List<Plant> fetchPlants(String combinedName) throws IOException {
		return plantDAO.fetchPlants(combinedName);
	}

	@Override
	public void saveImage(MultipartFile imageFile, Photo photo) throws IOException {
		photoDAO.save(photo);
		photoDAO.saveImage(imageFile);
		
	}

	

}
