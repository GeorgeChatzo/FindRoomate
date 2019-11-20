package gr.aueb.mscis.sample.model;

import java.util.*;
import javax.persistence.*;


@Entity
@Table(name="Flatmates")
public class Flatmate extends Roommate{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String description;
	private String gender;
	private status profession;
	private boolean pets;
	private Set<String> habits;
	private String workSchedule;
	private boolean incomingGuests;
	
	private Set<Cohabitance> cohabitance;
	
	
	public Flatmate(String username, String password, EmailAddress email, CellNumber phoneNumber, String name,
			String surname, int age, String description, String gender, status profession, boolean pets,
			Set<String> habits, String workSchedule, boolean incomingGuests) {
		super(username, password, email, phoneNumber, name, surname, age);
		this.description = description;
		this.gender = gender;
		this.profession = profession;
		this.pets = pets;
		this.habits = habits;
		this.workSchedule = workSchedule;
		this.incomingGuests = incomingGuests;
	}
	
	
	public Flatmate() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Flatmate(String username, String password, EmailAddress email, CellNumber phoneNumber, String name,
			String surname, int age) {
		super(username, password, email, phoneNumber, name, surname, age);
		// TODO Auto-generated constructor stub
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
	
	public Set<String> getHabits() {
		return habits;
	}
	
	public void setHabits(Set<String> habits) {
		this.habits = habits;
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


	public Set<Cohabitance> getCohabitance() {
		return cohabitance;
	}


	public void setCohabitance(Set<Cohabitance> cohabitance) {
		this.cohabitance = cohabitance;
	}
	
	
}
