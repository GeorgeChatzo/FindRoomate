package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.List;

import javax.persistence.EntityManager;

import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;


public class ManageRequestService {
	
	private EntityManager em;

	public ManageRequestService(EntityManager em) {
		this.em = em;
	}
	
	
	public boolean acceptRequest() {
		
		return true;
	}
	
	public boolean rejectRequest() {
		
		return true;
	}

	
	@SuppressWarnings("unchecked")
	public List<CohabitRequest> viewPendingRequests(long residentId ){
		List<CohabitRequest> results = null;
		results = em
				.createQuery(
						"select c from CohabitRequest c where c.houseAd.resident.id = :residentId ")
				.setParameter("residentId", residentId).getResultList();

		return results;
		
	}
	
}
