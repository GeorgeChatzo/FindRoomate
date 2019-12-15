package main.java.gr.aueb.mscis.roomatefinder.model;

import static org.junit.Assert.*;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.RequestState;

public class CohabitRequestTest {

	Flatmate flatmate;
	HouseAd ad;
	Date date;
	CohabitRequest req1;
	CohabitRequest req2;

	@Before
	public void setUp() {
		
		flatmate = new Flatmate();
		ad = new HouseAd();
		date = new Date(System.currentTimeMillis());
		req1 = new CohabitRequest(flatmate,true,date,ad);
		req2 = new CohabitRequest(flatmate,true,date,ad);

	} 

	@Test
	public void testCohabitRequest() {
		
		Flatmate flatmate = new Flatmate();
		HouseAd ad = new HouseAd();
		Date date = new Date(System.currentTimeMillis());
		CohabitRequest req = new CohabitRequest(flatmate,true,date,ad);
		assertTrue(req.getFlatmate().equals(flatmate));
		assertTrue(req.getHouseAd().equals(ad));
		assertTrue(req.getDateOfRequest().equals(date));
		assertTrue(req.isConnection()==true);
		
	}

	@Test
	public void testCohabitRequestEmptry() {
		
		CohabitRequest req = new CohabitRequest();
		
		req.setConnection(true);
		req.setDateOfRequest(date);
		req.setFlatmate(flatmate);
		req.setHouseAd(ad);
		
		Assert.assertEquals(req.getFlatmate(), flatmate);
		Assert.assertEquals(req.getHouseAd(), ad);
		Assert.assertEquals(req.getDateOfRequest(), date);
		Assert.assertEquals(req.isConnection(), true);
		
	}
	
	@Test
	public void testRequestStatePending() {
		
		req1.setState(RequestState.PENDING);
		assertTrue(req1.getState().equals(RequestState.PENDING));
	}
	
	@Test
	public void testRequestStateAccepted() {
		
		req1.setState(RequestState.ACCEPTED);
		assertTrue(req1.getState().equals(RequestState.ACCEPTED));
	}
	
	@Test
	public void testRequestStateRejected() {
		
		req1.setState(RequestState.REJECTED);
		assertTrue(req1.getState().equals(RequestState.REJECTED));
	}
	
	@Test
	public void testRequestStateCanceled() {
		
		req1.setState(RequestState.CANCELED);
		assertTrue(req1.getState().equals(RequestState.CANCELED));
	}
	
	@Test
	public void testToString() {
		
		String expected = "CohabitRequest [id=0, houseAd=HouseAd [id=0, resident=null, description=null, rentPrice=0.0, photos=null, comments=null, numberOfRoommates=0], flatmate=Roommate [id=0, username=null, password=null, name=null, surname=null, age=0], connection=true]";
		Assert.assertEquals(req1.toString(),expected);
	}
	
	
	@Test
	public void testDateOfRequest() {
		
		Date date1 = req1.dateOfRequest();
		req1.setDateOfRequest(date1);
		assertTrue(req1.getDateOfRequest().equals(date1));
	}
	
	@Test
	public void testObject() {
		
		
		assertTrue(req1.equals(req1));
		
	}
	
	@Test
	public void testObjects() {
		
		assertFalse(req1.equals(null));
		
	}
	
	@Test
	public void testObjects1() {
		
		assertTrue(req1.equals(req2));
		
	}
	
	@Test
	public void testObjectsDifferentClass() {
		
		assertFalse(req1.equals(flatmate));
		
	}
	
	@Test
	public void testConnection() {
		
		req1.setConnection(false);
		assertFalse(req1.equals(req2));
		
	}
	
	@Test 
	public void testDateRequest1() {
		
		Date date1 = new Date(201278);
		Date date2 = new Date(201178);
		req1.setDateOfRequest(date1);
		req2.setDateOfRequest(date2);
		assertFalse(req1.equals(req2));
		
	}
	
	@Test 
	public void testDateRequest2() {
		
		Date date1 = new Date(201278);
		Date date2 = new Date(201178);
		req1.setDateOfRequest(null);
		req2.setDateOfRequest(date2);
		assertFalse(req1.equals(req2));
		
	}
	
	@Test 
	public void testDateRequest3() {
		
		req1.setDateOfRequest(null);
		req2.setDateOfRequest(null);
		assertTrue(req1.equals(req2));
		
	}
	
	@Test
	public void testFlatmate1() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		req1.setFlatmate(fl1);
		req2.setFlatmate(fl2);
		assertTrue(req1.equals(req2));
		
	}
	
	@Test
	public void testFlatmate2() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		req1.setFlatmate(null);
		req2.setFlatmate(fl2);
		assertFalse(req1.equals(req2));
		
	}
	
	@Test
	public void testFlatmate3() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		req1.setFlatmate(null);
		req2.setFlatmate(null);
		assertTrue(req1.equals(req2));
		
	}
	
	@Test
	public void testFlatmate4() {
		
		Flatmate fl1 = new Flatmate();
		Flatmate fl2 = new Flatmate();
		req1.setFlatmate(fl1);
		req2.setFlatmate(null);
		assertFalse(req1.equals(req2));
		
	}
	
	@Test
	public void testHouseAd1() {
		
		HouseAd ad1 = new HouseAd();
		HouseAd ad2 = new HouseAd();
		req1.setHouseAd(ad1);
		req2.setHouseAd(ad2);
		assertTrue(req1.equals(req2));
		
	}
	
	@Test
	public void testHouseAd2() {
		
		HouseAd ad1 = new HouseAd();
		HouseAd ad2 = new HouseAd();
		req1.setHouseAd(ad1);
		req2.setHouseAd(null);
		assertFalse(req1.equals(req2));
		
	}
	
	@Test
	public void testHouseAd3() {
		
		HouseAd ad1 = new HouseAd();
		HouseAd ad2 = new HouseAd();
		req1.setHouseAd(null);
		req2.setHouseAd(ad2);
		assertFalse(req1.equals(req2));
		
	}
	
	@Test
	public void testHouseAd4() {
		
		HouseAd ad1 = new HouseAd();
		HouseAd ad2 = new HouseAd();
		req1.setHouseAd(null);
		req2.setHouseAd(null);
		assertTrue(req1.equals(req2));
		
	}
	
	@Test
	public void TestId1() {
		
		req1.setId(1L);
		assertFalse(req1.equals(req2));
		
	}
	
	@Test
	public void TestId2() {
		
		req2.setId(1L);
		assertFalse(req1.equals(req2));
		
	}
	
	@Test
	public void TestId3() {
		
		req1.setId(2L);
		req2.setId(1L);
		assertFalse(req1.equals(req2));
		
	}
	
	@Test
	public void TestId4() {
		
		assertTrue(req1.equals(req2));
		
	} 
	
	@Test
	public void TestId5() {
		req1.setId(1L);
		req2.setId(1L);
		assertTrue(req1.equals(req2));
		
	} 
	
	@Test
	public void TestgetId() {
		
		req1.setId(1L);
		assertEquals(req1.getId(),1L);
	}
	
	

}
