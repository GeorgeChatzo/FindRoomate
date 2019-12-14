package main.java.gr.aueb.mscis.roommatefinder.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Cohabitance;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.persistence.Initializer;

public class ManageRequestServiceTest extends RoommateServiceTest{

	@Test
	public void testfindResident() {
		ManageRequestService service = new ManageRequestService(em);
		Resident resident = service.findResidentById(Initializer.resident1_id);
		assertNotNull(resident);
		
	}
	
	
	@Test
	public void testAcceptCreateRequest() {
		ManageRequestService service = new ManageRequestService(em);
		Boolean accept= service.acceptRequest(Initializer.cohabitrequest_id, Initializer.resident1_id);
		assertTrue(accept);
	}
	
	@Test
	public void testAcceptNotExistentRequest() {
		ManageRequestService service = new ManageRequestService(em);
		Boolean accept= service.acceptRequest(8L, Initializer.resident1_id);
		
		assertFalse(accept);
	}
	
	@Test
	public void testRejectRequest() {
		ManageRequestService service = new ManageRequestService(em);
		Boolean reject = service.rejectRequest(Initializer.cohabitrequest_id, Initializer.resident1_id);
		
		assertTrue(reject);
			
	}
	
	@Test
	public void testRejectNotExistentRequest() {
		ManageRequestService service = new ManageRequestService(em);
		Boolean reject = service.rejectRequest(8L, Initializer.resident1_id);
		
		assertFalse(reject);
			
	}
	
	
	@Test
	public void testViewPendingRequets() {
		ManageRequestService service = new ManageRequestService(em);
		
		List<CohabitRequest> cohabitRequests = service.viewPendingRequests(Initializer.resident1_id);
		
		assertNotNull(cohabitRequests);
		assertEquals(1, cohabitRequests.size());
		
	}
	
	@Test
	public void testSelectRequest() {
		ManageRequestService service = new ManageRequestService(em);
		
		Cohabitance cohabitance = service.selectRequest(Initializer.cohabitrequest_id, Initializer.resident1_id);
		assertNotNull(cohabitance);
		
	}
	
	@Test
	public void testSelectNullRequest() {
		ManageRequestService service = new ManageRequestService(em);
		
		Cohabitance cohabitance = service.selectRequest(8L, Initializer.resident1_id);
		assertNull(cohabitance);
		
	}
	
}
