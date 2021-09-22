package com.cd.plantdiary.enterprise.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cd.plantdiary.enterprise.dto.Plant;
import com.cd.plantdiary.enterprise.dto.PlantResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

@Repository
public class PlantDAO implements IPlantDAO {

	@Override
	public List<Plant> fetchPlants(String combinedName) throws IOException {
		
		Retrofit retrofitInstance = RetrofitClientInstance.getRetrofitClientInstance();
		IPlantRetrofitDAO plantRetrofitDAO = retrofitInstance.create(IPlantRetrofitDAO.class);
		Call<PlantResponse> plantResponse = plantRetrofitDAO.getPlants(combinedName);
		Response<PlantResponse> execute = plantResponse.execute();
		PlantResponse plants = execute.body();
		List<Plant> listPlants = plants.getPlants(); 
		
		return listPlants;
	}

}
