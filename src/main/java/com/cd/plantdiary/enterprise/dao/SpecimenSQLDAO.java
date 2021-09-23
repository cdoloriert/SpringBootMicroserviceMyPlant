package com.cd.plantdiary.enterprise.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cd.plantdiary.enterprise.dto.Specimen;

@Repository("specimenDAO")
public class SpecimenSQLDAO implements ISpecimenDAO {

	
	@Autowired
	SpecimenRepository specimenRepository;
	
	@Override
	public Specimen save(Specimen specimen) throws Exception {
		Specimen createdSpecimen = specimenRepository.save(specimen);
		return createdSpecimen;
	}

	@Override
	public List<Specimen> fetchAll() {
		List<Specimen> allSpecimens = new ArrayList<Specimen>();
		Iterable<Specimen> specimens = specimenRepository.findAll();		
		for(Specimen specimen : specimens) {
			allSpecimens.add(specimen);
		}
		
		return allSpecimens;
	}

	@Override
	public Specimen fetch(int id) {
		return specimenRepository.findById(id).get();		
	}

	@Override
	public void delete(int id) {
		specimenRepository.deleteById(id);		
	}

}
