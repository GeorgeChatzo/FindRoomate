package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
	public List<HouseAd> findAdResident(){
		List<HouseAd> results = null;
		
		
		return results;
		
	}
	


	
	

}
