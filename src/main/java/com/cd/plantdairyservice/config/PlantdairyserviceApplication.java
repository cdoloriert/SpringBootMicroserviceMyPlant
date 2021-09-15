package com.cd.plantdairyservice.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cd.plantdairyservice"})
public class PlantdairyserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantdairyserviceApplication.class, args);
	}

}
