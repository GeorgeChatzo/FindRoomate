package main.java.gr.aueb.mscis.roomatefinder.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Cohabitance;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.House;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.RequestState;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.model.status;

public class ResidentTest {
	
	Resident res;
	EmailAddress email;
	CellNumber number;
	Set<String> prefHabits;
	Set<Double> rating;
	
	@Before
	public void setUp() {
		
		prefHabits = new HashSet<String>();
		email = new EmailAddress("g");
		number = new CellNumber("2");
		rating = new HashSet<Double>();
		res = new Resident("GChatz","qwerty123",email,number,"George","Chatzopoulos"
				,22,2,34,prefHabits,true,"Everyday",status.STUDENT,false,"Female",rating);
		
	}
	
	@Test
	public void ConstructRes() {
		
		Set<Double> rating = new HashSet<Double>();
		EmailAddress email = new EmailAddress("g");
		CellNumber number = new CellNumber("2");
		res.setRating(rating);
		res.setEmail(email);
		res.setPhoneNumber(number);
		assertTrue(res.getUsername().equals("GChatz"));
		assertTrue(res.getPassword().equals("qwerty123"));
		assertTrue(res.getEmail().equals(email));
		assertTrue(res.getPhoneNumber().equals(number));
		assertTrue(res.getName().equals("George"));
		assertTrue(res.getSurname().equals("Chatzopoulos"));
		assertTrue(res.getAge()==22);
		assertTrue(res.getNumOfFlatmates()==2);
		assertTrue(res.getAgeRange()==34);
		assertTrue(res.getPreferedHabits().equals(prefHabits));
		assertTrue(res.isPetRule()==true);
		assertTrue(res.getPreferedWorkSchedule().equals("Everyday"));
		assertTrue(res.getPreferedProfession().equals(status.STUDENT));
		assertTrue(res.getGenderChoice()=="Female");
		assertTrue(res.getRating().equals(rating));
		assertTrue(res.isGuests()==false);
	}
	
	@Test
	public void testResEmptyConstructor() {
		
		EmailAddress email = new EmailAddress("g");
		CellNumber number = new CellNumber("2");
		Set<Double> rating = new HashSet<Double>();
		Set<String> prefHabits = new HashSet<String>();
		rating.add(7.0);
		prefHabits.add("reader");

		res.setRating(rating);
		res.setEmail(email);
		res.setPhoneNumber(number);
		res.setName("er");
		res.setSurname("po");
		res.setUsername("valkerian");
		res.setPassword("123");
		res.setGenderChoice("Female");
		res.setPetRule(false);
		res.setAge(21);
		res.setGuests(false);
		res.setPreferedProfession(status.EMPLOYEE);
		res.setPreferedHabits(prefHabits);
		res.setPreferedWorkSchedule("Monday-Saturday");
		res.setNumOfFlatmates(3);
		res.setAgeRange(40);
		

		assertTrue(res.getUsername().equals("valkerian"));
		assertTrue(res.getPassword().equals("123"));
		assertTrue(res.getEmail().equals(email));
		assertTrue(res.getPhoneNumber().equals(number));
		assertTrue(res.getName().equals("er"));
		assertTrue(res.getSurname().equals("po"));
		assertTrue(res.getAge()==21);
		assertTrue(res.getNumOfFlatmates()==3);
		assertTrue(res.getAgeRange()==40);
		assertTrue(res.getPreferedHabits().equals(prefHabits));
		assertTrue(res.isPetRule()==false);
		assertTrue(res.getPreferedWorkSchedule().equals("Monday-Saturday"));
		assertTrue(res.getPreferedProfession().equals(status.EMPLOYEE));
		assertTrue(res.getGenderChoice()=="Female");
		assertTrue(res.getRating().equals(rating));
		assertTrue(res.isGuests()==false);

	}
	
	@Test
	public void testSuperConstr() {
		
		EmailAddress email = new EmailAddress("g");
		CellNumber number = new CellNumber("2");
		Set<Double> rating = new HashSet<Double>();
		Set<String> prefHabits = new HashSet<String>();
		rating.add(7.0);
		prefHabits.add("reader");
		Resident res = new Resident("GChatz","qwerty123",email,number,"George","Chatzopoulos",22,
				rating);
		res.setEmail(email);
		res.setPhoneNumber(number);
		res.setRating(rating);
		assertTrue(res.getUsername().equals("GChatz"));
		assertTrue(res.getPassword().equals("qwerty123"));
		assertTrue(res.getEmail().equals(email));
		assertTrue(res.getPhoneNumber().equals(number));
		assertTrue(res.getAge()==22);
		assertTrue(res.getRating().equals(rating));
		
	}
	
	@Test
	public void testEmptySuper() {
		
		Resident res = new Resident();
		assertNull(res.getUsername());
		assertNull(res.getPassword());
		assertNull(res.getName());
		assertNull(res.getSurname());
		assertTrue(res.getAge()==0);
		
	}
	
	@Test
	public void testAddHouse() {
		
		HouseAd ad = new HouseAd();
		res.addHouseAd(ad);
		assertTrue(res.getHouseAds().size()==1);
		
	}
	
	@Test
	public void testAddHouseNull() {
		
		HouseAd ad = null;
		res.addHouseAd(ad);
		assertTrue(res.getHouseAds().size()==0);
		
	}
	
	@Test
	public void testRemoveHouse() {
		
		HouseAd ad1 = new HouseAd();
		HouseAd ad2 = new HouseAd();
		HouseAd ad3 = new HouseAd();
		res.addHouseAd(ad1);
		res.addHouseAd(ad2);
		res.addHouseAd(ad3);
		res.removeHouseAd(ad1);
		assertTrue(res.getHouseAds().size()==2);
		
	}
	
	@Test
	public void testRemoveHouseNull() {
		
		HouseAd ad1 = null;
		res.addHouseAd(ad1);
		res.removeHouseAd(ad1);
		assertTrue(res.getHouseAds().size()==0);
		
	}
	
	@Test
	public void testAcceptRequest() {
		
		Cohabitance coh = new Cohabitance();
		CohabitRequest req = new CohabitRequest();
		Date startDate = new Date(201823);
		Date endDate = new Date(201892);
		res.acceptRequest(coh, req, startDate, endDate);
		assertTrue(req.getState().equals(RequestState.ACCEPTED));
		assertTrue(coh.getConnection()==true);
		assertTrue(coh.getStartDate().equals(startDate));
		assertTrue(coh.getEndDate().equals(endDate));

	}
	
	@Test
	public void testRejectRequest() {
		
		CohabitRequest req = new CohabitRequest();
		res.rejectRequest(req);
		assertTrue(req.getState().equals(RequestState.REJECTED));
		
	}
	
	@Test
	public void testValidateFields1() {
		
		EmailAddress email = new EmailAddress("g");
		CellNumber number = new CellNumber("2");
		res.setNumOfFlatmates(2);
		res.setPhoneNumber(number);
		res.setEmail(email);
		assertTrue(res.validateFields()==true);
		
	}
	
	@Test
	public void testValidateFields2() {
		
		EmailAddress email = null;
		CellNumber number = new CellNumber("2");
		res.setPhoneNumber(number);
		res.setEmail(email);
		assertTrue(res.validateFields()==false);
		
	}
	
	@Test
	public void testValidateFields3() {
		
		EmailAddress email = new EmailAddress("g");
		CellNumber number = null;
		res.setPhoneNumber(number);
		res.setEmail(email);
		assertTrue(res.validateFields()==false);
		
	}
	
	@Test
	public void testValidateFields4() {
		
		EmailAddress email = new EmailAddress("g");
		CellNumber number = new CellNumber("2");
		res.setNumOfFlatmates(-1);
		res.setPhoneNumber(number);
		res.setEmail(email);
		assertTrue(res.validateFields()==false);
		
	}
	
	@Test
	public void TestHouse() {
		
		House ad = new House();
		res.setHouse(ad);
		assertTrue(res.getHouse().equals(ad));
		
	}
	
	@Test
	public void TestToString() {
		HouseAd ad = new HouseAd();
		String expected = "Resident [id=null, house=null, cohabitRequests=, numOfFlatmates=2, ageRange=34, preferedHabits=[], petRule=true, preferedWorkSchedule=Everyday, preferedProfession=STUDENT, guests=false, genderChoice=Female, rating=null, email=null, phoneNumber=null]";
		assertTrue(res.toString().equals(expected));

	}
	
	@Test
	public void testObjects() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		assertTrue(res1.equals(res2));
		
	}
	
	@Test
	public void testObject() {
		
		assertTrue(res.equals(res));
		
	}
	
	@Test
	public void testOtherObject() {
		
		Resident res1 = new Resident();
		HouseAd ad1 = new HouseAd();
		assertFalse(res1.equals(ad1));
		
	}
	
	@Test
	public void testNullObject() {
		
		Resident res1 = new Resident();
		Resident res2 = null;
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testAgeRange() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setAgeRange(50);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testGuests() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setGuests(false);
		res2.setGuests(true);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testNumOfFlatmates() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setNumOfFlatmates(0);
		res2.setNumOfFlatmates(2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testPetRule() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setPetRule(true);
		res2.setPetRule(false);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testPreferedProf() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setPreferedProfession(status.EMPLOYEE);
		res2.setPreferedProfession(status.STUDENT);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testEmail1() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		EmailAddress email1 = new EmailAddress("gio1@aueb.gr");
		EmailAddress email2 = new EmailAddress("gio2@aueb.gr");
		res1.setEmail(email1);
		res2.setEmail(email2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testEmail2() {
		

		Resident res1 = new Resident();
		Resident res2 = new Resident();
		EmailAddress email1 = new EmailAddress("gio@aueb.gr");
		EmailAddress email2 = new EmailAddress("gio@aueb.gr");
		res1.setEmail(email1);
		res2.setEmail(email2);
		assertTrue(res1.equals(res2));
		
	}
	
	@Test
	public void testEmail3() {
		

		Resident res1 = new Resident();
		Resident res2 = new Resident();
		EmailAddress email1 = null;
		EmailAddress email2 = new EmailAddress("gio@aueb.gr");
		res1.setEmail(email1);
		res2.setEmail(email2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testHabits1() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		Set<String> habits1 = new HashSet<String>();
		Set<String> habits2 = new HashSet<String>();
		habits1.add("smoker");
		res1.setPreferedHabits(habits1);
		res2.setPreferedHabits(habits2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testHabits2() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		Set<String> habits1 = new HashSet<String>();
		Set<String> habits2 = new HashSet<String>();
		res1.setPreferedHabits(habits1);
		res2.setPreferedHabits(habits1);
		assertTrue(res1.equals(res2));
		
	}
	
	@Test
	public void testHabits3() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		Set<String> habits1 = null;
		Set<String> habits2 = new HashSet<String>();
		res1.setPreferedHabits(habits1);
		res2.setPreferedHabits(habits2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testScedule1() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		String schedule1 = "Monday-Friday";
		String schedule2 = "Monday-Saturday";
		res1.setPreferedWorkSchedule(schedule1);
		res2.setPreferedWorkSchedule(schedule2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testScedule2() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		String schedule1 = "Monday-Friday";
		String schedule2 = "Monday-Friday";
		res1.setPreferedWorkSchedule(schedule1);
		res2.setPreferedWorkSchedule(schedule2);
		assertTrue(res1.equals(res2));
		
	}
	
	@Test
	public void testScedule3() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		String schedule1 = null;
		String schedule2 = "Monday-Friday";
		res1.setPreferedWorkSchedule(schedule1);
		res2.setPreferedWorkSchedule(schedule2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testPhone1() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		CellNumber phone1 = new CellNumber("210123456");
		CellNumber phone2 = new CellNumber("210123457");
		res1.setPhoneNumber(phone1);
		res2.setPhoneNumber(phone2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testPhone2() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		CellNumber phone1 = new CellNumber("210123456");
		CellNumber phone2 = new CellNumber("210123456");
		res1.setPhoneNumber(phone1);
		res2.setPhoneNumber(phone2);
		assertTrue(res1.equals(res2));
		
	}
	
	@Test
	public void testPhone3() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		CellNumber phone1 = null;
		CellNumber phone2 = new CellNumber("210123456");
		res1.setPhoneNumber(phone1);
		res2.setPhoneNumber(phone2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testRating1() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		Set<Double> rating1 = new HashSet<Double>();
		Set<Double> rating2 = new HashSet<Double>();
		rating1.add(9.0);
		res1.setRating(rating1);
		res2.setRating(rating2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testRating2() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		Set<Double> rating1 = new HashSet<Double>();
		Set<Double> rating2 = new HashSet<Double>();
		res1.setRating(rating1);
		res2.setRating(rating2);
		assertTrue(res1.equals(res2));
		
	}
	
	@Test
	public void testRating3() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		Set<Double> rating1 = null;
		Set<Double> rating2 = new HashSet<Double>();
		res1.setRating(rating1);
		res2.setRating(rating2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testGender1() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		String gender1 = "Male";
		String gender2 = "Female";
		res1.setGenderChoice(gender1);
		res2.setGenderChoice(gender2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void testGender2() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		String gender1 = "Male";
		String gender2 = "Male";
		res1.setGenderChoice(gender1);
		res2.setGenderChoice(gender2);
		assertTrue(res1.equals(res2));
		
	}
	
	@Test
	public void testGender3() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		String gender1 = null;
		String gender2 = "Male";
		res1.setGenderChoice(gender1);
		res2.setGenderChoice(gender2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void TestId1() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setId(1L);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void TestId2() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res2.setId(1L);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void TestId3() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setId(2L);
		res2.setId(1L);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void TestId4() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		assertTrue(res1.equals(res2));
		
	} 
	
	@Test
	public void TestId5() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setId(1L);
		res2.setId(1L);
		assertTrue(res1.equals(res2));
		
	} 
	
	@Test
	public void TestgetId() {
		
		Resident res1 = new Resident();
		res1.setId(1L);
		assertTrue(res1.getId()==1L);
	}
	
	
	@Test
	public void TestHouseEquals1() {
		
		House house1 = new House();
		House house2 = null;
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setHouse(house2);
		res2.setHouse(house1);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void TestHouseEquals2() {
		
		House house1 = new House();
		House house2 = new House();
		house1.setCity("Athens");
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setHouse(house2);
		res2.setHouse(house1);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void TestHouseEquals3() {
		
		House house1 = new House();
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setHouse(house1);
		res2.setHouse(house1);
		assertTrue(res1.equals(res2));
		
	}
	
	@Test
	public void TestHouseAds1() {
		
		HouseAd ad1 = new HouseAd();
		HouseAd ad2 = new HouseAd();
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.addHouseAd(ad1);
		res2.addHouseAd(ad2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void TestHouseAds2() {
		
		HouseAd ad1 = new HouseAd();
		HouseAd ad2 = new HouseAd();
		ad2.setName("spiti");
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.addHouseAd(null);
		res2.addHouseAd(ad2);
		assertFalse(res1.equals(res2));
		
	}
	
	@Test
	public void TestHashCode1() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setAgeRange(23);
		res2.setAgeRange(23);
		assertTrue(res1.hashCode() == res2.hashCode());
		
	}
	
	@Test
	public void TestHashCode2() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		EmailAddress email1 = new EmailAddress("gio1@aueb.gr");
		res1.setEmail(email1);
		res2.setEmail(email1);
		assertTrue(res1.hashCode() == res2.hashCode());
		
	}
	
	@Test
	public void TestHashCode3() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setGenderChoice("Male");
		res2.setGenderChoice("Male");
		assertTrue(res1.hashCode() == res2.hashCode());
		
	}
	
	@Test
	public void TestHashCode4() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setGuests(true);
		res2.setGuests(true);
		assertTrue(res1.hashCode() == res2.hashCode());
		
	}
	
	@Test
	public void TestHashCode5() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		House h = new House();
		res1.setHouse(h);
		res2.setHouse(h);
		assertTrue(res1.hashCode() == res2.hashCode());
		
	}
	
	@Test
	public void TestHashCode6() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		HouseAd ad = new HouseAd();
		res1.addHouseAd(ad);
		res2.addHouseAd(ad);
		assertTrue(res1.hashCode() == res2.hashCode());
		
	}
	
	@Test
	public void TestHashCode7() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setId(1L);
		res2.setId(1L);
		assertTrue(res1.hashCode() == res2.hashCode());
		
	}
	
	@Test
	public void TestHashCode8() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setPetRule(true);
		res2.setPetRule(true);
		assertTrue(res1.hashCode() == res2.hashCode());
		
	}
	
	@Test
	public void TestHashCode9() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		CellNumber number = new CellNumber("2");
		res1.setPhoneNumber(number);
		res2.setPhoneNumber(number);
		assertTrue(res1.hashCode() == res2.hashCode());
		
	}
	
	@Test
	public void TestHashCode10() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		Set<String> prefHabits = new HashSet<String>();
		res1.setPreferedHabits(prefHabits);
		res2.setPreferedHabits(prefHabits);
		assertTrue(res1.hashCode() == res2.hashCode());
		
	}
	
	@Test
	public void TestHashCode11() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setPreferedProfession(status.EMPLOYEE);
		res2.setPreferedProfession(status.EMPLOYEE);
		assertTrue(res1.hashCode() == res2.hashCode());
		
	}
	
	@Test
	public void TestHashCode12() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		
		res1.setPreferedWorkSchedule("sc");
		res2.setPreferedWorkSchedule("sc");
		assertTrue(res1.hashCode() == res2.hashCode());
		
	}


	@Test
	public void TestHashCode13() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident();
		res1.setRating(rating);
		res2.setRating(rating);
		assertTrue(res1.hashCode() == res2.hashCode());
		
	}
	
	

}
