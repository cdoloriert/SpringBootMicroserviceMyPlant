package com.cd.plantdiary.enterprise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.plantdiary.enterprise.dao.ISpecimenDAO;
import com.cd.plantdiary.enterprise.dto.Specimen;

@Service
public class SpecimenServiceStud implements ISpecimenService{

	@Autowired
	private ISpecimenDAO specimenDAO;
	
	public SpecimenServiceStud() {}
	
	public SpecimenServiceStud(ISpecimenDAO specimenDAO) {
		this.specimenDAO = specimenDAO;
	}	
	
	@Override
	public Specimen fetchById(int id) {
		return specimenDAO.fetch(id);
	}

	@Override
	public Specimen save(Specimen specimen) throws Exception {			
		return specimenDAO.save(specimen);			
	}

	@Override
	public List<Specimen> fetchAll() {
		return specimenDAO.fetchAll();		
	}

	@Override
	public void delete(int id) throws Exception {
		specimenDAO.delete(id);
		
	}

}
