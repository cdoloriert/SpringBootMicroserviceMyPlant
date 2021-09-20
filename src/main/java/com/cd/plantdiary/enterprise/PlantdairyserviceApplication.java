package com.cd.plantdiary.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cd.plantdiary.enterprise.*"})
public class PlantdairyserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantdairyserviceApplication.class, args);
	}

}
