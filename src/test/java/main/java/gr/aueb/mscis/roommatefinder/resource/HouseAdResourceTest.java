package main.java.gr.aueb.mscis.roommatefinder.resource;

import static org.junit.Assert.*;

import java.util.List;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;

import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Test;


import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.HOUSEADS;


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

}
