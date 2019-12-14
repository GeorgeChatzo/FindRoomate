package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Cohabitance;
import main.java.gr.aueb.mscis.roommatefinder.model.RequestState;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;


public class ManageRequestService {
	
	private EntityManager em;

	public ManageRequestService(EntityManager em) {
		this.em = em;
	}
	
	public boolean acceptRequest(long cohabId,long residentId) {
		Resident currentResident = findResidentById(residentId);
	
		Cohabitance cohabit = selectRequest( cohabId, residentId);
		if(cohabit != null) {
			CohabitRequest request = cohabit.getRequest();

			Date endDate= cohabit.getEndDate();
			currentResident.acceptRequest(cohabit, request, endDate);
		
			em.merge(currentResident);
		
			return true;
		}
		return false;
	}
	
	public boolean rejectRequest(long cohabId,long residentId) {
		Cohabitance cohabit = selectRequest( cohabId, residentId);
		Resident resident = findResidentById(residentId);
		if(cohabit != null) {
			resident.rejectRequest(cohabit.getRequest());
			em.remove(cohabit);
		
			return true;
			
		}
		return false;
	}
	
	
	public Resident findResidentById(long id) {
		return em.find(Resident.class, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public Cohabitance selectRequest(long cohabId,long residentId) {
		List<Cohabitance> result = null;

		result =  em
				.createQuery(
						"select c from Cohabitance c where c.request.houseAd.resident.id = :residentId and c.request.id = :cohabId ")
				.setParameter("residentId", residentId)
				.setParameter("cohabId", cohabId)
				.getResultList();
		if(!result.isEmpty()) {
			return result.get(0);
		}
		else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CohabitRequest> viewPendingRequests(long residentId ){
		List<CohabitRequest> results = null;
		RequestState state = RequestState.PENDING;
		results = em
				.createQuery(
						"select c from CohabitRequest c where c.houseAd.resident.id = :residentId and c.state = :state ")
				.setParameter("residentId", residentId)
				.setParameter("state", state)
				.getResultList();

		return results;
		
	}
	
}
