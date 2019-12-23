package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.List;

import javax.persistence.EntityManager;

import main.java.gr.aueb.mscis.roommatefinder.model.Roommate;

public class AuthenticationService {
	
	private EntityManager em;
	
	public AuthenticationService(EntityManager em) {
		this.em = em;
	}
	
	
	public boolean createRoommate(Roommate r) {

		if (r != null) {
			em.persist(r);
			return true;
		}

		return false;
	}
	
	public boolean deleteRoommate(Roommate r) {

		if (r != null) {
			em.remove(r);
			return true;
		}

		return false;
	}
	
	public boolean saveOrUpdateRoommate(Roommate r) {

		if (r != null) {
			em.merge(r);
			return true;
		}

		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Roommate> findRoommatesByUsername(String username) {

		List<Roommate> results = null;
		results = em
				.createQuery(
						"select roommate from Roommate roommate where roommate.username like :username ")
				.setParameter("username", username).getResultList();

		return results;
	}
	
	
	public List<Roommate> findAllRoommates(){
		List<Roommate> results = null;
		results = em
				.createQuery(
						"select roommate from Roommate roommate ",Roommate.class).getResultList();

		return results;
		
		
	}

}
