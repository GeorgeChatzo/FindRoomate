package main.java.gr.aueb.mscis.roommatefinder.resource;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Assert;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.persistence.Initializer;

import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.cohabitRequestIdUri;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.COREQUESTS;

public class CohabitRequestResourceTest extends RoommateResourceTest {
	
	@Override
	protected Application configure() {

		return new ResourceConfig(CohabitRequestResource.class, DebugExceptionMapper.class);
	}

	@Test
	public void testListAllRequests() {
		
		List<CohabitRequestInfo> allCohabitRequest = target(COREQUESTS).request()
				.get(new GenericType<List<CohabitRequestInfo>>() {});
		
		assertEquals(2, allCohabitRequest.size());
		
		
	}
	
	@Test
	public void testListAllRequestsbyId() {
		List<CohabitRequestInfo> allCohabitRequest = target(COREQUESTS).request()
				.get(new GenericType<List<CohabitRequestInfo>>() {});
		
		String cohabitId = Long.toString(allCohabitRequest.get(0).getId());

		CohabitRequestInfo request = target(cohabitRequestIdUri(cohabitId)).request().get(CohabitRequestInfo.class);
		assertNotNull(request);
		
	}
	
	@Test
	public void testcreateRequest() throws ParseException {
		List<Flatmate> flatmates = listFlatmates();
		assertEquals(1, flatmates.size());
		Flatmate flatmate = flatmates.get(0);
		
		List<HouseAd> houseAds = listAllHouseAds();
		assertEquals(1, houseAds.size());
		HouseAd houseAd = houseAds.get(0);
		
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date date = format.parse ( "2019-12-31" );
        
        CohabitRequestInfo request = new CohabitRequestInfo(flatmate.getId(),true,date,houseAd.getId());
        
		Response response = target(COREQUESTS).request().post(Entity.entity(request, MediaType.APPLICATION_JSON));

		// Check status and database state
		Assert.assertEquals(201, response.getStatus());

		
	}

}
