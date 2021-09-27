package com.cd.plantdiary.enterprise.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Specimen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int specimenId;
	private int plantId;
	private String name;
	private String size;
	private String description;
	private String latitude;
	private String longitude;
}