package main.java.gr.aueb.mscis.roommatefinder.resource;

import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.residentIdUri;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.RESIDENTS;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.flatmateIdUri;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;

public class ResidentResourceTest extends RoommateResourceTest  {
	@Override
	protected Application configure() {

		return new ResourceConfig(ResidentResource.class, DebugExceptionMapper.class);
	} 
	
	@Test
	public void testListAllResidents() {
		List<ResidentInfo> residents = target(RESIDENTS)
				.request().get(new GenericType<List<ResidentInfo>>() {});
		assertEquals(1,residents.size());
	}
	
	
	
	
	@Test
	public void testUpdateResident() {
		List<Resident> residents = listResidents();
		assertEquals(1, residents.size());
		ResidentInfo resident = ResidentInfo.wrap(residents.get(0));
		resident.setName("Dolores");
				
		String residentId = Long.toString(resident.getId());
		
		Response response = target(residentIdUri(residentId)).request().put(Entity.entity(resident, 
				MediaType.APPLICATION_JSON));
		
		assertEquals(200, response.getStatus());


	}
	
	@Test
	public void testUpdatenotValidResident() {
		List<Resident> residents = listResidents();
		assertEquals(1, residents.size());
		ResidentInfo resident = ResidentInfo.wrap(residents.get(0));
		resident.setName(null);
				
		String residentId = Long.toString(resident.getId());
		
		Response response = target(residentIdUri(residentId)).request().put(Entity.entity(resident, 
				MediaType.APPLICATION_JSON));
		
		assertEquals(406, response.getStatus());


	}
	
	@Test
	public void testResidentDetails() {
		
		List<Resident> residents = listResidents();
		ResidentInfo resident = ResidentInfo.wrap(residents.get(0));
		
		String residentId = Long.toString(resident.getId());
		
		ResidentInfo residents1 = target(residentIdUri(residentId)).request().get(ResidentInfo.class);
		
		assertNotNull(residents1);
	}
	
}
