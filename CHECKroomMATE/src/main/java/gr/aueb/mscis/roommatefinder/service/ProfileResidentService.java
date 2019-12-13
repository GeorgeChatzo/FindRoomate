package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.model.status;

public class ProfileResidentService {
	
	
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
		
		updateUsername( username,residentId );
		updatePassword(password,residentId );
		updateEmailAddress(emailAddress,residentId );
		updateCellPhoneNumber( cell, residentId );
		updateName(name, residentId );
		updateSurname(surName,residentId );
		updateAge(age, residentId );
		updateNumOfFlatmates(numOfFlatmates,residentId );
		updateAgeRange(ageRange, residentId );
		updatePreferedHabits(preferedHabits, residentId );
		updatePetRule(petRule,residentId );
		updatepreferedWorkSchedule(preferedWorkSchedule, residentId );
		updateStatus(preferedProfession,residentId );
		updateGuests(guests, residentId );
		updateGenderChoice(genderChoice,  residentId);
		updateRating(rating,  residentId );
		
		return true;
		

	
	}
	
	public boolean updateUsername(String username, long residentId ) {
		Resident resident = findResidentById(residentId);
		resident.setUsername(username);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updatePassword(String password, long residentId ) {
		Resident resident = findResidentById(residentId);
		resident.setPassword(password);
		em.merge(resident);
		
		return true;
		
	}
	
	public boolean updateEmailAddress(EmailAddress emailAddress, long residentId ) {
		Resident resident = findResidentById(residentId);
		resident.setEmail(emailAddress);;
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateCellPhoneNumber(CellNumber cell, long residentId ) {
		Resident resident = findResidentById(residentId);
		CellNumber phone = new CellNumber("210123456");
		resident.setPhoneNumber(phone);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateName(String name, long residentId ) {
		Resident resident = findResidentById(residentId);
		resident.setName(name);;
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateSurname(String surName, long residentId ) {
		Resident resident = findResidentById(residentId);
		resident.setSurname(surName);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateAge(int age, long residentId ) {
		Resident resident = findResidentById(residentId);
		resident.setAge(age);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateNumOfFlatmates(int numOfFlatmates, long residentId ) {
		Resident resident = findResidentById(residentId);
		resident.setNumOfFlatmates(numOfFlatmates);;
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateAgeRange(int ageRange, long residentId ) {
		Resident resident = findResidentById(residentId);
		resident.setNumOfFlatmates(ageRange);;
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updatePreferedHabits(Set<String> preferedHabits, long residentId ) {
		Resident resident = findResidentById(residentId);
		resident.setPreferedHabits(preferedHabits);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updatePetRule(boolean petRule, long residentId ) {
		Resident resident = findResidentById(residentId);
		resident.setPetRule(petRule);
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updatepreferedWorkSchedule(String preferedWorkSchedule, long residentId ) {
		Resident resident = findResidentById(residentId);
		resident.setPreferedWorkSchedule(preferedWorkSchedule);
		em.merge(resident);
		
		return true;
		
	}
	
	public boolean updateStatus(status preferedProfession, long residentId ) {
		Resident resident = findResidentById(residentId);
		resident.setPreferedProfession(preferedProfession);;
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateGuests(boolean guests, long residentId ) {
		Resident resident = findResidentById(residentId);
		resident.setGuests(guests);;
		em.merge(resident);
		
		return true;
		
	}
	
	
	public boolean updateGenderChoice(String genderChoice, long residentId) {
		Resident resident = findResidentById(residentId);
		resident.setGenderChoice(genderChoice);
		em.merge(resident);
		
		
		return true;
		
	}
	
	
	public boolean updateRating(Set<Double> rating, long residentId ) {
		Resident resident = findResidentById(residentId);
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
