package main.java.gr.aueb.mscis.roommatefinder.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;




@Entity
@Table(name="residents")
public class Resident extends Roommate{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(
	        mappedBy = "resident",
	        cascade = CascadeType.PERSIST)
	private House house;
	
    @OneToMany(mappedBy = "resident")
    protected Set<CohabitRequest> cohabitRequests = new HashSet<CohabitRequest>();
    
	@OneToMany(mappedBy = "resident")
    private Set<HouseAd> houseAds = new HashSet<HouseAd>();
	    
	
	@Column(name = "FlatmatesNo")
	private int numOfFlatmates;
	@Column(name = "AgeRange")
	private int ageRange;
	@Column(name = "Habits")
	@ElementCollection(targetClass=String.class)
	private Set<String> preferedHabits;
	@Column(name = "Pets")
	private boolean petRule;
	@Column(name="Schedule")
	private String preferedWorkSchedule;
	private status preferedProfession;
	private boolean guests;
	private String genderChoice;
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
	
	public Resident(String username, String password, EmailAddress email, CellNumber phoneNumber, String name,
			String surname, int age, int numOfFlatmates, int ageRange, Set<String> preferedHabits, boolean petRule,
			String preferedWorkSchedule, status preferedProfession, boolean guests, String genderChoice, Set<Double> rating) {
		super(username, password, name, surname, age);
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
			String surname, int age, Set<Double> rating) {
		super(username, password, name, surname, age);
		// TODO Auto-generated constructor stub
	}

	public Resident() {
		super();	
	}
	
	public Set<HouseAd> getHouseAds(){
		return new HashSet<HouseAd>(houseAds);
	}
	
	public void addHouseAd(HouseAd houseAd) {
		if(houseAd != null) {
			houseAds.add(houseAd);
		}
	}
	
	public void removeHouseAd(HouseAd houseAd) {
		if(houseAd != null) {
			houseAds.remove(houseAd);
		}
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
