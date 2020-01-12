package main.java.gr.aueb.mscis.roommatefinder.resource;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.FLATMATES;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.flatmateIdUri;



public class FlatmateResourceTest extends RoommateResourceTest {
	
	@Override
	protected Application configure() {

		return new ResourceConfig(FlatmateResource.class, DebugExceptionMapper.class);
	}
	
	@Test
	public void testUpdateFlatmate() {
		List<Flatmate> flatmates = listFlatmates();
		assertEquals(1, flatmates.size());
		FlatmateInfo flatmate = FlatmateInfo.wrap(flatmates.get(0));
		flatmate.setName("Dolores");
		
		String flatmateId = Long.toString(flatmate.getId());
		
		Response response = target(flatmateIdUri(flatmateId)).request().put(Entity.entity(flatmate, 
				MediaType.APPLICATION_JSON));
		
		assertEquals(200, response.getStatus());


	}
	

}
