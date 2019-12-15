package main.java.gr.aueb.mscis.roomatefinder.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.House;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.RequestState;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;

public class HouseAdTest {
	
	HouseAd ad1;
	HouseAd ad2;
	
	@Before
	public void setUp() {
		
		String name = "Aggelia";
		String description = "Enoikiazetai spiti";
		double rentPrice = 340.0;
		String photos = "GeorgeChatzo/photo.jpg";
		String comments = "euaero";
		int numberOfRoomates = 2;
		
		ad1 = new HouseAd(name,description,rentPrice,photos,comments,numberOfRoomates);
		ad2 = new HouseAd(name,description,rentPrice,photos,comments,numberOfRoomates);
	
	}
	
	
	@Test
	public void TestConstructor() {
		
		String name = "Aggelia";
		String description = "Enoikiazetai spiti";
		double rentPrice = 340.0;
		String photos = "GeorgeChatzo/photo.jpg";
		String comments = "euaero";
		int numberOfRoomates = 2;
		
		assertTrue(ad1.getName().equals(name));
		assertTrue(ad1.getDescription().equals(description));
		assertTrue(ad1.getRentPrice()==rentPrice);
		assertTrue(ad1.getPhotos().equals(photos));
		assertTrue(ad1.getComments().equals(comments));
		assertTrue(ad1.getNumberOfRoommates()==numberOfRoomates);
		
	}
	
	@Test
	public void TestEmptyConstructor() {
		
		HouseAd ad = new HouseAd();
		
		ad.setName("agg");
		ad.setDescription("empty");
		ad.setRentPrice(0.0);
		ad.setPhotos("C:/Images");
		ad.setComments("empty");
		ad.setNumberOfRoommates(0);
		
		assertTrue(ad.getName().equals("agg"));
		assertTrue(ad.getDescription().equals("empty"));
		assertTrue(ad.getRentPrice()==0.0);
		assertTrue(ad.getPhotos().equals("C:/Images"));
		assertTrue(ad.getComments().equals("empty"));
		assertTrue(ad.getNumberOfRoommates()==0);
		
	}
	
	
	@Test
	public void TestResident() {
		
		Resident res = new Resident();
		HouseAd ad = new HouseAd();
		ad.setResident(res);
		assertTrue(ad.getResident().equals(res));
		
	}
	
	@Test
	public void testEqualsObjects() {
		
		assertTrue(ad1.equals(ad2));
		
	}
	
	@Test
	public void testEqualsObject() {
		
		assertTrue(ad1.equals(ad1));
		
	}
	
	@Test
	public void testEqualsOtherClassObject() {
		House house = new House();
		assertFalse(ad1.equals(house));
		
	}
	
	@Test
	public void testNullObject() {
		
		HouseAd ad = null;
		assertFalse(ad1.equals(ad));
		
	}
	
	@Test
	public void TestId1() {
		
		ad1.setId(1L);
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestId2() {
		
		ad2.setId(1L);
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestId3() {
		
		ad1.setId(2L);
		ad2.setId(1L);
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestId4() {
		
		assertTrue(ad1.equals(ad2));
		
	} 
	
	@Test
	public void TestId5() {
		ad1.setId(1L);
		ad2.setId(1L);
		assertTrue(ad1.equals(ad2));
		
	} 
	
	@Test
	public void TestgetId() {
		
		ad1.setId(1L);
		assertTrue(ad1.getId()==1L);
	}
	
	@Test
	public void TestDescription1() {
		
		ad2.setDescription(null);
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestDescription2() {
		
		ad1.setDescription(null);
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestDescription3() {
		
		ad2.setDescription("Description");
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestDescription4() {
		
		ad2.setDescription(null);
		ad1.setDescription(null);
		assertTrue(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestComments1() {
		
		ad2.setComments(null);
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestComments2() {
		
		ad1.setComments(null);
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestComments3() {
		
		ad2.setComments("Description");
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestComments4() {
		
		ad2.setComments(null);
		ad1.setComments(null);
		assertTrue(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestName1() {
		
		ad2.setName(null);
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestName2() {
		
		ad1.setName(null);
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestName3() {
		
		ad2.setName("Spiti");
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestName4() {
		
		ad2.setName(null);
		ad1.setName(null);
		assertTrue(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestPhoto1() {
		
		ad2.setPhotos(null);
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestPhoto2() {
		
		ad1.setPhotos(null);
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestPhoto3() {
		
		ad2.setPhotos("C:/Images/Desktop");
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestPhoto4() {
		
		ad2.setPhotos(null);
		ad1.setPhotos(null);
		assertTrue(ad1.equals(ad2));
		
	}
	
	@Test 
	public void TestNumberOfRoomates() {
		ad1.setNumberOfRoommates(1);
		ad2.setNumberOfRoommates(2);
		assertFalse(ad1.equals(ad2));
	}
	
	@Test 
	public void TestRentPrice() {
		ad1.setRentPrice(100.0);
		assertFalse(ad1.equals(ad2));
	}
	
	@Test 
	public void TestResidentEquals1() {
		
		Resident res1 = new Resident();
		Resident res2 = new Resident(); 
		ad1.setResident(res1);
		ad2.setResident(res2);
		assertTrue(ad1.equals(ad2));
		
	}
	
	@Test
	public void TestResidentEquals2() {
		
		Resident res1 = new Resident();
		ad1.setResident(res1);
		assertFalse(ad1.equals(ad2));
		
	}
	
	@Test 
	public void TestResidentEquals3() {
		
		Resident res1 = null;
		Resident res2 = new Resident(); 
		ad1.setResident(res1);
		ad2.setResident(res2);
		assertFalse(ad1.equals(ad2));
		
	}
	
	
	@Test
	public void testToString() {
		
		String name = "Aggelia";
		String description = "Enoikiazetai spiti";
		double rentPrice = 340.0;
		String photos = "GeorgeChatzo/photo.jpg";
		String comments = "euaero";
		int numberOfRoomates = 2;
		HouseAd ad = new HouseAd(name,description,rentPrice,photos,comments,numberOfRoomates);
		String expected = "HouseAd [id=0, resident=null, description=Enoikiazetai spiti, rentPrice=340.0, photos=GeorgeChatzo/photo.jpg, comments=euaero, numberOfRoommates=2]";
		Assert.assertEquals(ad.toString(),expected);
	}
	
	

	
	
	
	

}
