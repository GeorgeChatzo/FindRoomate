package main.java.gr.aueb.mscis.roommatefinder.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.model.Roommate;
import main.java.gr.aueb.mscis.roommatefinder.model.status;

@XmlRootElement
public class RoommateInfo {
	
	private long id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private int age;
	private int numOfFlatmates;
	private int ageRange;
	private boolean petRule;
	private Set<String> preferedHabits;
	private String preferedWorkSchedule;
	private status preferedProfession;
	private boolean guests;
	private String genderChoice;
	private Set<Double> rating;
	private CellNumber phoneNumber;
	private EmailAddress email;
	
	
	public RoommateInfo() {
	}
	
	public RoommateInfo(long id, String username, String password, String name,String surname, int age) {
		this(username, password, name, surname, age);
		this.id = id;
		
	}
	
	public RoommateInfo(String username, String password, String name, String surname, int age) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	//Resident
	public RoommateInfo(long id, String username, String password, String name, String surname, int age, int numOfFlatmates,
			int ageRange, Set<String> preferedHabits, boolean petRule, String preferedWorkSchedule, status preferedProfession,
			boolean guests, String genderChoice, Set<Double> rating, EmailAddress email, CellNumber phoneNumber, long houseAdId) {
		this(username, password, name, surname, age, numOfFlatmates, ageRange, preferedHabits, petRule,preferedWorkSchedule,
				preferedProfession, guests, genderChoice, rating, email, phoneNumber,houseAdId);
		this.id = id;
	}

	
	public RoommateInfo(String username, String password, String name, String surname, int age, int numOfFlatmates,
			int ageRange, Set<String> preferedHabits, boolean petRule, String preferedWorkSchedule, status preferedProfession,
			boolean guests, String genderChoice, Set<Double> rating, EmailAddress email, CellNumber phoneNumber,long houseAdId) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.numOfFlatmates = numOfFlatmates;
		this.ageRange = ageRange;
		this.preferedHabits = preferedHabits;
		this.petRule = petRule;
		this.preferedWorkSchedule = preferedWorkSchedule;
		this.preferedProfession = preferedProfession;
		this.guests = guests;
		this.genderChoice = genderChoice;
		this.rating = rating;
		this.email = email;
		this.phoneNumber = phoneNumber;		
	}
	
	public RoommateInfo(Roommate roommate) {
		
		id = roommate.getId();
		username = roommate.getUsername();
		password = roommate.getPassword();
		name = roommate.getName();
		surname = roommate.getSurname();
		age = roommate.getAge();
	}
	

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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

	
	public static List<RoommateInfo> wrap(List<Roommate> roommates) {
		List<RoommateInfo> roommateInfoList = new ArrayList<>();
		
		for (Roommate roommate : roommates) {
			roommateInfoList.add(new RoommateInfo(roommate));
			}
		return roommateInfoList;
	}

	public static RoommateInfo wrap(Roommate roommate) {
		return new RoommateInfo(roommate);
	}
	
	public static RoommateInfo wrap(Resident roommate) {
		return new RoommateInfo(roommate);
	}
	
	public Roommate getRoommate(EntityManager em) {
		Roommate roommate = null;
		
		if(id<=-1) {
			roommate = em.find(Roommate.class, id);
		}else {
			roommate = new Roommate();
		}
		
		roommate.setId(id);
		roommate.setUsername(username);
		roommate.setPassword(password);
		roommate.setName(name);
		roommate.setSurname(surname);
		roommate.setAge(age);
		
		return roommate;		
	}
	
	@SuppressWarnings("unchecked")
	public Resident getResident(EntityManager em) {
		Resident resident = null;
		
		if(id <= -1) {
			resident = em.find(Resident.class, id);
		}else {
			resident = new Resident();
		}
		
		resident.setId(id);
		resident.setUsername(username);
		resident.setPassword(password);
		resident.setName(name);
		resident.setSurname(surname);
		resident.setAge(age);
		resident.setNumOfFlatmates(numOfFlatmates);
		resident.setAgeRange(ageRange);
		resident.setPetRule(petRule);
		resident.setPreferedWorkSchedule(preferedWorkSchedule);
		resident.setPreferedProfession(preferedProfession);
		resident.setGuests(guests);
		resident.setGenderChoice(genderChoice);
		resident.setEmail(email);
		resident.setPhoneNumber(phoneNumber);
		
//		House house = em.getReference(House.class, houseId);
//
//		resident.setHouse(house);
//		
//		List<HouseAd> results = null;
//		
//		results = em
//				.createQuery(
//						"select resident.houseAds from Resident resident where resident.id = :residentId ")
//				.setParameter("residentId", id)
//				.getResultList();
//		resident.addHouseAd(results.get(0));
		
		return resident;
	}
	


}