package main.java.gr.aueb.mscis.roommatefinder.model;

import java.util.*;

import javax.persistence.*;

/**
 * The resident (The person who lives in the house and looks for flatmate)
 * @author Kevin McCallister
 *
 */
@Entity
@Table(name="residents")
@PrimaryKeyJoinColumn(name = "residentid")
public class Resident extends Roommate{
	
	@OneToOne(
            fetch = FetchType.LAZY,
            optional = false, // NOT NULL
            cascade = CascadeType.PERSIST
        )
        @JoinColumn(unique = true)
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
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.numOfFlatmates = numOfFlatmates;
		this.ageRange = ageRange;
		this.preferedHabits = preferedHabits;
		this.petRule = petRule;
		this.preferedWorkSchedule = preferedWorkSchedule;
		this.preferedProfession = preferedProfession;
		this.guests = guests;
		this.genderChoice = genderChoice;
	}
	
	/**
	 * Custom constructor. Initializes basic resident fields.
	 * @param username
	 * @param password
	 * @param email
	 * @param phoneNumber
	 * @param name
	 * @param surname
	 * @param age
	 * @param rating
	 */
	public Resident(String username, String password, EmailAddress email, CellNumber phoneNumber, String name,
			String surname, int age, Set<Double> rating) {
		super(username, password, name, surname, age);
	}

	/**
	 * Default constructor
	 */
	public Resident() {
		super();
	}
	

	public Set<HouseAd> getHouseAds(){
		return new HashSet<HouseAd>(houseAds);
	}
	/**
	 * Adds a houseAd with this resident
	 * @param houseAd
	 */
	public void addHouseAd(HouseAd houseAd) {
		if(houseAd != null) {
			houseAds.add(houseAd);
			houseAd.setResident(this);
		}
	}

	/**
	 * Removes the houde ad inside the resident
	 * @param houseAd
	 */
	public void removeHouseAd(HouseAd houseAd) {
		if(houseAd != null) {
			houseAds.remove(houseAd);
		}
	}
	
	/**
	 * Returns number of flatmates of resident
	 * @return numOfFlatmates
	 */
	public int getNumOfFlatmates() {
		return numOfFlatmates;
	}
	
	/**
	 * Sets number of flatmates of resident
	 * @param numOfFlatmates
	 */
	public void setNumOfFlatmates(int numOfFlatmates) {
		this.numOfFlatmates = numOfFlatmates;
	}
	
	/**
	 * Returns age range that the resident wants
	 * @return ageRange
	 */
	public int getAgeRange() {
		return ageRange;
	}
	
	/**
	 * Sets the age range that the resident wants
	 * @param ageRange
	 */
	public void setAgeRange(int ageRange) {
		this.ageRange = ageRange;
	}
	
	/**
	 * Returns resident's prefered habits
	 * @return preferedHabits
	 */
	public Set<String> getPreferedHabits() {
		return preferedHabits;
	}
	
	/**
	 * Sets the prefered habits 
	 * @param preferedHabits
	 */
	public void setPreferedHabits(Set<String> preferedHabits) {
		this.preferedHabits = preferedHabits;
	}
	
	/**
	 * Returns {@code true} if resident accepts pets
	 */
	public boolean isPetRule() {
		return petRule;
	}
	
	/**
	 * Sets if the resident allows pets in the house
	 * @param petRule
	 */
	public void setPetRule(boolean petRule) {
		this.petRule = petRule;
	}
	
	/**
	 * Returns workc Schedule that the resident prefers.
	 * @return preferedWorkSchedule
	 */
	public String getPreferedWorkSchedule() {
		return preferedWorkSchedule;
	}
	
	/**
	 * Sets resident's preference for work schedule.
	 * @param preferedWorkSchedule
	 */
	public void setPreferedWorkSchedule(String preferedWorkSchedule) {
		this.preferedWorkSchedule = preferedWorkSchedule;
	}
	
	/**
	 * Returns resident's prefered work status.
	 * @return preferedProfession
	 */
	public status getPreferedProfession() {
		return preferedProfession;
	}
	
	/**
	 * Sets resident's prefered work status.
	 * @param preferedProfession
	 */
	public void setPreferedProfession(status preferedProfession) {
		this.preferedProfession = preferedProfession;
	}
	
	/**
	 * Returns {@code true} if resident accepts guests in the house.
	 */
	public boolean isGuests() {
		return guests;
	}
	
	/**
	 * Sets resident's guest preference.
	 * @param guests
	 */
	public void setGuests(boolean guests) {
		this.guests = guests;
	}
	
	/**
	 * Returns the resident's gender choice for a flatmate.
	 * @return genderChoice
	 */
	public String getGenderChoice() {
		return genderChoice;
	}
	
	/**
	 * Sets the resident's gender choice for a flatmate.
	 * @param genderChoice
	 */
	public void setGenderChoice(String genderChoice) {
		this.genderChoice = genderChoice;
	}

	/**
	 * Returns resident's email.
	 * @return email address of resident
	 */
	public EmailAddress getEmail() {
		return email;
	}

	/**
	 * Sets email address for resident
	 * @param email
	 */
	public void setEmail(EmailAddress email) {
		this.email = email;
	}

	/**
	 * Returns resident's phone number.
	 * @return phone number of resident
	 */
	public CellNumber getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets residnet's phone number.
	 * @param phoneNumber
	 */
	public void setPhoneNumber(CellNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Returns resident's rating.
	 * @return rating
	 */
	public Set<Double> getRating() {
		return rating;
	}

	/**
	 * Sets resident rating
	 * @param rating
	 */
	public void setRating(Set<Double> rating) {
		this.rating = rating;
	}
	
	/**
	 * Return the resident's house.
	 * @return resident house
	 */
	public House getHouse() {
		return house;
	}

	/*
	 * Sets the house of resident.
	 */
	public void setHouse(House house) {
		this.house = house;
	}

	/**
	 * Sets state of cohabit request to Accepted inside resident.
	 * Initializes cohabitance parameters
	 * @param cohabitance
	 * @param request
	 * @param endDate
	 */
	public void acceptRequest(Cohabitance cohabitance,CohabitRequest request,Date endDate) {
		Date startDate = new Date();
		request.setState(RequestState.ACCEPTED);
		cohabitance.setConnection(true);
		cohabitance.setStartDate(startDate);
		cohabitance.setEndDate(endDate);
		
	}
	/**
	 * Sets state of cohabit request to Rejected inside resident.
	 * @param request
	 */
	public void rejectRequest(CohabitRequest request) {
		request.setState(RequestState.REJECTED);
		
	}
	
	
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		builder.append("Resident [id=" + super.getId() + ", house=" + house + ", cohabitRequests=" + 
				 ", numOfFlatmates=" + numOfFlatmates + ", ageRange=" + ageRange + ", preferedHabits="
					+ preferedHabits + ", petRule=" + petRule + ", preferedWorkSchedule=" + preferedWorkSchedule
					+ ", preferedProfession=" + preferedProfession + ", guests=" + guests + ", genderChoice=" + genderChoice
					+ ", rating=" + rating + ", email=" + email + ", phoneNumber=" + phoneNumber + "]");
		for (HouseAd houseAd  : houseAds) {
		    builder.append("Id :[Id=" + houseAd.getId() +
		                              ", Name=" + houseAd.getName() + "]\n");
		}
		
		return  builder.toString();
	}
	
	@Override
	public boolean signUp(Roommate roommate) {
		return ((Resident)roommate).validateFields();
	}
	
	@Override
	public boolean  validateFields() {
		if(!super.validateFields()) {
			return false;
		}
		
        if (this.email == null) {
            return false;
        }
        
        if (this.phoneNumber == null) {
            return false;
        }
        
        if (this.numOfFlatmates <= 0) {
            return false;
        }
        return true;
		
	}
	
	public boolean  validateFieldsResource() {
		if(!super.validateFields()) {
			return false;
		}
		
	      
        if (this.numOfFlatmates <= 0) {
            return false;
        }
		return true;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ageRange;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((genderChoice == null) ? 0 : genderChoice.hashCode());
		result = prime * result + (guests ? 1231 : 1237);
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((houseAds == null) ? 0 : houseAds.hashCode());
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
		if (!super.equals(obj))
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
		if (!houseAds.equals(other.houseAds))
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
	

}
