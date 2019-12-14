package main.java.gr.aueb.mscis.roommatefinder.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.House;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.persistence.Initializer;

public class PublishAdServiceTest extends RoommateServiceTest {

	@Test
	public void testfindAdsOfResident() {
		PublishAdService service = new PublishAdService(em);
		List<HouseAd> houseAds = service.findAdsOfResident(Initializer.resident1_id);
		
		assertNotNull(houseAds);
		assertEquals(1, houseAds.size());
	}
	
	@Test
	public void testFindAllFlatmates() {
		PublishAdService service = new PublishAdService(em);
		List<Flatmate> flatmates = service.findAllFlatmates();
		
		assertNotNull(flatmates);
		assertEquals(1, flatmates.size());
		
	}
	
	@Test
	public void testcreateHouse() {
		PublishAdService service = new PublishAdService(em);
		House house = new House("Greece","Athens","Kipesli",2222,"Diamerisma",3,false,115,true,true,1,5,1995,"Hlketrikos");
		boolean created = service.createHouse(house);
		
		assertTrue(created);
	}
	
	@Test
	public void testNullcreateHouse() {
		PublishAdService service = new PublishAdService(em);
		House house = new House(null,null,null,2222,"Diamerisma",3,false,115,true,true,1,5,1995,"Hlketrikos");
		boolean created = service.createHouse(house);
		
		assertFalse(created);
	}
	
	@Test
	public void testDeleteHouse() {
		PublishAdService service = new PublishAdService(em);
		boolean deleted = service.deleteHouse(Initializer.house_id);
		
		assertTrue(deleted);
	}
	
	@Test
	public void testDeleteNonExistantHouse() {
		PublishAdService service = new PublishAdService(em);
		boolean deleted = service.deleteHouse(8L);
		
		assertFalse(deleted);
	}
	
	//HouseAd
	@Test
	public void testcreateHouseAd() {
		PublishAdService service = new PublishAdService(em);
		HouseAd houseAd = new HouseAd("Fovero","New house at Galatsi",500.0,"GeorgeChatzo/photos/eikona1.jpg","Neodmito spiti diamperes",2); 
		boolean created = service.createHouseAd(houseAd);
		
		assertTrue(created);
	}
	
	@Test
	public void testNullcreateHouseAd() {
		PublishAdService service = new PublishAdService(em);
		HouseAd houseAd = new HouseAd(null,null,500.0,"GeorgeChatzo/photos/eikona1.jpg","Neodmito spiti diamperes",2); 
		boolean created = service.createHouseAd(houseAd);
		
		assertFalse(created);
	}
	
	@Test
	public void testDeleteHouseAd() {
		PublishAdService service = new PublishAdService(em);
		boolean deleted = service.deleteHouseAd(Initializer.house_Adid);
		
		assertTrue(deleted);
	}
	
	@Test
	public void testDeleteNonExistantHouseAd() {
		PublishAdService service = new PublishAdService(em);
		boolean deleted = service.deleteHouseAd(8L);
		
		assertFalse(deleted);
	}
	
	
	
	@Test
	public void testfindHouse() {
		PublishAdService service = new PublishAdService(em);
		House house = service.findHouseById(Initializer.house_id);
		
		assertNotNull(house);
		
	}
	
	@Test
	public void testfindHouseAd() {
		PublishAdService service = new PublishAdService(em);
		HouseAd houseAd = service.findHouseAdById(Initializer.house_Adid);
		
		assertNotNull(houseAd);
		
	}
	
	

}
