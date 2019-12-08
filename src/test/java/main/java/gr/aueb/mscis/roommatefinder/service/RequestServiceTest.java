package main.java.gr.aueb.mscis.roommatefinder.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;

public class RequestServiceTest extends RoommateServiceTest {

	@Test
	public void testfindAllHouseAds() {
		RequestService service = new RequestService(em);
		List<HouseAd> houseAds = service.findAllHouseAds();
		
		assertNotNull(houseAds);
		assertEquals(1, houseAds.size());
	
	}

}
