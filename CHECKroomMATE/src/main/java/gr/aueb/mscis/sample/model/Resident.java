package gr.aueb.mscis.sample.model;

import java.util.*;

public class Resident extends Roommate{

	private int numOfFlatmates;
	private int ageRange;
	private Set<String> preferedHabits;
	private boolean petRule;
	private String preferedWorkSchedule;
	private status preferedProfession;
	private boolean guests;
	private String genderChoice;
	
	public Resident(String username, String password, EmailAddress email, CellNumber phoneNumber, String name,
			String surname, int age, int numOfFlatmates, int ageRange, Set<String> preferedHabits, boolean petRule,
			String preferedWorkSchedule, status preferedProfession, boolean guests, String genderChoice) {
		super(username, password, email, phoneNumber, name, surname, age);
		this.numOfFlatmates = numOfFlatmates;
		this.ageRange = ageRange;
		this.preferedHabits = preferedHabits;
		this.petRule = petRule;
		this.preferedWorkSchedule = preferedWorkSchedule;
		this.preferedProfession = preferedProfession;
		this.guests = guests;
		this.genderChoice = genderChoice;
	}
	
	public Resident(String username, String password, EmailAddress email, CellNumber phoneNumber, String name,
			String surname, int age) {
		super(username, password, email, phoneNumber, name, surname, age);
		// TODO Auto-generated constructor stub
	}

	public Resident() {
		super();	
	}

	public int getNumOfFlatmates() {
		return numOfFlatmates;
	}
	
	public void setNumOfFlatmates(int numOfFlatmates) {
		this.numOfFlatmates = numOfFlatmates;
	}
	
	public int getAgeRange() {
		return ageRange;
	}
	
	public void setAgeRange(int ageRange) {
		this.ageRange = ageRange;
	}
	
	public Set<String> getPreferedHabits() {
		return preferedHabits;
	}
	
	public void setPreferedHabits(Set<String> preferedHabits) {
		this.preferedHabits = preferedHabits;
	}
	
	public boolean isPetRule() {
		return petRule;
	}
	
	public void setPetRule(boolean petRule) {
		this.petRule = petRule;
	}
	
	public String getPreferedWorkSchedule() {
		return preferedWorkSchedule;
	}
	
	public void setPreferedWorkSchedule(String preferedWorkSchedule) {
		this.preferedWorkSchedule = preferedWorkSchedule;
	}
	
	public status getPreferedProfession() {
		return preferedProfession;
	}
	
	public void setPreferedProfession(status preferedProfession) {
		this.preferedProfession = preferedProfession;
	}
	
	public boolean isGuests() {
		return guests;
	}
	
	public void setGuests(boolean guests) {
		this.guests = guests;
	}
	
	public String getGenderChoice() {
		return genderChoice;
	}
	
	public void setGenderChoice(String genderChoice) {
		this.genderChoice = genderChoice;
	}

	










}
