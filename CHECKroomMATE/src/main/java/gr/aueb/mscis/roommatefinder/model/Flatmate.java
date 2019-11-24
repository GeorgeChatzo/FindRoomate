package main.java.gr.aueb.mscis.roommatefinder.model;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="flatmate")
public class Flatmate extends Roommate{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	
    @OneToMany(mappedBy = "flatmate")
    protected Set<CohabitRequest> cohabitRequests = new HashSet<CohabitRequest>();

	
	@NotNull
	private String description;
	@NotNull
	private String gender;
	@NotNull
	private status profession;
	@NotNull
	private boolean pets;
	@NotNull
	private Set<String> habits;
	@NotNull
	private String workSchedule;
	@NotNull
	private boolean incomingGuests;
	@NotNull
	private Set<Cohabitance> cohabitance;
	
	
	public Flatmate(String username, String password, EmailAddress email, CellNumber phoneNumber, String name,
			String surname, int age, String description, String gender, status profession, boolean pets,
			Set<String> habits, String workSchedule, boolean incomingGuests, Set<Double> rating) {
		super(username, password, email, phoneNumber, name, surname, age, rating);
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
			String surname, int age, Set<Double> rating) {
		super(username, password, email, phoneNumber, name, surname, age, rating);
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
