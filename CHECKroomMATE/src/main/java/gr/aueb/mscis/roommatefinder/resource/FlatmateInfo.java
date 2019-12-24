package main.java.gr.aueb.mscis.roommatefinder.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.status;
import main.java.gr.aueb.mscis.roommatefinder.model.Roommate;


@XmlRootElement
public class FlatmateInfo extends Roommate{
	
	private String username;
	private String password;
	private String name;
	private String surname;
	private int age;
	private long id;
	private String description;
	private String gender;
	private status profession;
	private boolean pets;
	private String workSchedule;
	private boolean incomingGuests;
	private Set<Double> rating;
	private Set<String> habits;
	private EmailAddress email;
	private CellNumber phoneNumber;
	
	public FlatmateInfo() {
		
	}

	public FlatmateInfo(long id, String username, String password, String name, String surname, int age, String description, String gender,
			 status profession, boolean pets, String workSchedule, boolean incomingGuests, Set<Double> rating, Set<String> habits, EmailAddress email,
			 CellNumber phoneNumber) {
		this(username,password,name,surname,age,description,gender,profession,pets,workSchedule,incomingGuests,rating,habits,email,phoneNumber);
		this.id = id;
	
	}
	
	public FlatmateInfo(String username, String password, String name, String surname, int age,String description,String gender, status profession,boolean pets, String workSchedule, boolean incomingGuests, Set<Double> rating,
			Set<String> habits, EmailAddress email, CellNumber phoneNumber) {
		super(username,password,name,surname,age);
		this.description = description;
		this.gender = gender;
		this.profession = profession;
		this.pets = pets;
		this.workSchedule = workSchedule;
		this.incomingGuests = incomingGuests;
		this.rating = rating;
		this.habits = habits;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public FlatmateInfo (Flatmate flatmate) {
		username = flatmate.getUsername();
		password = flatmate.getPassword();
		name = flatmate.getName();
		surname = flatmate.getSurname();
		age = flatmate.getAge();
		id = flatmate.getId();
		description = flatmate.getDescription();
		gender = flatmate.getGender();
		profession  = flatmate.getProfession();
		pets = flatmate.isPets();
		workSchedule = flatmate.getWorkSchedule();
		rating = flatmate.getRating();
		habits = flatmate.getHabits();
		email = flatmate.getEmail();
		phoneNumber = flatmate.getPhoneNumber();

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
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public status getProfession() {
		return profession;
	}

	public void setProfession(status profession) {
		this.profession = profession;
	}

	public boolean isPets() {
		return pets;
	}

	public void setPets(boolean pets) {
		this.pets = pets;
	}

	public String getWorkSchedule() {
		return workSchedule;
	}

	public void setWorkSchedule(String workSchedule) {
		this.workSchedule = workSchedule;
	}

	public boolean isIncomingGuests() {
		return incomingGuests;
	}

	public void setIncomingGuests(boolean incomingGuests) {
		this.incomingGuests = incomingGuests;
	}

	public Set<Double> getRating() {
		return rating;
	}

	public void setRating(Set<Double> rating) {
		this.rating = rating;
	}

	public Set<String> getHabits() {
		return habits;
	}

	public void setHabits(Set<String> habits) {
		this.habits = habits;
	}

	public EmailAddress getEmail() {
		return email;
	}

	public void setEmail(EmailAddress email) {
		this.email = email;
	}

	public CellNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(CellNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static List<FlatmateInfo> wrap(List<Flatmate> flatmates) {
		List<FlatmateInfo> flatmateInfoList = new ArrayList<>();
		
		for (Flatmate mate : flatmates) {
			flatmateInfoList.add(new FlatmateInfo(mate));
		}
		
		return flatmateInfoList;
	}
	
	public static FlatmateInfo wrap(Flatmate flatmate) {
		return new FlatmateInfo(flatmate);
	} 

	public Flatmate getFlatmate(EntityManager em) {
		Flatmate flatmate = null;
		
		if(id <= -1) {
			flatmate = em.find(Flatmate.class, id);
		}else {
			flatmate = new Flatmate();
		}
			
		flatmate.setUsername(username);
		flatmate.setName(name);
		flatmate.setSurname(surname);
		flatmate.setPassword(password);
		flatmate.setAge(age);
		flatmate.setId(id);
		flatmate.setDescription(description);
		flatmate.setProfession(profession);
		flatmate.setGender(gender);
		flatmate.setHabits(habits);
		flatmate.setIncomingGuests(incomingGuests);
		flatmate.setWorkSchedule(workSchedule);
		flatmate.setEmail(email);
		flatmate.setPets(pets);
		flatmate.setPhoneNumber(phoneNumber);
		
		return flatmate;
	}
}