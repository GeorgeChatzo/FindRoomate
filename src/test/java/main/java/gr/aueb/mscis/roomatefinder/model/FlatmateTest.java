package main.java.gr.aueb.mscis.roomatefinder.model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.status;

public class FlatmateTest {

	//test flatmate
	Flatmate flatmate;
	
	@Before
	public void setUp() {
		
		Set<String> habits = new HashSet<String>();
		String workSchedule = "Monday-Friday";
		Set<Double> rating = new HashSet<Double>();
		habits = InitializeHabitsSet(habits);
		EmailAddress email = new EmailAddress("g");
		CellNumber number = new CellNumber("2");
		
		flatmate = new Flatmate("GChatz","qwerty123",email,number,"George","Chatzopoulos"
				,22,"flat","Male",status.STUDENT,true,habits,workSchedule,true,rating);
		
		
	}
	
	Set<String> InitializeHabitsSet(Set<String> habits){
		
		habits.add("smoker");
		habits.add("gym lover");
		
		return habits;
	}
	
	@Test
	public void testFlatmateConstructorSuper() {
		
		Set<Double> rating = new HashSet<Double>();
		EmailAddress email = new EmailAddress("g");
		CellNumber number = new CellNumber("2");
		Flatmate fl = new Flatmate("GChatz","qwerty123",email,number,"George","Chatzopoulos"
				,22,rating);
		fl.setEmail(email);
		fl.setPhoneNumber(number);
		fl.setRating(rating);
		assertTrue(fl.getUsername().equals("GChatz"));
		assertTrue(fl.getPassword().equals("qwerty123"));
		assertTrue(fl.getEmail().equals(email));
		assertTrue(fl.getPhoneNumber().equals(number));
		assertEquals(fl.getAge(),22);
		assertTrue(fl.getRating().equals(rating));


	}
	
	
	@Test
	public void testFlatmateConstructor() {
		
		EmailAddress email = new EmailAddress("g");
		CellNumber number = new CellNumber("2");
		Set<Double> rating = new HashSet<Double>();
		flatmate.setRating(rating);
		flatmate.setEmail(email);
		flatmate.setPhoneNumber(number);
		rating.add(6.0);

		assertTrue(flatmate.getUsername().equals("GChatz"));
		assertTrue(flatmate.getPassword().equals("qwerty123"));
		assertTrue(flatmate.getName().equals("George"));
		assertTrue(flatmate.getSurname().equals("Chatzopoulos"));
		assertTrue(flatmate.getDescription().equals("flat"));
		assertTrue(flatmate.getGender().equals("Male"));
		assertTrue(flatmate.getProfession().equals(status.STUDENT));
		assertEquals(flatmate.getAge(),22);
		assertTrue(flatmate.isPets()==true);
		assertTrue(flatmate.getEmail().equals(email));
		assertTrue(flatmate.getWorkSchedule().equals("Monday-Friday"));
		assertTrue(flatmate.isIncomingGuests()==true);
		assertTrue(flatmate.getRating().equals(rating));
		assertTrue(flatmate.getPhoneNumber().equals(number));

	}
	
	@Test
	public void testFlatmateEmptyConstructor() {
		
		EmailAddress email = new EmailAddress("g");
		CellNumber number = new CellNumber("2");
		Set<Double> rating = new HashSet<Double>();
		Set<String> habits = new HashSet<String>();
		rating.add(7.0);
		habits.add("reader");

		flatmate.setRating(rating);
		flatmate.setEmail(email);
		flatmate.setPhoneNumber(number);
		flatmate.setName("er");
		flatmate.setSurname("po");
		flatmate.setDescription("empty");
		flatmate.setUsername("valkerian");
		flatmate.setPassword("123");
		flatmate.setGender("Female");
		flatmate.setPets(false);
		flatmate.setAge(21);
		flatmate.setIncomingGuests(false);
		flatmate.setProfession(status.EMPLOYEE);
		flatmate.setRating(rating);
		flatmate.setHabits(habits);
		flatmate.setWorkSchedule("Monday-Saturday");
		

		assertTrue(flatmate.getUsername().equals("valkerian"));
		assertTrue(flatmate.getPassword().equals("123"));
		assertTrue(flatmate.getName().equals("er"));
		assertTrue(flatmate.getSurname().equals("po"));
		assertTrue(flatmate.getDescription().equals("empty"));
		assertTrue(flatmate.getGender().equals("Female"));
		assertTrue(flatmate.getProfession().equals(status.EMPLOYEE));
		assertEquals(flatmate.getAge(),21);
		assertFalse(flatmate.isPets());
		assertTrue(flatmate.getEmail().equals(email));
		assertTrue(flatmate.getWorkSchedule().equals("Monday-Saturday"));
		assertFalse(flatmate.isIncomingGuests());
		assertTrue(flatmate.getRating().equals(rating));
		assertTrue(flatmate.getPhoneNumber().equals(number));
		assertTrue(flatmate.getHabits().equals(habits));
		

	}
	
	

	
	@Test
	public void testAddCohabitRequest() {
		
		Flatmate flatmate = new Flatmate();
		CohabitRequest req1 = new CohabitRequest();
	    flatmate.addCohabitRequest(req1);
	    assertEquals(flatmate.getCohabitRequest().size(),1);
		
	}
	
	@Test
	public void testRemoveCohabitRequest() {
		
		Flatmate flatmate = new Flatmate();
		CohabitRequest req1 = new CohabitRequest();
	    flatmate.addCohabitRequest(req1);
	    flatmate.removeCohabitRequest(req1);
	    assertEquals(flatmate.getCohabitRequest().size(),0);
		
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
		assertEquals(flatmate.getCohabitRequest().size(),0);
		
	}
	
	@Test
	public void testRequestNotContains() {
		
		Flatmate flatmate = new Flatmate();
		HouseAd ad = new HouseAd();
		CohabitRequest corequest = new CohabitRequest();
		corequest = flatmate.request(ad);
		flatmate.cancelRequest(corequest);
		assertEquals(flatmate.getCohabitRequest().size(),0);

		
	}
	
	@Test
	public void testAddCohabitNull() {
		
		CohabitRequest corequest = null;
		flatmate.addCohabitRequest(corequest);
		assertEquals(flatmate.getCohabitRequest().size(),0);
		
	}
	
	@Test
	public void testRemoveCohabitNull() {
		
		CohabitRequest corequest = null;
		flatmate.addCohabitRequest(corequest);
		flatmate.removeCohabitRequest(corequest);
		assertEquals(flatmate.getCohabitRequest().size(),0);
		
	}
	
	@Test
	public void testValidateFields1() {
		
		EmailAddress email = new EmailAddress("g");
		CellNumber number = new CellNumber("2");
		flatmate.setPhoneNumber(number);
		flatmate.setEmail(email);
		assertTrue(flatmate.validateFields());
		
	}
	
	@Test
	public void testValidateFields2() {
		
		EmailAddress email = null;
		CellNumber number = new CellNumber("2");
		flatmate.setPhoneNumber(number);
		flatmate.setEmail(email);
		assertFalse(flatmate.validateFields());
		
	}
	
	@Test
	public void testValidateFields3() {
		
		EmailAddress email = new EmailAddress("g");
		CellNumber number = null;
		flatmate.setPhoneNumber(number);
		flatmate.setEmail(email);
		assertFalse(flatmate.validateFields());
		
	}
	
	@Test
	public void testValidateSuperFields() {
		flatmate.setName(null);
		assertFalse(flatmate.validateFields());
		
	}
	
	@Test
	public void testObjects() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		assertTrue(fl1.equals(fl2));
		
	}
	
	@Test
	public void testObject() {
		
		assertTrue(flatmate.equals(flatmate));
		
	}
	
	@Test
	public void testOtherObject() {
		
		Flatmate fl1 = new Flatmate();
		HouseAd ad1 = new HouseAd();
		assertFalse(fl1.equals(ad1));
		
	}
	
	@Test
	public void testNullObject() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = null;
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testCohabitReq1() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		CohabitRequest req1 = new CohabitRequest();
		CohabitRequest req2 = new CohabitRequest();
		fl1.addCohabitRequest(req1);
		fl2.addCohabitRequest(req2);
		assertFalse(flatmate.equals(fl2));
		
	}
	
	@Test
	public void testCohabitReq2() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		CohabitRequest req1 = null;
		CohabitRequest req2 = new CohabitRequest();
		fl1.addCohabitRequest(req1);
		fl2.addCohabitRequest(req2);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testCohabitReq3() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		CohabitRequest req2 = new CohabitRequest();
		fl1.addCohabitRequest(req2);
		fl2.addCohabitRequest(req2);
		assertTrue(fl1.equals(fl2));
		
	}
	
	@Test
	public void testCohabitReq4() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		HouseAd ad = new HouseAd();
		Date date = new Date(System.currentTimeMillis());
		CohabitRequest req2 = new CohabitRequest(flatmate,true,date,ad);
		CohabitRequest req1 = null;
		fl2.addCohabitRequest(req2);
		assertFalse(fl1.getCohabitRequest().equals(fl2.getCohabitRequest()));
		
	}
	
	@Test
	public void testDescription1() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		fl1.setDescription("empty2");
		fl2.setDescription("empty1");
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testDescription2() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		fl1.setDescription(null);
		fl2.setDescription("empty1");
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testDescription3() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		fl1.setDescription("empty1");
		fl2.setDescription("empty1");
		assertTrue(fl1.equals(fl2));
		
	}
	
	@Test
	public void testEmail1() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		EmailAddress email1 = new EmailAddress("gio1@aueb.gr");
		EmailAddress email2 = new EmailAddress("gio2@aueb.gr");
		fl1.setEmail(email1);
		fl2.setEmail(email2);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testEmail2() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		EmailAddress email1 = new EmailAddress("gio@aueb.gr");
		EmailAddress email2 = new EmailAddress("gio@aueb.gr");
		fl1.setEmail(email1);
		fl2.setEmail(email2);
		assertTrue(fl1.equals(fl2));
		
	}
	
	@Test
	public void testEmail3() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		EmailAddress email1 = null;
		EmailAddress email2 = new EmailAddress("gio@aueb.gr");
		fl1.setEmail(email1);
		fl2.setEmail(email2);
		assertFalse(fl1.equals(fl2));
		
	}
	
	
	@Test
	public void testGender1() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		String gender1 = "Male";
		String gender2 = "Female";
		fl1.setGender(gender1);
		fl2.setGender(gender2);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testGender2() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		String gender1 = "Male";
		String gender2 = "Male";
		fl1.setGender(gender1);
		fl2.setGender(gender2);
		assertTrue(fl1.equals(fl2));
		
	}
	
	@Test
	public void testGender3() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		String gender1 = null;
		String gender2 = "Male";
		fl1.setGender(gender1);
		fl2.setGender(gender2);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testHabits1() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		Set<String> habits1 = new HashSet<String>();
		Set<String> habits2 = new HashSet<String>();
		habits1.add("smoker");
		fl1.setHabits(habits1);
		fl2.setHabits(habits2);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testHabits2() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		Set<String> habits1 = new HashSet<String>();
		Set<String> habits2 = new HashSet<String>();
		fl1.setHabits(habits1);
		fl2.setHabits(habits1);
		assertTrue(fl1.equals(fl2));
		
	}
	
	@Test
	public void testHabits3() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		Set<String> habits1 = null;
		Set<String> habits2 = new HashSet<String>();
		fl1.setHabits(habits1);
		fl2.setHabits(habits2);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testIncomingGuests() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		fl1.setIncomingGuests(true);
		fl2.setIncomingGuests(false);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testPets() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		fl1.setPets(true);
		fl2.setPets(false);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testPhone1() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		CellNumber phone1 = new CellNumber("210123456");
		CellNumber phone2 = new CellNumber("210123457");
		fl1.setPhoneNumber(phone1);
		fl2.setPhoneNumber(phone2);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testPhone2() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		CellNumber phone1 = new CellNumber("210123456");
		CellNumber phone2 = new CellNumber("210123456");
		fl1.setPhoneNumber(phone1);
		fl2.setPhoneNumber(phone2);
		assertTrue(fl1.equals(fl2));
		
	}
	
	@Test
	public void testPhone3() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		CellNumber phone1 = null;
		CellNumber phone2 = new CellNumber("210123456");
		fl1.setPhoneNumber(phone1);
		fl2.setPhoneNumber(phone2);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testProfession() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		fl1.setProfession(status.STUDENT);
		fl2.setProfession(status.EMPLOYEE);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testRating1() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		Set<Double> rating1 = new HashSet<Double>();
		Set<Double> rating2 = new HashSet<Double>();
		rating1.add(9.0);
		fl1.setRating(rating1);
		fl2.setRating(rating2);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testRating2() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		Set<Double> rating1 = new HashSet<Double>();
		Set<Double> rating2 = new HashSet<Double>();
		fl1.setRating(rating1);
		fl2.setRating(rating2);
		assertTrue(fl1.equals(fl2));
		
	}
	
	@Test
	public void testRating3() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		Set<Double> rating1 = null;
		Set<Double> rating2 = new HashSet<Double>();
		fl1.setRating(rating1);
		fl2.setRating(rating2);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testScedule1() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		String schedule1 = "Monday-Friday";
		String schedule2 = "Monday-Saturday";
		fl1.setWorkSchedule(schedule1);
		fl2.setWorkSchedule(schedule2);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void testScedule2() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		String schedule1 = "Monday-Friday";
		String schedule2 = "Monday-Friday";
		fl1.setWorkSchedule(schedule1);
		fl2.setWorkSchedule(schedule2);
		assertTrue(fl1.equals(fl2));
		
	}
	
	@Test
	public void testScedule3() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		String schedule1 = null;
		String schedule2 = "Monday-Friday";
		fl1.setWorkSchedule(schedule1);
		fl2.setWorkSchedule(schedule2);
		assertFalse(fl1.equals(fl2));
		
	}
	
	@Test
	public void TestId1() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		fl1.setId(1L);
		assertTrue(fl1.equals(fl2));
		
	}
	
	@Test
	public void TestId2() {
		

		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		fl2.setId(1L);
		assertTrue(fl1.equals(fl2));
		
	}
	
	@Test
	public void TestId3() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		fl1.setId(2L);
		fl2.setId(1L);
		assertTrue(fl1.equals(fl2));
		
	}
	
	@Test
	public void TestId4() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		assertTrue(fl1.equals(fl2));
		
	}
	
	@Test
	public void TestGetId() {
		
		Flatmate fl1 = new Flatmate();
		fl1.setId(2L);
		assertEquals(fl1.getId(),2L);
	}
	

}
