package com.cd.plantdiary.enterprise.service;

import com.cd.plantdiary.enterprise.dto.Specimen;


public interface ISpecimenService {

	/***
	 * fetch specimen with a give id
	 * @param id for specimen
	 * @return Specimen or null
	 */
	Specimen fetchById(int id);

	Specimen save(Specimen specimen) throws Exception;

}
