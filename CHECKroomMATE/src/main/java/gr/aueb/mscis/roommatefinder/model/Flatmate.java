package main.java.gr.aueb.mscis.roommatefinder.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;




@Entity
@Table(name="flatmates")
public class Flatmate extends Roommate implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="flatmateid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	
    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "flatmate")
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
	}

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
	
	//Creation of request inside flatmate!
	public CohabitRequest request(HouseAd houseAd) {
        if (houseAd == null) {
            return null;
        }

        CohabitRequest cohabitRequest = new CohabitRequest();
        cohabitRequest.setFlatmate(this);
        cohabitRequest.setHouseAd(houseAd);
        cohabitRequest.dateOfRequest();
        return cohabitRequest;
    }
	
	public void cancelRequest(CohabitRequest cohabitRequest) {
		
		if(cohabitRequests.contains(cohabitRequest)) {
			cohabitRequests.remove(cohabitRequest);
		}
		
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
	
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flatmate other = (Flatmate) obj;
		if (cohabitRequests == null) {
			if (other.cohabitRequests != null)
				return false;
		} else if (!cohabitRequests.equals(other.cohabitRequests))
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
