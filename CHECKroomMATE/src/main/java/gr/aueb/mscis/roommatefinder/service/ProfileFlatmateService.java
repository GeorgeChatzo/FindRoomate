package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.List;
import javax.persistence.EntityManager;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;


public class ProfileFlatmateService {

	private EntityManager em;

	public ProfileFlatmateService(EntityManager em) {
		this.em = em;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Flatmate> findFlatmatesByLastName(String lastName) {

		List<Flatmate> results = null;
		results = em
				.createQuery(
						"select flatmate from Flatmate flatmate where flatmate.lastName like :surname ")
				.setParameter("surname", lastName).getResultList();

		return results;
	}
	
	public Flatmate findFlatmateById(int id) {
		return em.find(Flatmate.class, id);
	}
	
	
	public boolean saveOrUpdateFlatmate(Flatmate flatmate) {

		if (flatmate != null) {
			em.merge(flatmate);
			return true;
		}

		return false;
	}
	
	
	public boolean createFlatmate(Flatmate flatmate) {

		if (flatmate != null) {
			em.persist(flatmate);
			return true;
		}

		return false;
	}
	
	public boolean deleteFlatmate(Flatmate flatmate) {

		if (flatmate != null) {
			em.remove(flatmate);
			return true;
		}

		return false;
	}


	
	
}
