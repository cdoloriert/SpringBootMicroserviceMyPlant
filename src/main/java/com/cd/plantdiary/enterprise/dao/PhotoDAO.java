package com.cd.plantdiary.enterprise.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.cd.plantdiary.enterprise.dto.Photo;


@Repository
public class PhotoDAO implements IPhotoDAO {

	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public void save(Photo photo) {
		photoRepository.save(photo);
	}
	
	@Override
	public void saveImage(MultipartFile imageFile) throws IOException {
		String folder = "/photos/";
		byte[] bytes = imageFile.getBytes();		
		Path path = Paths.get(folder + imageFile.getOriginalFilename());
		Files.write(path, bytes);		
	}
}
