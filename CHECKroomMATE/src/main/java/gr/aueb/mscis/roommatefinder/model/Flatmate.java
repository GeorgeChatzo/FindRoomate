package main.java.gr.aueb.mscis.roommatefinder.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="flatmates")
public class Flatmate extends Roommate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	
    @OneToMany(mappedBy = "flatmate")
    protected Set<CohabitRequest> cohabitRequests = new HashSet<CohabitRequest>();

	private String description;
	private String gender;
	private status profession;
	private boolean pets;
	@Column
	@ElementCollection(targetClass=String.class)
	private Set<String> habits;
	private String workSchedule;
	private boolean incomingGuests;
	@Column
	@ElementCollection(targetClass=Double.class)
	private Set<Double> rating;
	
	 @org.hibernate.annotations.Type(
	            type="main.java.gr.aueb.mscis.roommatefinder.persistence.EmailCustomType")
	    @Column(name="email", length = 50, nullable=true)
	private EmailAddress email;
	 @org.hibernate.annotations.Type(
	            type="main.java.gr.aueb.mscis.roommatefinder.persistence.TelphoneNumberCustomType")
	    @Column(name="cellNumber", length = 20, nullable=true)
	private CellNumber phoneNumber;
	
	public Flatmate(String username, String password, EmailAddress email, CellNumber phoneNumber, String name,
			String surname, int age, String description, String gender, status profession, boolean pets,
			Set<String> habits, String workSchedule, boolean incomingGuests, Set<Double> rating) {
		super(username, password, name, surname, age);
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
		super(username, password, name, surname, age);
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


	public Set<Double> getRating() {
		return rating;
	}


	public void setRating(Set<Double> rating) {
		this.rating = rating;
	}
	
	
}
