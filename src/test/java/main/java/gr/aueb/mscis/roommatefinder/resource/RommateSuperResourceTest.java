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
import main.java.gr.aueb.mscis.roommatefinder.resource.RoommateResource;
import main.java.gr.aueb.mscis.roommatefinder.model.Roommate;
import main.java.gr.aueb.mscis.roommatefinder.resource.RoommateInfo;

import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.ROOMMATES;

public class RommateSuperResourceTest extends RoommateResourceTest {
	
	@Override
	protected Application configure() {

		return new ResourceConfig(RoommateResource.class, DebugExceptionMapper.class);
	}

	@Test
	public void testlistAllRoommates() {
		List<RoommateInfo> roommates = target(ROOMMATES).request()
				.get(new GenericType<List<RoommateInfo>>() {});
		assertEquals(3,roommates.size());
	}	
	
	@Test
	public void createNewRoommate() {
		List<Roommate> roommates = listRoommates();
		assertEquals(1,roommates.size());
		Roommate roommate = roommates.get(0);
		
		RoommateInfo personal = new RoommateInfo( roommate.getId(),"POTUS","BingBong","Donald","Trump",78);
		Response response = target(ROOMMATES).request().post(Entity.entity(personal,MediaType.APPLICATION_JSON));
		
		assertEquals(200,response.getStatus());
		List<Roommate> allRoommates = listRoommates();
		assertEquals(3,allRoommates.size());	
	}
	
}
	
