package main.java.gr.aueb.mscis.roommatefinder.model;

import javax.persistence.*;

/**
 * The advertisment for the House
 * @author Kevin McCallister
 *
 */
@Entity
@Table(name="houseads")
public class HouseAd {
	@Id
	@Column(name="houseAd_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    @ManyToOne(fetch=FetchType.LAZY, 
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="residentid")
    private Resident resident;

	private String name;
	private String description;
	private double rentPrice;
	private String photos;
	private String comments;
	private int numberOfRoommates;
	
	/**
	 * Custom constructor. Initializes basic ad fields
	 * @param name
	 * @param description
	 * @param rentPrice
	 * @param photos
	 * @param comments
	 * @param numberOfRoommates
	 */
	public HouseAd(String name,String description, double rentPrice, String photos, String comments,int numberOfRoommates) {
		super();
		this.setName(name);
		this.description = description;
		this.rentPrice = rentPrice;
		this.photos = photos;
		this.comments = comments;
		this.setNumberOfRoommates(numberOfRoommates);
	}
	
	/**
	 * Default constructor
	 */
	public HouseAd() {
		
		
	}
	
	/**
	 * Returns the houseAd description
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets a descritpion for the ad
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Returns price of rent
	 * @return rentPrice
	 */
	public double getRentPrice() {
		return rentPrice;
	}
	
	/**
	 * Sets a rent price
	 * @param rentPrice
	 */
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	/**
	 * Returns the resident of the house in the ad
	 * @return resident
	 */
	public Resident getResident() {
		return resident;
	}

	/**
	 * Sets the house's resident
	 * @param resident
	 */
	public void setResident(Resident resident) {
		this.resident = resident;
	}

	/**
	 * Returns photos of the house
	 * @return photos
	 */
	public String getPhotos() {
		return photos;
	}
	
	/**
	 * Sets photos for the houseAd 
	 * @param photos
	 */
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	
	/**
	 * Returns comments for the house in the ad
	 * @return comments
	 */
	public String getComments() {
		return comments;
	}
	
	/**
	 * Sets a comment
	 * @param comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * Returns max number of roommates 
	 * @return numberOfRoommates
	 */
	public int getNumberOfRoommates() {
		return numberOfRoommates;
	}

	/**
	 * Sets number of roommates for the house
	 * @param numberOfRoommates
	 */
	public void setNumberOfRoommates(int numberOfRoommates) {
		this.numberOfRoommates = numberOfRoommates;
	}
	
	/**
	 * Returns the id of the advertisement
	 * @return advert id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Sets an id for the advert
	 * @param id
	 */
	public void setId(long id) {
		this.id=id;
	}
	
	/**
	 * Returns name of advert
	 * @return advert name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets a name for the advert
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Checks validity of fields
	 * @return {@code true} if all fields are valid
	 */
	public boolean validate() {
        if (this.name == null) {
            return false;
        }
        
        if (this.description == null) {
            return false;
        }
        
        if (this.rentPrice <= 0) {
            return false;
        }
        
		
		return true;
		
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HouseAd other = (HouseAd) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfRoommates != other.numberOfRoommates)
			return false;
		if (photos == null) {
			if (other.photos != null)
				return false;
		} else if (!photos.equals(other.photos))
			return false;
		if (Double.doubleToLongBits(rentPrice) != Double.doubleToLongBits(other.rentPrice))
			return false;
		if (resident == null) {
			if (other.resident != null)
				return false;
		} else if (!resident.equals(other.resident))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HouseAd [id=" + id + ", resident=" + resident 
				+ ", description=" + description + ", rentPrice=" + rentPrice + ", photos=" + photos + ", comments="
				+ comments + ", numberOfRoommates=" + numberOfRoommates + "]";
	}



	

}
