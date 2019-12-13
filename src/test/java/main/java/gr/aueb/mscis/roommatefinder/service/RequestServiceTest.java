package main.java.gr.aueb.mscis.roommatefinder.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.House;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.persistence.Initializer;

public class RequestServiceTest extends RoommateServiceTest {

	@Test
	public void testfindAllHouseAds() {
		RequestService service = new RequestService(em);
		List<HouseAd> houseAds = service.findAllHouseAds();
		
		assertNotNull(houseAds);
		assertEquals(1, houseAds.size());
	
	}
	
	@Test
	public void testfindAllHouseAdsWithHouse() {
		RequestService service = new RequestService(em);
		List<House> houseAds = service.findAllHouseAdsWithHouse(Initializer.resident1_id);
		
		assertNotNull(houseAds);
		assertEquals(1, houseAds.size());
	
	}
	
	
	@Test
	public void testcreateRequest() {
		RequestService service = new RequestService(em);
		Boolean created= service.createRequest(Initializer.house_Adid, Initializer.flatmate_id);
		assertTrue(created);
	}
	
	@Test
	public void testfindFlatmate() {
		RequestService service = new RequestService(em);
		Flatmate flatmate = service.findFlatmateById(Initializer.flatmate_id);
		
		assertNotNull(flatmate);
		
	}
	
	@Test
	public void testfindRequest() {
		RequestService service = new RequestService(em);
		CohabitRequest request = service.findCohabitRequestById(Initializer.cohabitrequest_id);
		
		assertNotNull(request);
		
	}
	
	
	@Test
	public void tesDeleteRequest() {
		RequestService service = new RequestService(em);
		Boolean deleted = service.cancelRequest(Initializer.cohabitrequest_id);
		
		assertTrue(deleted);;
		
		
	}

}
