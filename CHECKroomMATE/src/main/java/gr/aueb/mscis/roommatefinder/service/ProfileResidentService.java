package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.model.status;

public class ProfileResidentService  {
	
	
	private EntityManager em;


	public ProfileResidentService(EntityManager em) {
		this.em = em;
	}	
	
	
	public Resident findResidentById(long id) {
		return em.find(Resident.class, id);
	}
	
	
	public boolean updatePersonalDetails(String username,String password,EmailAddress emailAddress,
			CellNumber cell,String name,String surName,int age,int numOfFlatmates,int ageRange,
			Set<String> preferedHabits,boolean petRule,String preferedWorkSchedule,Set<Double> rating,
			String genderChoice,boolean guests,status preferedProfession,long residentId) {
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Resident resident = findResidentById(residentId);

		
		updateUsername( username,resident );
		updatePassword(password,resident );
		updateEmailAddress(emailAddress,resident );
		updateCellPhoneNumber( cell, resident );
		updateName(name, resident );
		updateSurname(surName,resident );
		updateAge(age, resident );
		updateNumOfFlatmates(numOfFlatmates,resident );
		updateAgeRange(ageRange, resident );
		updatePreferedHabits(preferedHabits, resident );
		updatePetRule(petRule,resident );
		updatepreferedWorkSchedule(preferedWorkSchedule, resident );
		updateStatus(preferedProfession,resident );
		updateGuests(guests, resident );
		updateGenderChoice(genderChoice,  resident);
		updateRating(rating,  resident );
		
		if(resident.validateFields()) {
			tx.commit();
			return true;
		}else {
			tx.rollback();
			
			return false;
		}
		

	
	}
	
	public boolean cancelUpdate() {
		EntityTransaction tx = em.getTransaction();
		tx.rollback();
		
		return true;
	}
	
	public boolean updateUsername(String username, Resident resident ) {
		resident.setUsername(username);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updatePassword(String password, Resident resident ) {
		resident.setPassword(password);
		em.merge(resident);
		
		return true;
		
	}
	
	public boolean updateEmailAddress(EmailAddress emailAddress, Resident resident ) {
		resident.setEmail(emailAddress);;
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateCellPhoneNumber(CellNumber cell, Resident resident ) {
		resident.setPhoneNumber(cell);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateName(String name, Resident resident ) {
		resident.setName(name);;
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateSurname(String surName, Resident resident ) {
		resident.setSurname(surName);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateAge(int age, Resident resident ) {
		resident.setAge(age);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateNumOfFlatmates(int numOfFlatmates, Resident resident ) {
		resident.setNumOfFlatmates(numOfFlatmates);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateAgeRange(int ageRange, Resident resident ) {
		resident.setNumOfFlatmates(ageRange);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updatePreferedHabits(Set<String> preferedHabits, Resident resident) {
		resident.setPreferedHabits(preferedHabits);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updatePetRule(boolean petRule, Resident resident ) {
		resident.setPetRule(petRule);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updatepreferedWorkSchedule(String preferedWorkSchedule, Resident resident) {
		resident.setPreferedWorkSchedule(preferedWorkSchedule);
		em.merge(resident);
		
		return true;
		
	}
	
	public boolean updateStatus(status preferedProfession, Resident resident) {
		resident.setPreferedProfession(preferedProfession);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateGuests(boolean guests, Resident resident ) {
		resident.setGuests(guests);;
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateGenderChoice(String genderChoice, Resident resident) {
		resident.setGenderChoice(genderChoice);
		em.merge(resident);
		
		
		return true;
		
	}
	
	
	public boolean updateRating(Set<Double> rating, Resident resident ) {
		resident.setRating(rating);
		em.merge(resident);
		
		return true;
		
	}
	
	

	public List<Resident> findAllResidents() {
		List<Resident> results = null;

		results = em.createQuery("select resident from Resident resident", Resident.class)
				.getResultList();

		return results;
	}
	

}
