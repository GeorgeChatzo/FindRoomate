package gr.aueb.mscis.roommatefinder.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.jpwh.model.Constants;
import org.jpwh.model.associations.onetomany.jointable.Item;
import org.jpwh.model.associations.onetomany.jointable.User;

@Entity
@Table(name="HOUSEADS")
public class HouseAd {
    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "resident_ad",
        joinColumns =
            @JoinColumn(name = "houseAd_id"), // Defaults to ID
        inverseJoinColumns =
            @JoinColumn(nullable = false) // Defaults to BUYER_ID
    )

    @OneToMany(mappedBy = "house_ad")
    protected Set<CohabitRequest> cohabitRequests = new HashSet<CohabitRequest>();
    
    private Resident resident;
	
	private String description;
	private double rentPrice;
	private String photos;
	private String comments;
	private int numberOfRoommates;
	private Resident resident;
	
	public HouseAd(String description, double rentPrice, String photos, String comments,int numberOfRoommates) {
		super();
		this.description = description;
		this.rentPrice = rentPrice;
		this.photos = photos;
		this.comments = comments;
		this.setNumberOfRoommates(numberOfRoommates);
	}
	
	public HouseAd() {
		
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getRentPrice() {
		return rentPrice;
	}
	
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	public String getPhotos() {
		return photos;
	}
	
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getNumberOfRoommates() {
		return numberOfRoommates;
	}

	public void setNumberOfRoommates(int numberOfRoommates) {
		this.numberOfRoommates = numberOfRoommates;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}
	
	
	
	

}
