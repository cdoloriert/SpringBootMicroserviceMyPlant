package com.cd.plantdiary.enterprise.service;

import org.springframework.stereotype.Component;

import com.cd.plantdiary.enterprise.dao.ISpecimenDAO;
import com.cd.plantdiary.enterprise.dto.Specimen;

@Component
public class SpecimenServiceStud implements ISpecimenService{

	private ISpecimenDAO specimenDAO;
	
	public SpecimenServiceStud() {}
	
	public SpecimenServiceStud(ISpecimenDAO specimenDAO) {
		this.specimenDAO = specimenDAO;
	}	
	
	@Override
	public Specimen fetchById(int id) {
		Specimen specimen = new Specimen();
		specimen.setDescription("easter buds");
		specimen.setId("83");		
		return specimen;

	}

	@Override
	public Specimen save(Specimen specimen) throws Exception {			
		return specimenDAO.save(specimen);	
		
	}

}
