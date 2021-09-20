package com.cd.plantdiary.enterprise.dao;

import java.util.List;

import com.cd.plantdiary.enterprise.dto.Specimen;

public interface ISpecimenDAO {

	Specimen save(Specimen specimen) throws Exception;

	List<Specimen> fetchAll();

	Specimen fetch(int id);

	void delete(int id);

}
