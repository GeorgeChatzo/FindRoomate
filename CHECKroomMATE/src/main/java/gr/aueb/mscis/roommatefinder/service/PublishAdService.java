package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Cohabitance;
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
		List<CohabitRequest> request = findReqByHouseAd(houseAdId);
		
		EntityTransaction et = em.getTransaction();
		
		if (houseAd != null) {
			et.begin();

			em.remove(houseAd);
			em.flush();

			for (int i=0; i<request.size(); i++) {
				CohabitRequest req = request.get(i);
				long id = req.getId();
				Cohabitance coh = findCohByRequest(id);
				
				
				if(coh != null) {
					em.remove(coh);
					em.flush();

					em.remove(req);
					
					em.flush();

				}

			}
			
			
			
			et.commit();
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
	
	@SuppressWarnings("unchecked")
	public List<CohabitRequest> findReqByHouseAd(long id) {
		
		List<CohabitRequest> requests = null;
		
		requests = em
				.createQuery(
						"select r from CohabitRequest r where r.houseAd.id = :id ")
				.setParameter("id", id)
				.getResultList();
		
		return requests;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public Cohabitance findCohByRequest(long id) {
		
		List<Cohabitance> coh = null;
		
		coh = em
				.createQuery(
						"select r from Cohabitance r where r.request.id = :id ")
				.setParameter("id", id)
				.getResultList();
		
		if(!coh.isEmpty()) {
			return coh.get(0);
		}
		else {
			return null;
		}
		
	}
		
	

}
