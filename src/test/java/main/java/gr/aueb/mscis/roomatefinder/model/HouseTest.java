package main.java.gr.aueb.mscis.roomatefinder.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.Cohabitance;
import main.java.gr.aueb.mscis.roommatefinder.model.House;

public class HouseTest {
	
	House house1;
	House house2;
	
	@Before
	public void setUp() {
		
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
	    Long id = 1L;
		
		house1 = new House(country,  city,  region,  zipCode,  typeOfHouse,  floorNo,
				 garden,  squareMeters,  elevator,  parking,  balconies,  roomsNo,
				 constructionYear,  nearPublicTransport);
		
		house2 = new House(country,  city,  region,  zipCode,  typeOfHouse,  floorNo,
				 garden,  squareMeters,  elevator,  parking,  balconies,  roomsNo,
				 constructionYear,  nearPublicTransport);
		
		
	}
	
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
		
		assertTrue(house1.getCountry().equals(country));
		assertTrue(house1.getCity().equals(city));
		assertTrue(house1.getRegion().equals(region));
		assertTrue(house1.getZipCode()==zipCode);
		assertTrue(house1.getTypeOfHouse().equals(typeOfHouse));
		assertTrue(house1.getFloorNo()==floorNo);
		assertTrue(house1.isGarden()==garden);
		assertTrue(house1.getSquareMeters()==squareMeters);
		assertTrue(house1.isElevator()==elevator);
		assertTrue(house1.isParking()==parking);
		assertTrue(house1.getBalconies()==balconies);
		assertTrue(house1.getRoomsNo()==roomsNo);
		assertTrue(house1.getConstructionYear()==constructionYear);
		assertTrue(house1.getNearPublicTransport().contentEquals(nearPublicTransport));
		
	}
	
	
	@Test
	public void HouseEmptyConstructorTest() {
		
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
		
		House house = new House();
		
		house.setCountry(country);
		house.setCity(city);
		house.setRegion(region);
		house.setZipCode(zipCode);
		house.setTypeOfHouse(typeOfHouse);
		house.setFloorNo(floorNo);
		house.setGarden(garden);
		house.setSquareMeters(squareMeters);
		house.setElevator(elevator);
		house.setParking(parking);
		house.setBalconies(balconies);
		house.setRoomsNo(roomsNo);
		house.setConstructionYear(constructionYear);
		house.setNearPublicTransport(nearPublicTransport);
		
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
		assertTrue(house.getNearPublicTransport().equals(nearPublicTransport));
		
	}
	
	@Test
	public void HouseObj() {
		
		assertTrue(house1.equals(house1));
		
	}
	
	@Test
	public void TestId1() {
		
		house1.setId(1L);
		assertFalse(house1.equals(house2));
		
	}
	
	@Test
	public void TestId2() {
		
		house2.setId(1L);
		assertFalse(house1.equals(house2));
		
	}
	
	@Test
	public void TestId3() {
		
		house1.setId(2L);
		house2.setId(1L);
		assertFalse(house1.equals(house2));
		
	}
	
	@Test
	public void TestId4() {
		
		assertTrue(house1.equals(house2));
		
	}
	
	@Test
	public void TestgetId() {
		
		house1.setId(1L);
		assertTrue(house1.getId()==1L);
	}
	
	
	@Test
	public void HouseToString() {
		String expected = "House [id=0, country=gr, city=ath, region=attica, zipCode=11146, typeOfHouse=flat, floorNo=2, garden=true, squareMeters=87.6, elevator=true, parking=true, balconies=2, roomsNo=3, constructionYear=1997, nearPublicTransport=metro]";
		assertTrue(house1.toString().equals(expected));
		
	}
	
	@Test
	public void HouseEqualsTest() {
		
		assertTrue(house1.equals(house2));		
	
	}
	
	@Test
	public void HouseEqualsTestNull() {
		
		House house2 = null;
		assertFalse(house1.equals(house2));		
		
	}
	
	
	
	@Test
	public void HouseEqualsOtherObj() {
		
		Cohabitance cohabit = new Cohabitance();
		assertFalse(house1.equals(cohabit));
		
	}
	
	@Test
	public void HouseEqualsAttributeCity1() {
		
		house2.setCity(null);
		assertFalse(house1.equals(house2));

	}
	
	@Test
	public void HouseEqualsAttributeCity2() {
		
		house1.setCity(null);
		assertFalse(house1.equals(house2));

	}
	
	@Test
	public void HouseEqualsAttributeCity3() {
		
		house2.setCity("Thessaloniki");
		assertFalse(house1.equals(house2));

	}
	
	@Test
	public void HouseEqualsAttributeCity4() {
		
		house1.setCity(null);
		house2.setCity(null);
		assertTrue(house1.equals(house2));

	}
	
	@Test
	public void HouseEqualsAttributesBalconiesNo() {
		
		house2.setBalconies(0);
		assertFalse(house1.equals(house2));
		
	}
	
	@Test
	public void HouseEqualsAttributeCountry1() {
		
		house2.setCountry(null);
		assertFalse(house1.equals(house2));

	}
	
	@Test
	public void HouseEqualsAttributeCountry2() {
		
		house1.setCountry(null);
		assertFalse(house1.equals(house2));

	}
	
	@Test
	public void HouseEqualsAttributeCountry3() {
		
		house2.setCountry("Italy");
		assertFalse(house1.equals(house2));

	}
	
	@Test
	public void HouseEqualsAttributeCountry4() {
		house1.setCountry(null);
		house2.setCountry(null);
		assertTrue(house1.equals(house2));

	}
	
	@Test
	public void HouseEqualsAttributeRegion1() {
		
		house2.setRegion(null);
		assertFalse(house1.equals(house2));

	}
	
	@Test
	public void HouseEqualsAttributeRegion2() {
		
		house1.setRegion(null);
		assertFalse(house1.equals(house2));

	}
	
	@Test
	public void HouseEqualsAttributeRegion3() {
		
		house2.setRegion("Macedonia");
		assertFalse(house1.equals(house2));

	}
	
	@Test
	public void HouseEqualsAttributeRegion4() {
		
		house1.setRegion(null);
		house2.setRegion(null);
		assertTrue(house1.equals(house2));

	}
	
	@Test
	public void HouseEqualsAttributeRoomsNo() {
		
		house2.setRoomsNo(5);
		assertFalse(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributesSquareMeters() {
		
		house2.setSquareMeters(100.9);
		assertFalse(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeParking() {
	
		house2.setParking(false);
		assertFalse(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeConstructionYear() {
		
		house2.setConstructionYear(2019);
		assertFalse(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeElevator() {
		
		house2.setElevator(false);
		assertFalse(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeFloorNo() {
		
		house2.setFloorNo(6);
		assertFalse(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeGarden() {
		
		house2.setGarden(false);
		assertFalse(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeTransport1() {
		
		house2.setNearPublicTransport(null);
		assertFalse(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeTransport2() {
		
		house1.setNearPublicTransport(null);
		assertFalse(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeTransport3() {
		
		house2.setNearPublicTransport("no");
		assertFalse(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeTransport4() {
		
		house1.setNearPublicTransport(null);
		house2.setNearPublicTransport(null);
		assertTrue(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeTypeOfHouse1() {
		
		house2.setTypeOfHouse(null);
		assertFalse(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeTypeOfHouse2() {
		
		house1.setTypeOfHouse(null);
		assertFalse(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeTypeOfHouse3() {
		
		house2.setTypeOfHouse("vila");
		assertFalse(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeTypeOfHouse4() {
		
		house1.setTypeOfHouse(null);
		house2.setTypeOfHouse(null);
		assertTrue(house1.equals(house2));
	
	}
	
	@Test
	public void HouseEqualsAttributeZipCode() {
		
		house2.setZipCode(0);
		assertFalse(house1.equals(house2));
	
	}
	
	

}
