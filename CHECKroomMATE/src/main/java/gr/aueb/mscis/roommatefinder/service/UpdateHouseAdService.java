package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.List;

import javax.persistence.EntityManager;

import main.java.gr.aueb.mscis.roommatefinder.model.House;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;

public class UpdateHouseAdService {
	
	private EntityManager em;


	public UpdateHouseAdService(EntityManager em) {
		this.em = em;
	}	
	

	public boolean updateHouseAd(String name,String description, double rentPrice, String photos, 
			String comments,int numberOfRoommates,long houseAdid,long residentId) {
		
		updateName(name,houseAdid,residentId);
		updateDescription(description,houseAdid,residentId);
		updateRentPrice(rentPrice,houseAdid,residentId);
		updatePhotos(photos,houseAdid,residentId); 
		updateComments(comments,houseAdid,residentId );
		updateNumberOfRoomates(numberOfRoommates,houseAdid,residentId);
	
		return true;
	}
	
	public boolean updateHouse(String country, String city, String region, int zipCode, String typeOfHouse, int floorNo,
			boolean garden, double squareMeters, boolean elevator, boolean parking, int balconies, int roomsNo,
			int constructionYear, String nearPublicTransport,long houseId,long residentId) {
		
		updateCountry(country,houseId, residentId );
		updateCity(city,houseId, residentId );
		updateRegion(region,houseId, residentId );
		updateZipcode(zipCode,houseId, residentId );
		
		return true;
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

		return results.get(0);
		
	}
	
	
	@SuppressWarnings("unchecked")
	public House selectHouse(long houseId,long residentId){
		List<House> results = null;
		
		results = em
				.createQuery(
						"select resident from Resident resident where resident.id = :residentId "
						+ "and house.id = :houseId")
				.setParameter("residentId", residentId)
				.setParameter("houseId", houseId)
				.getResultList();

		return results.get(0);
		
	}
	
	public boolean updateName(String name,long houseAdid, long residentId ) {
		HouseAd houseAd = selectHouseAd(houseAdid,residentId);
		houseAd.setName(name);
		em.merge(houseAd);
		
		return true;
		
	}
	
	public boolean updateDescription(String description,long houseAdid, long residentId ) {
		HouseAd houseAd = selectHouseAd(houseAdid,residentId);
		houseAd.setDescription(description);
		em.merge(houseAd);
		
		return true;
		
	}
	
	public boolean updateRentPrice(double rentPrice,long houseAdid, long residentId ) {
		HouseAd houseAd = selectHouseAd(houseAdid,residentId);
		houseAd.setRentPrice(rentPrice);
		em.merge(houseAd);
		
		return true;
		
	}
	
	public boolean updatePhotos(String photos,long houseAdid, long residentId ) {
		HouseAd houseAd = selectHouseAd(houseAdid,residentId);
		houseAd.setPhotos(photos);
		em.merge(houseAd);
		
		return true;
		
	}
	
	public boolean updateComments(String comments,long houseAdid, long residentId ) {
		HouseAd houseAd = selectHouseAd(houseAdid,residentId);
		houseAd.setComments(comments);
		em.merge(houseAd);
		
		return true;
		
	}
	
	public boolean updateNumberOfRoomates(int numberOfRoommates,long houseAdid, long residentId ) {
		HouseAd houseAd = selectHouseAd(houseAdid,residentId);
		houseAd.setNumberOfRoommates(numberOfRoommates);
		em.merge(houseAd);
		
		return true;
		
	}
	
	//House
	
	public boolean updateCountry(String country,long houseId, long residentId ) {
		House house = selectHouse(houseId,residentId);
		house.setCountry(country);;
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateCity(String city,long houseId, long residentId ) {
		House house = selectHouse(houseId,residentId);
		house.setCity(city);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateRegion(String region,long houseId, long residentId ) {
		House house = selectHouse(houseId,residentId);
		house.setRegion(region);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateZipcode(int zipCode,long houseId, long residentId ) {
		House house = selectHouse(houseId,residentId);
		house.setZipCode(zipCode);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateTypeOfHouse(String typeOfHouse,long houseId, long residentId ) {
		House house = selectHouse(houseId,residentId);
		house.setTypeOfHouse(typeOfHouse);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateFloorNo(int floorNo,long houseId, long residentId ) {
		House house = selectHouse(houseId,residentId);
		house.setFloorNo(floorNo);;
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateGarden(boolean garden,long houseId, long residentId ) {
		House house = selectHouse(houseId,residentId);
		house.setGarden(garden);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateSquareMeters(double squareMeters,long houseId, long residentId ) {
		House house = selectHouse(houseId,residentId);
		house.setSquareMeters(squareMeters);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateElevator(boolean elevator,long houseId, long residentId ) {
		House house = selectHouse(houseId,residentId);
		house.setElevator(elevator);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateParking(boolean parking,long houseId, long residentId ) {
		House house = selectHouse(houseId,residentId);
		house.setParking(parking);
		em.merge(house);
		
		return true;
		
	}
	
	public boolean updateBalconies(int balconies,long houseId, long residentId ) {
		House house = selectHouse(houseId,residentId);
		house.setBalconies(balconies);
		em.merge(house);
		
		return true;
		
}
	
	public boolean updateConstructionYear(int constructionYear,long houseId, long residentId ) {
		House house = selectHouse(houseId,residentId);
		house.setConstructionYear(constructionYear);
		em.merge(house);
		
		return true;
		
}
	
	public boolean updatePublicTransport(String nearPublicTransport,long houseId, long residentId ) {
		House house = selectHouse(houseId,residentId);
		house.setNearPublicTransport(nearPublicTransport);
		em.merge(house);
		
		return true;
		
}
	

}
