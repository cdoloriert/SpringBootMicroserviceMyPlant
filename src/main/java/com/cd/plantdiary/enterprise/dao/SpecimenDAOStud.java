package com.cd.plantdiary.enterprise.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cd.plantdiary.enterprise.dto.Specimen;

@Repository
public class SpecimenDAOStud implements ISpecimenDAO {

	Map<Integer, Specimen> allSpecimens = new HashMap<Integer, Specimen>();	
	
	@Override
	public Specimen save(Specimen specimen) throws Exception {
		Integer sId = Integer.parseInt(specimen.getId());
		allSpecimens.put(sId, specimen);		
		return specimen;
	}

	@Override
	public List<Specimen> fetchAll() {	
		List<Specimen> returnValues = new ArrayList(allSpecimens.values());		
		return returnValues;
	}

	@Override
	public Specimen fetch(int id) {		
		 return allSpecimens.get(id);
	}

	@Override
	public void delete(int id) {
		allSpecimens.remove(id);		
	}
	
	

}
