package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.House;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;

public class PublishAdService {
	
	private EntityManager em;
	
	private Resident resident;
	//private HouseAd houseAd;
	//private House house;
	
	public PublishAdService(EntityManager em) {
		this.em = em;
	}
	
	public boolean createHouseAd(HouseAd houseAd) {
		
		if (houseAd != null) {
			em.persist(houseAd);
			return true;
		}

		return false;
	}
	
	public boolean deleteHouseAd(HouseAd houseAd) {
		
		if (houseAd != null) {
			em.remove(houseAd);
			return true;
		}

		return false;
	}
	
	
	public boolean createHouse(House house) {
		
		if (house != null) {
			em.persist(house);
			return true;
		}

		return false;
	}
	
	public boolean deleteHous(House house) {
		
		if (house != null) {
			em.remove(house);
			return true;
		}

		return false;
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
