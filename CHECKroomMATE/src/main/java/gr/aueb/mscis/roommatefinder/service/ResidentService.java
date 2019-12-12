package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.List;

import javax.persistence.EntityManager;

import main.java.gr.aueb.mscis.roommatefinder.model.Resident;

public class ResidentService {
	
	
	private EntityManager em;

	public ResidentService(EntityManager em) {
		this.em = em;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Resident> findResidentsByLastName(String lastName) {

		List<Resident> results = null;
		results = em
				.createQuery(
						"select resident from Resident resident where resident.lastName like :surname ")
				.setParameter("surname", lastName).getResultList();

		return results;
	}
	
	public Resident findResidentById(int id) {
		return em.find(Resident.class, id);
	}
	
	
	public boolean saveOrUpdateResident(Resident resident) {

		if (resident != null) {
			em.merge(resident);
			return true;
		}

		return false;
	}
	
	
	public boolean createResident(Resident resident) {

		if (resident != null) {
			em.persist(resident);
			return true;
		}

		return false;
	}
	
	public boolean deleteResident(Resident resident) {

		if (resident != null) {
			em.remove(resident);
			return true;
		}

		return false;
	}

	public List<Resident> findAllResidents() {
		List<Resident> results = null;

		results = em.createQuery("select resident from Resident resident", Resident.class)
				.getResultList();

		return results;
	}
	

}
