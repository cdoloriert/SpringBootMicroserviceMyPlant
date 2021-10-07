package com.cd.plantdiary.enterprise.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy="specimen")
	private List<Photo> photos;
}