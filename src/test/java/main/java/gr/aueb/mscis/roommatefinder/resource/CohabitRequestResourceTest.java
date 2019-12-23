package main.java.gr.aueb.mscis.roommatefinder.resource;

import static org.junit.Assert.*;

import java.util.List;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;

import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.persistence.Initializer;

import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.*;

public class CohabitRequestResourceTest extends RoommateResourceTest {
	
	@Override
	protected Application configure() {

		return new ResourceConfig(CohabitRequestResource.class, DebugExceptionMapper.class);
	}

	@Test
	public void testListAllPendingRequests() {
		
		List<CohabitRequestInfo> allCohabitRequest = target(COREQUESTS).request().
				get(new GenericType<List<CohabitRequestInfo>>() {});
		
		assertEquals(1, allCohabitRequest.size());
		
		
	}

}
