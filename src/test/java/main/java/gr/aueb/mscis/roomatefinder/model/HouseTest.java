package main.java.gr.aueb.mscis.roomatefinder.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.House;

public class HouseTest {
	
	@Test
	public void HouseConstructorTest() {
		
		String country="gr";
		String city="ath";
		String region="attica";
		int zipCode=11146;
		String typeOfHouse="flat";
		int floorNo=2;
		boolean garden=true;
		double squareMeters=87.6;
		boolean elevator=true;
		boolean parking=true;
		int balconies=2;
		int roomsNo=3;
		int constructionYear=1997;
	    String nearPublicTransport="metro";
		
		House house = new House(country,  city,  region,  zipCode,  typeOfHouse,  floorNo,
				 garden,  squareMeters,  elevator,  parking,  balconies,  roomsNo,
				 constructionYear,  nearPublicTransport);
		
		assertTrue(house.getCountry().equals(country));
		assertTrue(house.getCity().equals(city));
		assertTrue(house.getRegion().equals(region));
		assertTrue(house.getZipCode()==zipCode);
		assertTrue(house.getTypeOfHouse().equals(typeOfHouse));
		assertTrue(house.getFloorNo()==floorNo);
		assertTrue(house.isGarden()==garden);
		assertTrue(house.getSquareMeters()==squareMeters);
		assertTrue(house.isElevator()==elevator);
		assertTrue(house.isParking()==parking);
		assertTrue(house.getBalconies()==balconies);
		assertTrue(house.getRoomsNo()==roomsNo);
		assertTrue(house.getConstructionYear()==constructionYear);
		assertTrue(house.getNearPublicTransport().contentEquals(nearPublicTransport));
		
	}
	
	
	
	

}
