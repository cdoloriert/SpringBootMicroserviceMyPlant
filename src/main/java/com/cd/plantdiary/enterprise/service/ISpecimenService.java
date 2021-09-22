package com.cd.plantdiary.enterprise.service;

import java.io.IOException;
import java.util.List;

import com.cd.plantdiary.enterprise.dto.Plant;
import com.cd.plantdiary.enterprise.dto.Specimen;


public interface ISpecimenService {

	/***
	 * fetch specimen with a give id
	 * @param id for specimen
	 * @return Specimen or null
	 */
	Specimen fetchById(int id);
	Specimen save(Specimen specimen) throws Exception;
	List<Specimen> fetchAll();	
	void delete(int id) throws Exception;
	List<Plant> fetchPlants(String combinedName) throws IOException;

}
