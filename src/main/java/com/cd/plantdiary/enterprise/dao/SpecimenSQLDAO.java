package com.cd.plantdiary.enterprise.dao;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Specimen fetch(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
