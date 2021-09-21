package com.cd.plantdiary.enterprise.dto;

import lombok.Data;

@Data
public class Specimen {
	private String id;
	private String plantId;
	private String name;
	private String size;
	private String description;
	private String latitude;
	private String longitude;
}