package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.House;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;

public class PublishAdService {
	
	private EntityManager em;
	
	
	public PublishAdService(EntityManager em) {
		this.em = em;
	}
	
	public boolean createHouseAd(HouseAd houseAd) {
		EntityTransaction et = em.getTransaction();

		if (houseAd != null && houseAd.validate()) {
			et.begin();
			em.persist(houseAd);
			em.flush();
			et.commit();
			return true;
		}

		return false;
	}
	
	public boolean deleteHouseAd(long houseAdId) {
		HouseAd houseAd = findHouseAdById(houseAdId);
		
		if (houseAd != null) {
			em.remove(houseAd);
			return true;
		}

		return false;
	}
	
	
	public boolean createHouse(House house) {
		
		if (house != null && house.validate()) {
			em.persist(house);
			return true;
		}

		return false;
	}
	
	public boolean deleteHouse(long houseId) {
		House house = findHouseById(houseId);
		if (house != null) {
			em.remove(house);
			return true;
		}

		return false;
	}
	
	
	public House findHouseById(long id) {
		return em.find(House.class, id);
	}
	
	public HouseAd findHouseAdById(long id) {
		return em.find(HouseAd.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<HouseAd> findAdsOfResident(long residentId){
		List<HouseAd> results = null;
		
		results = em
				.createQuery(
						"select resident.houseAds from Resident resident where resident.id = :residentId ")
				.setParameter("residentId", residentId)
				.getResultList();

		return results;
		
	}
	
	public List<Flatmate> findAllFlatmates() {
		List<Flatmate> results = null;

		results = em.createQuery("select flatmate from Flatmate flatmate", Flatmate.class)
				.getResultList();

		return results;
	}
	
	
	

}
