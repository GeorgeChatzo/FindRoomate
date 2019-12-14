package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.status;


public class ProfileFlatmateService {

	private EntityManager em;

	public ProfileFlatmateService(EntityManager em) {
		this.em = em;
	}	
	
	
	public boolean updatePersonalDetails(String username, String password, EmailAddress emailAddress, CellNumber phoneNumber, String name,
			String surName, int age, String description, String gender, status profession, boolean pets,
			Set<String> habits, String workSchedule, boolean incomingGuests, Set<Double> rating,long flatmateId) {
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Flatmate flatmate = findFlatmateById(flatmateId);
		
			updateUsername( username,flatmate );
			updatePassword(password,flatmate );
			updateEmailAddress(emailAddress,flatmate );
			updateCellPhoneNumber( phoneNumber, flatmate );
			updateName(name, flatmate );
			updateSurname(surName,flatmate );
			updateAge(age, flatmate );
			updateDescription(description, flatmate );
			updateGender(gender,flatmate );
			updateProfession(profession,flatmate );
			updatePets(pets,flatmate );
			updateHabits(habits,flatmate );
			updateWorkingSchedule(workSchedule,flatmate );
			updateIncomingGuest(incomingGuests,flatmate );
			updateRating(rating, flatmate );
			
	
			if(flatmate.validateFields()) {
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
	
	public Flatmate findFlatmateById(long id) {
		return em.find(Flatmate.class, id);
	}
	
	public boolean updateUsername(String username, Flatmate flatmate ) {
		flatmate.setUsername(username);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updatePassword(String password, Flatmate flatmate ) {
		flatmate.setPassword(password);
		em.merge(flatmate);
		
		return true;
		
	}
	
	public boolean updateEmailAddress(EmailAddress emailAddress, Flatmate flatmate ) {
		flatmate.setEmail(emailAddress);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updateCellPhoneNumber(CellNumber cell, Flatmate flatmate ) {
		flatmate.setPhoneNumber(cell);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updateName(String name, Flatmate flatmate ) {
		flatmate.setName(name);
		em.merge(flatmate);
		
		return true;
		
	}
	
		
	public boolean updateSurname(String surName, Flatmate flatmate ) {
		flatmate.setSurname(surName);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updateAge(int age, Flatmate flatmate ) {
		flatmate.setAge(age);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updateDescription(String description, Flatmate flatmate ) {
		flatmate.setDescription(description);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updateGender(String gender, Flatmate flatmate ) {
		flatmate.setGender(gender);
		em.merge(flatmate);
		
		return true;
		
	}
	
	public boolean updateProfession(status profession, Flatmate flatmate ) {
		flatmate.setProfession(profession);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updatePets(boolean pets, Flatmate flatmate ) {
		flatmate.setPets(pets);
		em.merge(flatmate);
		
		return true;
		
	}
	
	public boolean updateHabits(Set<String> habits, Flatmate flatmate ) {
		flatmate.setHabits(habits);
		em.merge(flatmate);
		
		return true;
		
	}
	
	public boolean updateWorkingSchedule(String workSchedule, Flatmate flatmate ) {
		flatmate.setWorkSchedule(workSchedule);
		em.merge(flatmate);
		
		return true;
		
	}
	
	public boolean updateIncomingGuest(boolean incomingGuests, Flatmate flatmate ) {
		flatmate.setIncomingGuests(incomingGuests);
		em.merge(flatmate);
		
		return true;
		
	}
	
	public boolean updateRating(Set<Double> rating,Flatmate flatmate ) {
		flatmate.setRating(rating);
		em.merge(flatmate);
		
		return true;
		
	}

	
	
}
