package com.cd.plantdiary.enterprise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cd.plantdiary.enterprise.dao.ISpecimenDAO;
import com.cd.plantdiary.enterprise.dto.Specimen;
import com.cd.plantdiary.enterprise.service.ISpecimenService;
import com.cd.plantdiary.enterprise.service.SpecimenServiceStud;

//@ContextConfiguration
@SpringBootTest
class PlantdairyserviceApplicationTests {

	//@Autowired
	private ISpecimenService specimenService;
	
	private Specimen specimen = new Specimen();

	@MockBean
	private ISpecimenDAO specimenDAO;

	@Test
	void contextLoads() {
	}

	/***
	 * Given 
	 * When 
	 * Then
	 */
	@Test
	void fetchSpecimeById_returnsById83() throws Exception {
		givenSpecimenDataAreAvailable();
		whenSpecimen83AddedIsRedbud();
		whenSearchSpecimenWithId83();
		thenReturnOneEsternReboundSpecimenfor83();
	}

	private void whenSpecimen83AddedIsRedbud() {
		Specimen redbud = new Specimen();
		redbud.setId("83");
		redbud.setDescription("easter buds");
		Mockito.when(specimenDAO.fetch(83)).thenReturn(redbud);
		
	}

	private void givenSpecimenDataAreAvailable() throws Exception {

		Mockito.when(specimenDAO.save(specimen)).thenReturn(specimen);
		specimenService = new SpecimenServiceStud(specimenDAO);
		

	}

	private void whenSearchSpecimenWithId83() {
		specimen = specimenService.fetchById(83);
	}

	private void thenReturnOneEsternReboundSpecimenfor83() {
		String description = specimen.getDescription();
		assertEquals("easter buds", description);
	}

	@Test
	void SaveSpecimen_validateReturnSpecimenWithLatituteAndLongtitude() throws Exception {
		givenSpecimenDataAreAvailable();
		whenUserCreatesNewSpecimenAndSaves();
		thenCreateNewSpecimenAndReturnIt();
	}

	private void whenUserCreatesNewSpecimenAndSaves() {
		specimen.setLatitude("39.89");
		specimen.setLongitude("-84.00");
	}

	private void thenCreateNewSpecimenAndReturnIt() throws Exception {
		Specimen createdSpecimen = specimenService.save(specimen);		
		assertEquals(specimen, createdSpecimen);
		
		verify(specimenDAO, atLeastOnce()).save(specimen);
		
		
	}

}
