package main.java.gr.aueb.mscis.roommatefinder.resource;

import static org.junit.Assert.*;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.persistence.Initializer;

import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.HOUSEADS;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.houseAdIdUri;

public class HouseAdResourceTest extends RoommateResourceTest {
	
	@Override
	protected Application configure() {

		return new ResourceConfig(HouseAdResource.class, DebugExceptionMapper.class);
	}


	@Test
	public void testListAllHouseAds() {

		List<HouseAdInfo> houseAds = target(HOUSEADS).request()
				.get(new GenericType<List<HouseAdInfo>>() {});
		assertEquals(1, houseAds.size());
	}

	@Test
	public void testListHouseAdbyID() {

		List<HouseAdInfo> houseAds = target(HOUSEADS).request()
				.get(new GenericType<List<HouseAdInfo>>() {});
		
		String houseAdId = Long.toString(houseAds.get(0).getId());
		
		HouseAdInfo houseAd = target(houseAdIdUri(houseAdId)).request().get(HouseAdInfo.class);
		
		assertNotNull(houseAd);
		assertEquals("super",houseAd.getName());
		
	}
	
	@Test
	public void createNewHouseAd() {
		List<Resident> residents = listResidents();
		assertEquals(1, residents.size());
		Resident resident = residents.get(0);
		
		HouseAdInfo advertisment = new HouseAdInfo("superNew","New house at Galatsi",500.0,
				"GeorgeChatzo/photos/eikona1.jpg","Neodmito spiti diamperes",2,resident.getId());
		Response response = target(HOUSEADS).request().post(Entity.entity(advertisment, MediaType.APPLICATION_JSON));
		
		assertEquals(201, response.getStatus());
		List<HouseAd> allHouseAds = listAllHouseAds();
		assertEquals(1, allHouseAds.size());
		
	}
	
	@Test
	public void testUpdateValidHouseAd() {
		List<HouseAd> houseAds = listAllHouseAds();
		assertEquals(1, houseAds.size());
		HouseAdInfo houseAd = HouseAdInfo.wrap(houseAds.get(0));
		houseAd.setName("Dolores");
		houseAd.setResidentId(Initializer.resident1_id);
		houseAd.setId(Initializer.house_Adid);
		 
		String houseAdId = Long.toString(houseAd.getId());
		
		Response response = target(houseAdIdUri(houseAdId)).request().put(Entity.entity(houseAd, 
				MediaType.APPLICATION_JSON));
		
		System.out.println(response);

		
		assertEquals(200, response.getStatus());
		
		
		//assertNotNull(response);
		
		List<HouseAd> allHouseAds = listAllHouseAds();
		assertEquals(1, allHouseAds.size());
		
		
	}
}
