package main.java.gr.aueb.mscis.roommatefinder.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="houseads")
public class HouseAd {
	@Id
	@Column(name="houseAd_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "houseAd_id",
        joinColumns =
            @JoinColumn(name = "houseAd_id"), // Defaults to ID
        inverseJoinColumns =
            @JoinColumn(nullable = true) // 
    )private Resident resident;


    @OneToMany(mappedBy = "houseAd")
    private Set<CohabitRequest> cohabitRequests = new HashSet<CohabitRequest>();
    
	
	private String description;
	private double rentPrice;
	private String photos;
	private String comments;
	private int numberOfRoommates;
	
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
