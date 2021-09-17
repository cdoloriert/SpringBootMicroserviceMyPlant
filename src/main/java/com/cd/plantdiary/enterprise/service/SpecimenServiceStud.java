package com.cd.plantdiary.enterprise.service;

import org.springframework.stereotype.Component;

import com.cd.plantdiary.enterprise.dto.Specimen;

@Component
public class SpecimenServiceStud implements ISpecimenService{

	@Override
	public Specimen fetchById(int id) {

		Specimen specimen = new Specimen();
		specimen.setDescription("easter buds");
		specimen.setId("83");
		
		return specimen;

	}

}
