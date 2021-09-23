package com.cd.plantdiary.enterprise.dao;

import org.springframework.data.repository.CrudRepository;

import com.cd.plantdiary.enterprise.dto.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
	
	

}
