package main.java.gr.aueb.mscis.roommatefinder.resource;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Test;
import main.java.gr.aueb.mscis.roommatefinder.resource.RoommateResource;
import main.java.gr.aueb.mscis.roommatefinder.model.Roommate;
import main.java.gr.aueb.mscis.roommatefinder.resource.RoommateInfo;

import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.ROOMMATES;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.roommateIdUri;


public class RommateSuperResourceTest extends RoommateResourceTest {
	
	@Override
	protected Application configure() {

		return new ResourceConfig(RoommateResource.class, DebugExceptionMapper.class);
	}

	@Context
	UriInfo uriInfo;
	
	@Test
	public void testlistAllRoommates() {
		List<RoommateInfo> roommates = target(ROOMMATES).request()
				.get(new GenericType<List<RoommateInfo>>() {});
		assertEquals(3,roommates.size());
	}	
	
	@Test
	public void testCreateRoommate() {
		List<Roommate> roommates = listRoommates();
		assertEquals(3, roommates.size());
		Roommate roommate = roommates.get(0);
		
		RoommateInfo personal = new RoommateInfo(roommate.getId(),"POTUS","MAGA","Donald","Trump",78);
		Response response = target(ROOMMATES).request().post(Entity.entity(personal, MediaType.APPLICATION_JSON));
		
		assertEquals(201, response.getStatus());
		List<Roommate> allRoommates = listRoommates();
		assertEquals(3, allRoommates.size());

	}
	@Test
	public void testDeleteExistigRoommate() {
		List<Roommate> roommates = listRoommates();
		assertEquals(3, roommates.size());
		Roommate roommate = roommates.get(0);
	
		String roommateId = Long.toString(roommate.getId());
		
		Response response = target(roommateIdUri(roommateId))
								.request().delete();
		
		assertEquals(200, response.getStatus());
		List<Roommate> foundRoommates = listRoommates();

		assertEquals(2, foundRoommates.size());
	}	
	
	@Test
	public void testDeleteNonExistingRoommate() {
		
		Response response = target(roommateIdUri(Integer.toString(Integer.MAX_VALUE))).request().delete();

		assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
	

}

	
