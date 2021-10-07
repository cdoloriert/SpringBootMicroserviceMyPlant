package com.cd.plantdiary.enterprise.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import com.cd.plantdiary.enterprise.dto.Specimen;

@Profile("!test")
public interface SpecimenRepository extends CrudRepository<Specimen, Integer> {

	List<Specimen> findByPlantId(int plantId);
}
