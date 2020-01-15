package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.bind.annotation.XmlTransient;

import main.java.gr.aueb.mscis.roommatefinder.model.House;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;

public class UpdateHouseAdService {
	
	private EntityManager em;


	public UpdateHouseAdService(EntityManager em) {
		this.em = em;
	}	
	

	public boolean updateHouseAd(String name,String description, double rentPrice, String photos, 
			String comments,int numberOfRoommates,long houseAdid,long residentId) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		HouseAd houseAd = selectHouseAd(houseAdid,residentId);
		updateName(name,houseAd);
		updateDescription(description,houseAd);
		updateRentPrice(rentPrice,houseAd);
		updatePhotos(photos,houseAd); 
		updateComments(comments,houseAd );
		updateNumberOfRoomates(numberOfRoommates,houseAd);
	
		
		if(houseAd.validate()) {
			tx.commit();
			return true;
		}else {
			tx.rollback();
			
			return false;
		}
	}
	
	public boolean updateHouse(String country, String city, String region, int zipCode, String typeOfHouse, int floorNo,
			boolean garden, double squareMeters, boolean elevator, boolean parking, int balconies, int roomsNo,
			int constructionYear, String nearPublicTransport,long houseId,long residentId) {
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		House house = selectHouse(houseId,residentId);

		updateCountry(country,house );
		updateCity(city,house);
		updateRegion(region,house );
		updateZipcode(zipCode,house );
		updateTypeOfHouse(typeOfHouse,house );
		updateFloorNo(floorNo,house);
		updateGarden(garden,house );
		updateSquareMeters(squareMeters,house );
		updateElevator(elevator,house );
		updateParking(parking,house );
		updateBalconies(balconies,house );
		updateConstructionYear(constructionYear,house );
		updatePublicTransport(nearPublicTransport,house );
		
		if(house.validate()) {
			tx.commit();
			return true;
		}else {
			tx.rollback();
			
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public HouseAd selectHouseAd(long houseAdid,long residentId){
		List<HouseAd> results = null;

		results = em
				.createQuery(
						"select houseAd from HouseAd houseAd where houseAd.resident.id = :residentId "
						+ "and houseAd.id = :houseAdid")
				.setParameter("residentId", residentId)
				.setParameter("houseAdid", houseAdid)
				.getResultList();
		
		
		if(!results.isEmpty()) {
			return results.get(0);
		}
		else {
			return null;
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public House selectHouse(long houseId,long residentId){
		List<House> results = null;
		
		results = em
				.createQuery(
						"select resident.house from Resident resident where resident.id = :residentId "
						+ "and resident.house.id = :houseId")
				.setParameter("residentId", residentId)
				.setParameter("houseId", houseId)
				.getResultList();

		return results.get(0);
		
	}
	
	
	public boolean updateName(String name,HouseAd houseAd) {
		houseAd.setName(name);
		em.merge(houseAd);
		
		return true;
		
	}
	
	public boolean updateDescription(String description,HouseAd houseAd ) {
		houseAd.setDescription(description);
		em.merge(houseAd);
		
		return true;
		
	}
	
	public boolean updateRentPrice(double rentPrice,HouseAd houseAd ) {
		houseAd.setRentPrice(rentPrice);
		em.merge(houseAd);
		
		return true;
		
	}
	
	public boolean updatePhotos(String photos,HouseAd houseAd ) {
		houseAd.setPhotos(photos);
		em.merge(houseAd);
		
		return true;
		
	}
	
	public boolean updateComments(String comments, HouseAd houseAd ) {
		houseAd.setComments(comments);
		em.merge(houseAd);
		
		return true;
		
	}
	
	public boolean updateNumberOfRoomates(int numberOfRoommates,HouseAd houseAd) {
		houseAd.setNumberOfRoommates(numberOfRoommates);
		em.merge(houseAd);
		
		return true;
		
	}
	
	//House
	
	public boolean updateCountry(String country,House house ) {
		house.setCountry(country);;
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateCity(String city,House house ) {
		house.setCity(city);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateRegion(String region,House house ) {
		house.setRegion(region);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateZipcode(int zipCode,House house ) {
		house.setZipCode(zipCode);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateTypeOfHouse(String typeOfHouse,House house ) {
		house.setTypeOfHouse(typeOfHouse);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateFloorNo(int floorNo,House house ) {
		house.setFloorNo(floorNo);;
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateGarden(boolean garden,House house) {
		house.setGarden(garden);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateSquareMeters(double squareMeters,House house ) {
		house.setSquareMeters(squareMeters);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateElevator(boolean elevator,House house) {
		house.setElevator(elevator);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateParking(boolean parking,House house ) {
		house.setParking(parking);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateBalconies(int balconies,House house ) {
		house.setBalconies(balconies);
		em.merge(house);
		
		return true;
		
}
	
	public boolean updateConstructionYear(int constructionYear,House house) {
		house.setConstructionYear(constructionYear);
		em.merge(house);
		
		return true;
		
}
	
	public boolean updatePublicTransport(String nearPublicTransport,House house) {
		house.setNearPublicTransport(nearPublicTransport);
		em.merge(house);
		
		return true;
		
}
	

}
