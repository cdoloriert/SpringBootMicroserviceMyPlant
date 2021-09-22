package com.cd.plantdiary.enterprise.dto;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class PlantResponse {
	
	@SerializedName("plants")
	private List<Plant> plants;

}
