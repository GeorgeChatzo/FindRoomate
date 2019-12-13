package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.Set;

import javax.persistence.EntityManager;

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
		
		try {
			updateUsername( username,flatmateId );
			updatePassword(password,flatmateId );
			updateEmailAddress(emailAddress,flatmateId );
			updateCellPhoneNumber( phoneNumber, flatmateId );
			updateName(name, flatmateId );
			updateSurname(surName,flatmateId );
			updateAge(age, flatmateId );
			updateDescription(description, flatmateId );
			updateGender(gender,flatmateId );
			updateProfession(profession,flatmateId );
			updatePets(pets,flatmateId );
			updateHabits(habits,flatmateId );
			updateWorkingSchedule(workSchedule,flatmateId );
			updateIncomingGuest(incomingGuests,flatmateId );
			updateRating(rating, flatmateId );
			
		} catch( IllegalArgumentException ex) {
			return false;
		}
		return true;
	}
	
	public Flatmate findFlatmateById(long id) {
		return em.find(Flatmate.class, id);
	}
	
	public boolean updateUsername(String username, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setUsername(username);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updatePassword(String password, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setPassword(password);
		em.merge(flatmate);
		
		return true;
		
	}
	
	public boolean updateEmailAddress(EmailAddress emailAddress, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setEmail(emailAddress);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updateCellPhoneNumber(CellNumber cell, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setPhoneNumber(cell);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updateName(String name, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setName(name);
		em.merge(flatmate);
		
		return true;
		
	}
	
		
	public boolean updateSurname(String surName, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setSurname(surName);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updateAge(int age, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setAge(age);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updateDescription(String description, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setDescription(description);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updateGender(String gender, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setGender(gender);
		em.merge(flatmate);
		
		return true;
		
	}
	
	public boolean updateProfession(status profession, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setProfession(profession);
		em.merge(flatmate);
		
		return true;
		
	}
	
	
	public boolean updatePets(boolean pets, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setPets(pets);
		em.merge(flatmate);
		
		return true;
		
	}
	
	public boolean updateHabits(Set<String> habits, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setHabits(habits);
		em.merge(flatmate);
		
		return true;
		
	}
	
	public boolean updateWorkingSchedule(String workSchedule, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setWorkSchedule(workSchedule);
		em.merge(flatmate);
		
		return true;
		
	}
	
	public boolean updateIncomingGuest(boolean incomingGuests, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setIncomingGuests(incomingGuests);
		em.merge(flatmate);
		
		return true;
		
	}
	
	public boolean updateRating(Set<Double> rating, long flatmateId ) {
		Flatmate flatmate = findFlatmateById(flatmateId);
		flatmate.setRating(rating);
		em.merge(flatmate);
		
		return true;
		
	}


	public boolean deleteFlatmate(Flatmate flatmate) {

		if (flatmate != null) {
			em.remove(flatmate);
			return true;
		}

		return false;
	}


	
	
}
