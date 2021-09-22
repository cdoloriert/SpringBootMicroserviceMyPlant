package com.cd.plantdiary.enterprise.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Plant {	
	@SerializedName("id")
	private String id;
	@SerializedName("genus")
	private String genus;
	@SerializedName("species")
	private String species;
	@SerializedName("cultivar")
	private String cultivar;
	@SerializedName("common")
	private String common;
	
	public String toString() {
		return genus + " " + species + " " + cultivar + " " + id;
	}
}
