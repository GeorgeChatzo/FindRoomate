package main.java.gr.aueb.mscis.roomatefinder.model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.status;

public class FlatmateTest {


	@Test
	public void testName() {
		
		Flatmate flatmate = new Flatmate();	
		flatmate.setName("Dildo");
		assertTrue(flatmate.getName().equals("Dildo"));
	
	}
	
	@Test
	public void testSurname() {
		
		Flatmate flatmate = new Flatmate();	
		flatmate.setSurname("Baggins");
		assertTrue(flatmate.getSurname().equals("Baggins"));
		
	}
	
	@Test
	public void testDescription() {
		
		Flatmate flatmate = new Flatmate();	
		flatmate.setDescription("Enoikiazetai spiti");
		assertTrue(flatmate.getDescription().equals("Enoikiazetai spiti"));
		
	}
	
	@Test
	public void testGender() {
		
		Flatmate flatmate = new Flatmate();	
		flatmate.setGender("Male");
		assertTrue(flatmate.getGender().equals("Male"));
		
	}
	
	@Test
	public void testProfessionCaseStudent() {
		
		status profession = status.STUDENT;
		Flatmate flatmate = new Flatmate();	
		flatmate.setProfession(profession);
		assertTrue(flatmate.getProfession().equals(profession));
		
	}
	
	@Test
	public void testProfessionCaseEmployee() {
		
		status profession = status.EMPLOYEE;
		Flatmate flatmate = new Flatmate();	
		flatmate.setProfession(profession);
		assertTrue(flatmate.getProfession().equals(profession));
		
	}
	
	@Test
	public void testProfessionCaseUnemployed() {
		
		status profession = status.UNEMPLOYED;
		Flatmate flatmate = new Flatmate();	
		flatmate.setProfession(profession);
		assertTrue(flatmate.getProfession().equals(profession));
		
	}
	
	@Test
	public void testPets() {
		
		Flatmate flatmate = new Flatmate();	
		flatmate.setPets(true);
		assertTrue(flatmate.isPets()==true);
		
	}
	
	@Test
	public void testHabitsAddition() {
		
		Flatmate flatmate = new Flatmate();	
		Set<String> habits = new HashSet<String>();
		habits.add("smoker");
		habits.add("gym lover");
		flatmate.setHabits(habits);
		assertTrue(flatmate.getHabits().equals(habits));
		
	}
	
	@Test
	public void testHabitsRemove() {
		
		Flatmate flatmate = new Flatmate();	
		Set<String> habits = new HashSet<String>();
		habits.add("smoker");
		habits.add("gym lover");
		flatmate.setHabits(habits);
		habits.remove("smoker");
		assertTrue(flatmate.getHabits().equals(habits));
		
	}
	
	@Test
	public void testWorkSchedule() {
		
		Flatmate flatmate = new Flatmate();	
		String workSchedule = "Everyday all day";
		flatmate.setWorkSchedule(workSchedule);
		assertTrue(flatmate.getWorkSchedule().equals(workSchedule));
		
	}
	
	@Test
	public void testIncomingGuests() {
		
		Flatmate flatmate = new Flatmate();	
		flatmate.setIncomingGuests(true);
		assertTrue(flatmate.isIncomingGuests()==true);
		
	}
	
	@Test
	public void testEmail() {
		
		EmailAddress email = new EmailAddress("giorgos@gmail.com");
		Flatmate flatmate = new Flatmate();
		flatmate.setEmail(email);
		assertTrue(flatmate.getEmail().equals(email));
		
	}
	
	@Test
	public void testPhone() {
		
		CellNumber phone = new CellNumber("210123456");
		Flatmate flatmate = new Flatmate();
		flatmate.setPhoneNumber(phone);
		assertTrue(flatmate.getPhoneNumber().equals(phone));
		
	}
	
	@Test
	public void testAddCohabitRequest() {
		
		Flatmate flatmate = new Flatmate();
		CohabitRequest req1 = new CohabitRequest();
	    flatmate.addCohabitRequest(req1);
	    assertTrue(flatmate.getCohabitRequest().size()==1);
		
	}
	
	@Test
	public void testRemoveCohabitRequest() {
		
		Flatmate flatmate = new Flatmate();
		CohabitRequest req1 = new CohabitRequest();
	    flatmate.addCohabitRequest(req1);
	    flatmate.removeCohabitRequest(req1);
	    assertTrue(flatmate.getCohabitRequest().size()==0);
		
	}
	
	@Test
	public void testRequestTest() {
		
		Flatmate flatmate = new Flatmate();
		HouseAd ad = new HouseAd();
		CohabitRequest corequest = new CohabitRequest();
		corequest = flatmate.request(ad);
		flatmate.addCohabitRequest(corequest);
		assertTrue(flatmate.getCohabitRequest().iterator().next().getHouseAd().equals(ad));
		
	}
	
	@Test
	public void testRequestTestNull() {
		
		Flatmate flatmate = new Flatmate();
		HouseAd ad = null;
		CohabitRequest corequest;
		corequest = flatmate.request(ad);
		Assert.assertNull(corequest);
		
	}
	
	@Test 
	public void testCancelRequest() {
		
		Flatmate flatmate = new Flatmate();
		HouseAd ad = new HouseAd();
		CohabitRequest corequest = new CohabitRequest();
		corequest = flatmate.request(ad);
		flatmate.addCohabitRequest(corequest);
		flatmate.cancelRequest(corequest);
		assertTrue(flatmate.getCohabitRequest().size()==0);
		
	}
	
	
	
	
	
	

}
