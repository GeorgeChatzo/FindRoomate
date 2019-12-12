package main.java.gr.aueb.mscis.roomatefinder.model;

import static org.junit.Assert.*;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.RequestState;

public class CohabitRequestTest {

	

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
		Assert.assertEquals(req.getFlatmate(),null);
		Assert.assertEquals(req.getHouseAd(), null);
		Assert.assertEquals(req.getDateOfRequest(), null);
		Assert.assertEquals(req.isConnection(), false);
		
	}
	
	@Test
	public void testCohabitRequestSetters() {
		
		Flatmate flatmate = new Flatmate();
		HouseAd ad = new HouseAd();
		Date date = new Date(System.currentTimeMillis());
		Boolean connection = false;
		RequestState state = RequestState.PENDING;
		CohabitRequest req = new CohabitRequest(flatmate,connection,date,ad);
		Flatmate Nflatmate = new Flatmate();
		HouseAd Nad = new HouseAd();
		req.setConnection(true);
		req.setState(RequestState.ACCEPTED);
		req.setFlatmate(Nflatmate);
		Date Ndate = req.dateOfRequest();
		req.setDateOfRequest(Ndate);
		req.setHouseAd(Nad);
		
		assertTrue(req.getFlatmate().equals(Nflatmate));
		assertTrue(req.getHouseAd().equals(Nad));
		assertTrue(req.getDateOfRequest().equals(Ndate));
		assertTrue(req.isConnection()==true);
		assertTrue(req.getState().equals(RequestState.ACCEPTED));
		
	}
	
	
	@Test
	public void testToString() {
		
		Flatmate flatmate = new Flatmate();
		HouseAd ad = new HouseAd();
		Date date = new Date(System.currentTimeMillis());
		CohabitRequest req = new CohabitRequest(flatmate,true,date,ad);
		String expected = "CohabitRequest [id=null, houseAd=HouseAd [id=null, resident=null, description=null, rentPrice=0.0, photos=null, comments=null, numberOfRoommates=0], flatmate=Roommate [id=null, username=null, password=null, name=null, surname=null, age=0], connection=true]";
		Assert.assertEquals(req.toString(),expected);
	}
	
	
	@Test
	public void testEquals() {
		
		Flatmate flatmate = new Flatmate();
		HouseAd ad = new HouseAd();
		Date date = new Date(System.currentTimeMillis());
		Boolean connection = false;
		CohabitRequest request1 = new CohabitRequest();
		CohabitRequest request2 = new CohabitRequest();
		request1.setConnection(connection);
		request1.setDateOfRequest(date);
		request1.setFlatmate(flatmate);
		request1.setHouseAd(ad);
		request1.setState(RequestState.ACCEPTED);
		request2.setConnection(connection);
		request2.setDateOfRequest(date);
		request2.setFlatmate(flatmate);
		request2.setHouseAd(ad);
		request2.setState(RequestState.ACCEPTED);
		assertTrue(request1.equals(request2));
		
	}
	
	
	
	
	
	
	
	

}
