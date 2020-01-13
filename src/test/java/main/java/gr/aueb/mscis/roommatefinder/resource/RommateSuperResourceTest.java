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

import main.java.gr.aueb.mscis.roommatefinder.model.Resident;

import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.FLATMATES;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.FLATMATES_ALL;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.RESIDENTS_ALL;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.ROOMMATES;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.roommateIdUri;

public class RommateSuperResourceTest extends RoommateResourceTest {
	
	@Override
	protected Application configure() {

		return new ResourceConfig(RoommateResource.class, DebugExceptionMapper.class);
	}

	@Test
	public void testlistAllRoommates() {
		List<RoommateInfo> roommates = target(ROOMMATES).request().get(new GenericType<List<RoommateInfo>>() {});
		assertEquals(3,roommates.size());
	}
	
	@Test
	public void testListAllFlatmates() {

		List<RoommateInfo> flatmates = target(FLATMATES_ALL).request()
				.get(new GenericType<List<RoommateInfo>>() {});
		assertEquals(1, flatmates.size());
	}
	
	@Test
	public void testListAllResidents() {

		List<RoommateInfo> residents = target(RESIDENTS_ALL).request()
				.get(new GenericType<List<RoommateInfo>>() {});
		assertEquals(1, residents.size());
	}
	
	
	@Test
	public void testUpdateResident() {
		List<Resident> residents = listResidents();
		assertEquals(1, residents.size());
		RoommateInfo resident = RoommateInfo.wrap(residents.get(0));
		resident.setName("Dolores");
		
		String residentId = Long.toString(resident.getId());
		System.out.println(resident.getGenderChoice());

		Response response = target(roommateIdUri(residentId)).request().put(Entity.entity(resident, 
				MediaType.APPLICATION_JSON));
		assertEquals(200, response.getStatus());


	}
}
	
