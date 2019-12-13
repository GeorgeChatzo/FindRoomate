package main.java.gr.aueb.mscis.roommatefinder.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.model.status;
import main.java.gr.aueb.mscis.roommatefinder.persistence.Initializer;

public class ProfileResidentServiceTest extends RoommateServiceTest {

	@Test
	public void testUpdatePersonalDetails() {
		ProfileResidentService service = new ProfileResidentService(em);
        CellNumber cell = new CellNumber("694454586");
        EmailAddress email = new EmailAddress("new@example.com");
        Set<Double> rating = null;
        Set<String> preferedHabits = null;
        
		boolean updateDetails = service.updatePersonalDetails("lego", "11355", email,
				cell, "Mary", "Pap",30 , 5, 25, preferedHabits, false, 
				"night", rating, "female",true, status.EMPLOYEE, Initializer.resident1_id);
		
		assertTrue(updateDetails);
	}
	
	@Test
	public void testfindResident() {
		ProfileResidentService service = new ProfileResidentService(em);
		Resident resident = service.findResidentById(Initializer.resident1_id);
		
		assertNotNull(resident);
		
	}
	
	
	@Test
	public void testfindAllResidents() {
		ProfileResidentService service = new ProfileResidentService(em);
		List<Resident> residents = service.findAllResidents();
		
		assertNotNull(residents);
		assertEquals(1, residents.size());
		
	}
	
	

}
