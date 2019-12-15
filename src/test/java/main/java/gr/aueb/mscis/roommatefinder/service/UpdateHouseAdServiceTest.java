package main.java.gr.aueb.mscis.roommatefinder.service;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.House;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.persistence.Initializer;

public class UpdateHouseAdServiceTest extends RoommateServiceTest {

	@Test
	public void testUpdateHouseAd() {
		UpdateHouseAdService service = new UpdateHouseAdService(em);
		
		boolean updatedAd = service.updateHouseAd("Fovero","New house at Kypseli",500.0,"GeorgeChatzo/photos/eikona1.jpg","Neodmito spiti diamperes",
				2, Initializer.house_Adid, Initializer.resident1_id);
		
		assertTrue(updatedAd);
	}
	
	@Test
	public void testUpdateWrongFieldsHouseAd() {
		UpdateHouseAdService service = new UpdateHouseAdService(em);
		
		boolean updatedAd = service.updateHouseAd(null,null,0,"GeorgeChatzo/photos/eikona1.jpg","Neodmito spiti diamperes",
				2, Initializer.house_Adid, Initializer.resident1_id);
		
		assertFalse(updatedAd);
	}
	
	@Test
	public void testUpdateHouse() {
		UpdateHouseAdService service = new UpdateHouseAdService(em);
		
		boolean updateHouse = service.updateHouse("Greece","Athens","Kypseli",1111,"Diamerisma",3,false,115,true,true,
				1,5,1995,"Hlketrikos",Initializer.house_id, Initializer.resident1_id);
		
		
		assertTrue(updateHouse);
		
	}
	
	@Test
	public void testUpdateWrongFieldsHouse() {
		UpdateHouseAdService service = new UpdateHouseAdService(em);
		
		boolean updateHouse = service.updateHouse(null,null,null,1111,"Diamerisma",3,false,115,true,true,
				1,5,1995,"Hlketrikos",Initializer.house_id, Initializer.resident1_id);
		
		
		assertFalse(updateHouse);
		
	}
	
	
	@Test
	public void testSelectHouseAd() {
		UpdateHouseAdService service = new UpdateHouseAdService(em);
		
		HouseAd houseAd = service.selectHouseAd(Initializer.house_Adid, Initializer.resident1_id);
		
		assertNotNull(houseAd);
		
	}
	
	@Test
	public void testSelectHouse() {
		UpdateHouseAdService service = new UpdateHouseAdService(em);
		
		House house = service.selectHouse(Initializer.house_id, Initializer.resident1_id);
		
		assertNotNull(house);
		
	}
	
	

}
