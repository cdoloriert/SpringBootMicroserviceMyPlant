package com.cd.plantdiary.enterprise.dao;

import java.util.List;

import com.cd.plantdiary.enterprise.dto.Plant;
import com.cd.plantdiary.enterprise.dto.PlantResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IPlantRetrofitDAO {
	
	@GET("/perl/mobile/viewplantsjson.pl")
	Call<PlantResponse> getPlants(@Query("Combined_Name")String combinedName);	

}
