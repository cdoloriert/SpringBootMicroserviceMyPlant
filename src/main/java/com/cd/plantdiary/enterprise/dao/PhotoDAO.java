package com.cd.plantdiary.enterprise.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.kafka.core.KafkaTemplate;

import com.cd.plantdiary.enterprise.dto.Photo;


@Repository
public class PhotoDAO implements IPhotoDAO {

	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Override
	public void save(Photo photo) {
		photoRepository.save(photo);
	}
	
	@Override
	public void saveImage(MultipartFile imageFile, Photo photo) throws IOException {
		
		Path currentPath = Paths.get(".");
		Path absPath = currentPath.toAbsolutePath();
		photo.setPath(absPath + "/src/main/resources/static/photos/");		
		byte[] bytes = imageFile.getBytes();		
		Path path = Paths.get(photo.getPath() + imageFile.getOriginalFilename());
		Files.write(path, bytes);	
		
		kafkaTemplate.send("photoIn", path.normalize().toString());
	}
	
}
