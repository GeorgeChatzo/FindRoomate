package main.java.gr.aueb.mscis.roomatefinder.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Cohabitance;

public class CohabitanceTest {
	
	Cohabitance habit1;
	Date startDate;
	Date endDate;
	Cohabitance habit2;
	CohabitRequest request;
	
	@Before
	public void setUp() {
		

		double commision = 2.0;
		boolean connection = true;
		startDate = new Date();
		endDate = new Date();
		request = new CohabitRequest();
		habit1 = new Cohabitance(commision,connection,startDate,endDate);
		habit2 = new Cohabitance(commision,connection,startDate,endDate);
		
	}
	
	@Test
	public void CohabitanceConstructorTest() {
		
		assertTrue(habit1.getConnection()==true);
		assertTrue(habit1.getStartDate().equals(startDate));
		assertTrue(habit1.getEndDate().equals(endDate));
		
	}
	
	@Test
	public void CohabitanceConstructorEmptyTest() {
		
		Cohabitance habit = new Cohabitance();
		Date startDate = new Date();
		Date endDate = new Date();
		habit.setCommision(2.2);
		habit.setConnection(true);
		habit.setStartDate(startDate);
		habit.setEndDate(endDate);
		
		assertTrue(habit.getConnection()==true);
		assertTrue(habit.getStartDate().equals(startDate));
		assertTrue(habit.getEndDate().equals(endDate));
	}
	
	@Test
	public void CohabitanceRequest1() {
		CohabitRequest request1 = new CohabitRequest();
		CohabitRequest request2 = new CohabitRequest();
		habit1.setRequest(request1);
		habit2.setRequest(request2);
		assertTrue(habit1.equals(habit2));
	}
	
	@Test
	public void CohabitanceRequest2() {
		CohabitRequest request2 = new CohabitRequest();
		habit1.setRequest(null);
		habit2.setRequest(request2);
		assertFalse(habit1.equals(habit2));
	}
	
	@Test
	public void CohabitanceRequest3() {
		CohabitRequest request1 = new CohabitRequest();
		habit1.setRequest(request1);
		habit2.setRequest(null);
		assertFalse(habit1.equals(habit2));
	}
	
	@Test
	public void CohabitanceRequest4() {
		
		habit1.setRequest(null);
		habit2.setRequest(null);
		assertTrue(habit1.equals(habit2));
	}
	
	@Test
	public void CohabitanceGetRequest() {
		
		habit1.setRequest(request);
		assertTrue(habit1.getRequest().equals(request));
		
	}
	
	@Test 
	public void CohabitanceClass() {
		
		CohabitRequest req = new CohabitRequest();
		assertFalse(habit1.equals(req));
		
	}
	
	@Test
	public void TestCommision() {
		
		habit1.setCommision(0);
		assertFalse(habit1.equals(habit2));
		
	}
	
	@Test
	public void CohabitanceEqualObjects() {
		
		assertTrue(habit1.equals(habit2));
		
	}
	
	@Test
	public void CohabitanceEqualObject() {
		
		assertTrue(habit1.equals(habit1));
		
	}
	
	@Test
	public void CohabitanceEqualObjectNull() {
		
		assertFalse(habit1.equals(null));
		
	}
	
	@Test
	public void TestId1() {
		
		habit1.setId(1L);
		assertFalse(habit1.equals(habit2));
		
	}
	
	@Test
	public void TestId2() {
		
		habit2.setId(1L);
		assertFalse(habit1.equals(habit2));
		
	}
	
	@Test
	public void TestId3() {
		
		habit1.setId(2L);
		habit2.setId(1L);
		assertFalse(habit1.equals(habit2));
		
	}
	
	@Test
	public void TestId4() {
		
		assertTrue(habit1.equals(habit2));
		
	} 
	
	@Test
	public void TestId5() {
		habit1.setId(1L);
		habit2.setId(1L);
		assertTrue(habit1.equals(habit2));
		
	} 
	
	@Test
	public void TestgetId() {
		
		habit1.setId(1L);
		assertEquals(habit1.getId(),1L);
	}
	
	@Test
	public void CohabitanceEquals1() {
		
		Date startDate = new Date();
		Date endDate = new Date();
		Cohabitance cohabitance1 = new Cohabitance(2.0,true,startDate,endDate);
		Cohabitance cohabitance2 = new Cohabitance(2.0,false,startDate,endDate);
		assertFalse(cohabitance1.equals(cohabitance2));
	}
	
	@Test
	public void TestToString() {
		
		String expected ="Cohabitance [id=0, commision=2.0, connection=true, request=null]";
		assertTrue(habit1.toString().equals(expected));
	
	}
	
	
	
}
