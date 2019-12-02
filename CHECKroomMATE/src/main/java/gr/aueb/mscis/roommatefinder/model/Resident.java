package main.java.gr.aueb.mscis.roommatefinder.model;

import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="residents")
public class Resident extends Roommate{

	@Id
	@Column(name="residentid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(
	        mappedBy = "resident",
	        cascade = CascadeType.PERSIST)
	private House house;
    
	@OneToMany(orphanRemoval=true, 
            cascade = CascadeType.ALL, 
            mappedBy="resident", fetch=FetchType.LAZY)
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ageRange;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((genderChoice == null) ? 0 : genderChoice.hashCode());
		result = prime * result + (guests ? 1231 : 1237);
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((houseAds == null) ? 0 : houseAds.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + numOfFlatmates;
		result = prime * result + (petRule ? 1231 : 1237);
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((preferedHabits == null) ? 0 : preferedHabits.hashCode());
		result = prime * result + ((preferedProfession == null) ? 0 : preferedProfession.hashCode());
		result = prime * result + ((preferedWorkSchedule == null) ? 0 : preferedWorkSchedule.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resident other = (Resident) obj;
		if (ageRange != other.ageRange)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (genderChoice == null) {
			if (other.genderChoice != null)
				return false;
		} else if (!genderChoice.equals(other.genderChoice))
			return false;
		if (guests != other.guests)
			return false;
		if (house == null) {
			if (other.house != null)
				return false;
		} else if (!house.equals(other.house))
			return false;
		if (houseAds == null) {
			if (other.houseAds != null)
				return false;
		} else if (!houseAds.equals(other.houseAds))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numOfFlatmates != other.numOfFlatmates)
			return false;
		if (petRule != other.petRule)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (preferedHabits == null) {
			if (other.preferedHabits != null)
				return false;
		} else if (!preferedHabits.equals(other.preferedHabits))
			return false;
		if (preferedProfession != other.preferedProfession)
			return false;
		if (preferedWorkSchedule == null) {
			if (other.preferedWorkSchedule != null)
				return false;
		} else if (!preferedWorkSchedule.equals(other.preferedWorkSchedule))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		return true;
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
	
	@Override
	public String toString() {
		return "Resident [id=" + id + ", house=" + house + ", cohabitRequests=" + ", houseAds="
				+ houseAds + ", numOfFlatmates=" + numOfFlatmates + ", ageRange=" + ageRange + ", preferedHabits="
				+ preferedHabits + ", petRule=" + petRule + ", preferedWorkSchedule=" + preferedWorkSchedule
				+ ", preferedProfession=" + preferedProfession + ", guests=" + guests + ", genderChoice=" + genderChoice
				+ ", rating=" + rating + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	

	










}
