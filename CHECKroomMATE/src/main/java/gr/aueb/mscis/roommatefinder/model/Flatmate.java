package main.java.gr.aueb.mscis.roommatefinder.model;

import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The flatmate (The person looking for a flat)
 * @author Kevin McCalister
 *
 */
@Entity
@Table(name="flatmates")
@PrimaryKeyJoinColumn(name = "flatmateid")
public class Flatmate extends Roommate {
	
    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "flatmate" ,orphanRemoval=true)
    private Set<CohabitRequest> cohabitRequests = new HashSet<CohabitRequest>();

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
	
	 /**
	  * Custom constructor that initializes flatmate's basic fields
	  * @param username
	  * @param password
	  * @param email
	  * @param phoneNumber
	  * @param name
	  * @param surname
	  * @param age
	  * @param description
	  * @param gender
	  * @param profession
	  * @param pets
	  * @param habits
	  * @param workSchedule
	  * @param incomingGuests
	  * @param rating
	  */
	public Flatmate(String username, String password, EmailAddress email, CellNumber phoneNumber, String name,
			String surname, int age, String description, String gender, status profession, boolean pets,
			Set<String> habits, String workSchedule, boolean incomingGuests, Set<Double> rating) {
		super(username, password, name, surname, age);
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.gender = gender;
		this.profession = profession;
		this.pets = pets;
		this.habits = habits;
		this.workSchedule = workSchedule;
		this.incomingGuests = incomingGuests;
		this.rating = rating;
	}
	
	/**
	 * Default Constructor
	 */
	public Flatmate() {

	}
	
	/**
	 * Custom constructor that initializes these basic fields
	 * @param username
	 * @param password
	 * @param email
	 * @param phoneNumber
	 * @param name
	 * @param surname
	 * @param age
	 * @param rating
	 */
	public Flatmate(String username, String password, EmailAddress email, CellNumber phoneNumber, String name,
			String surname, int age, Set<Double> rating) {
		super(username, password, name, surname, age);
	}
	
	
	public Set<CohabitRequest> getCohabitRequest(){
		return new HashSet<CohabitRequest>(cohabitRequests);
	}
	
	public void addCohabitRequest(CohabitRequest cohabitRequest) {
		if(cohabitRequest != null) {
			cohabitRequests.add(cohabitRequest);
			cohabitRequest.setFlatmate(this);
		}
	}
	
	public void removeCohabitRequest(CohabitRequest cohabitRequest) {
		if(cohabitRequest != null) {
			cohabitRequests.remove(cohabitRequest);
		}
	}
	
	/**
	 * Creation of request inside flatmate!
	 * @param houseAd
	 */
	public CohabitRequest request(HouseAd houseAd) {
        if (houseAd == null) {
            return null;
        }

        CohabitRequest cohabitRequest = new CohabitRequest();
        cohabitRequest.setFlatmate(this);
        cohabitRequest.setHouseAd(houseAd);
        cohabitRequest.dateOfRequest();
        cohabitRequest.setState(RequestState.PENDING);
        return cohabitRequest;
    }
	/*
	 * Deletes a request that was made
	 */
	public void cancelRequest(CohabitRequest cohabitRequest) {
		
		if(cohabitRequests.contains(cohabitRequest)) {
			cohabitRequests.remove(cohabitRequest);
		}
		
	}
	
	/**
	 * Returns the flatmate's description
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 *Sets a descritpion for a flatmate 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Returns the flatmate's gender
	 * @return
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Sets the flatmate's gender
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * Returns flatmate's current job status
	 * @return
	 */
	public status getProfession() {
		return profession;
	}
	
	/**
	 * Sets flatmate's current job status 
	 * @param profession
	 */
	public void setProfession(status profession) {
		this.profession = profession;
	}
	
	/**
	 * Returns {@code true} if flatmate has a pet
	 */
	public boolean isPets() {
		return pets;
	}
	
	/**
	 * Sets flatmate's pet status?
	 * @param pets
	 */
	public void setPets(boolean pets) {
		this.pets = pets;
	}
	
	/**
	 * Returns a collection of the flatmate's habits
	 * @return habits
	 */
	public Set<String> getHabits() {
		return habits;
	}
	
	/**
	 * Sets a habit for the flatmate
	 * @param habits
	 */
	public void setHabits(Set<String> habits) {
		this.habits = habits;
	}
	
	/**
	 * Returns flatmate's work schedule
	 * @return workSchedule
	 */
	public String getWorkSchedule() {
		return workSchedule;
	}
	/**
	 * Sets the work schedule for the flatmate
	 * @param workSchedule
	 */
	public void setWorkSchedule(String workSchedule) {
		this.workSchedule = workSchedule;
	}
	/**
	 * Return {@code true} if flatmate will have guests
	 */
	public boolean isIncomingGuests() {
		return incomingGuests;
	}
	
	/**
	 * Sets if the flatmate wants to have guests 
	 * @param incomingGuests
	 */
	public void setIncomingGuests(boolean incomingGuests) {
		this.incomingGuests = incomingGuests;
	}

	/**
	 * Returns flatmate's mail address
	 * @return email address
	 */
	public EmailAddress getEmail() {
		return email;
	}

	/**
	 * Sets an email address for the flatmate
	 * @param email
	 */
	public void setEmail(EmailAddress email) {
		this.email = email;
	}

	/**
	 * Returns flatamate's phone number
	 * @return phoneNumber
	 */ 
	public CellNumber getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number for the flatmate
	 * @param phoneNumber
	 */
	public void setPhoneNumber(CellNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * Returns the flatmate rating
	 * @return rating 
	 */
	public Set<Double> getRating() {
		return rating;
	}

	/**
	 * Sets a rating for the flatmate
	 * @param rating
	 */
	public void setRating(Set<Double> rating) {
		this.rating = rating;
	}
	
	/**
	 * Return {@code true} if a person signs up as a flatmate
	 */
	@Override
	public boolean signUp(Roommate roommate) {
		return ((Flatmate)roommate).validateFields();
	}
	
	/**
	 * Returns {@code true} if all fields are valid 
	 */
	@Override
	public boolean  validateFields() {
		if(!super.validateFields()) {
			System.out.println("super");
			return false;
		}
		
		
        if (this.email == null) {
            return false;
        }
        
        if (this.phoneNumber == null) {
        	
            return false;
        }
        return true;
		
	}
	
	public boolean  validateFieldsResource() {
		if(!super.validateFields()) {
			return false;
		}
		return true;
		
	}
	
	
	
	@Override
	public String toString() {
		return "Flatmate [cohabitRequests=" + cohabitRequests + ", description=" + description + ", gender=" + gender
				+ ", profession=" + profession + ", pets=" + pets + ", habits=" + habits + ", workSchedule="
				+ workSchedule + ", incomingGuests=" + incomingGuests + ", rating=" + rating + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", Id=" + getId() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flatmate other = (Flatmate) obj;
		if (!cohabitRequests.equals(other.cohabitRequests))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (habits == null) {
			if (other.habits != null)
				return false;
		} else if (!habits.equals(other.habits))
			return false;
		if (incomingGuests != other.incomingGuests)
			return false;
		if (pets != other.pets)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (profession != other.profession)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (workSchedule == null) {
			if (other.workSchedule != null)
				return false;
		} else if (!workSchedule.equals(other.workSchedule))
			return false;
		return true;
	}


	
}
