package com.cd.plantdiary.enterprise.dao;

import java.io.IOException;
import java.util.List;

import com.cd.plantdiary.enterprise.dto.Plant;

public interface IPlantDAO {

	List<Plant> fetchPlants(String combinedName) throws IOException;
	
}
