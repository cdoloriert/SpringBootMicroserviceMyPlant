package com.cd.plantdiary.enterprise;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cd.plantdiary.enterprise.dto.Specimen;
import com.cd.plantdiary.enterprise.service.ISpecimenService;

//@ContextConfiguration
@SpringBootTest
class PlantdairyserviceApplicationTests {

	@Autowired
	private ISpecimenService specimenService;	
	
	private Specimen specimen;
	
	@Test
	void contextLoads() {
	}
	
	/***
	 * Given
	 * When
	 * Then
	 */
	@Test
	void fetchSpecimeById_returnsById83() {		
		givenSpecimenDataAreAvailable();		
		whenSearchSpecimenWithId83();
		thenReturnOneEsternReboundSpecimenfor83();		
	}

	private void givenSpecimenDataAreAvailable() {
			
	}

	private void whenSearchSpecimenWithId83() {		
		specimen = specimenService.fetchById(83);		
	}

	private void thenReturnOneEsternReboundSpecimenfor83() {
		String description = specimen.getDescription();		
		assertEquals("easter buds", description);		
	}
	

}
