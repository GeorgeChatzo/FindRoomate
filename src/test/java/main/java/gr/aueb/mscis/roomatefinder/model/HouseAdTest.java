package main.java.gr.aueb.mscis.roomatefinder.model;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.RequestState;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;

public class HouseAdTest {
	
	
	@Test
	public void TestConstructor() {
		
		String name = "Aggelia";
		String description = "Enoikiazetai spiti";
		double rentPrice = 340.0;
		String photos = "GeorgeChatzo/photo.jpg";
		String comments = "euaero";
		int numberOfRoomates = 2;
		
		HouseAd ad = new HouseAd(name,description,rentPrice,photos,comments,numberOfRoomates);
		assertTrue(ad.getName().equals(name));
		assertTrue(ad.getDescription().equals(description));
		assertTrue(ad.getRentPrice()==rentPrice);
		assertTrue(ad.getPhotos().equals(photos));
		assertTrue(ad.getComments().equals(comments));
		assertTrue(ad.getNumberOfRoommates()==numberOfRoomates);
		
	}
	
	@Test
	public void TestEmptyConstructor() {
		
		HouseAd ad = new HouseAd();
		assertNull(ad.getName());
		assertNull(ad.getDescription());
		assertTrue(ad.getRentPrice()==0.0);
		assertNull(ad.getPhotos());
		assertNull(ad.getComments());
		assertTrue(ad.getNumberOfRoommates()==0);
		
	}
	
	@Test
	public void TestSetters() {
		
		String name = "Aggelia";
		String description = "Enoikiazetai spiti";
		double rentPrice = 340.0;
		String photos = "GeorgeChatzo/photo.jpg";
		String comments = "euaero";
		int numberOfRoomates = 2;
		
		HouseAd ad = new HouseAd(name,description,rentPrice,photos,comments,numberOfRoomates);
		
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
	public void testEquals() {
		
		String name = "Aggelia";
		String description = "Enoikiazetai spiti";
		double rentPrice = 340.0;
		String photos = "GeorgeChatzo/photo.jpg";
		String comments = "euaero";
		int numberOfRoomates = 2;
		HouseAd HouseAd1 = new HouseAd();
		HouseAd HouseAd2 = new HouseAd();
		HouseAd1.setName(name);
		HouseAd1.setDescription(description);;
		HouseAd1.setRentPrice(rentPrice);
		HouseAd1.setPhotos(photos);
		HouseAd1.setComments(comments);
		HouseAd1.setNumberOfRoommates(numberOfRoomates);
		HouseAd2.setName(name);
		HouseAd2.setDescription(description);;
		HouseAd2.setRentPrice(rentPrice);
		HouseAd2.setPhotos(photos);
		HouseAd2.setComments(comments);
		HouseAd2.setNumberOfRoommates(numberOfRoomates);
		assertTrue(HouseAd1.equals(HouseAd2));
		
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
		String expected = "HouseAd [id=null, resident=null, description=Enoikiazetai spiti, rentPrice=340.0, photos=GeorgeChatzo/photo.jpg, comments=euaero, numberOfRoommates=2]";
		Assert.assertEquals(ad.toString(),expected);
	}

	
	
	
	

}
