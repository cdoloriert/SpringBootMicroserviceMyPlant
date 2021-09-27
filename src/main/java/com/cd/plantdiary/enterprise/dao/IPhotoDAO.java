package com.cd.plantdiary.enterprise.dao;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.cd.plantdiary.enterprise.dto.Photo;

public interface IPhotoDAO {

	void save(Photo photo);

	void saveImage(MultipartFile imageFile) throws IOException;

}