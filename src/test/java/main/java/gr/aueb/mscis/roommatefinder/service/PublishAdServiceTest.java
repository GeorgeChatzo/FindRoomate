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
