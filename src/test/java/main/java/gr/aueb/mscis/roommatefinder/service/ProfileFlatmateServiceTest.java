package main.java.gr.aueb.mscis.roommatefinder.service;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.status;
import main.java.gr.aueb.mscis.roommatefinder.persistence.Initializer;

public class ProfileFlatmateServiceTest extends RoommateServiceTest {

	@Test
	public void updatePersonalDetails() {

        CellNumber cell = new CellNumber("69445458");
        EmailAddress email = new EmailAddress("bestemail@example.com");
        Set<String> habits = null ;
        Set<Double> rating = null;
        
        ProfileFlatmateService service = new ProfileFlatmateService(em);
		
        boolean updateDetails = service.updatePersonalDetails("bling", "1234", email, cell, "Eric",
    			"Adams", 27, "fantastic xooxo","male", status.EMPLOYEE, true,
    			habits, "Christmas",true, rating, Initializer.flatmate_id);
        
        assertTrue(updateDetails);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void updateNullPersonalDetails() {

        CellNumber cell = new CellNumber("69445458");
        EmailAddress email = new EmailAddress("bestemail@example.com");
        Set<String> habits = null ;
        Set<Double> rating = null;
        
        ProfileFlatmateService service = new ProfileFlatmateService(em);
		
        boolean updateDetails = service.updatePersonalDetails("bling", "1234", email, cell, "Eric",
    			"Adams", 27, "fantastic xooxo","male", status.EMPLOYEE, true,
    			habits, "Christmas",true, rating, Initializer.flatmate_id);
        
        assertTrue(updateDetails);
	}
	
	@Test
	public void testfindFlatmate() {
		ProfileFlatmateService service = new ProfileFlatmateService(em);
		Flatmate flatmate = service.findFlatmateById(Initializer.flatmate_id);
		
		assertNotNull(flatmate);
		
	}
	
	@Test
	public void testCancel() {
		ProfileFlatmateService service = new ProfileFlatmateService(em);
		boolean checkCancel = service.cancelUpdate();
		
		assertTrue(checkCancel);
	}
	

}
