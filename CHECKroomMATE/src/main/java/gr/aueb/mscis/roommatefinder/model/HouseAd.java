package main.java.gr.aueb.mscis.roommatefinder.model;

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
            @JoinColumn(nullable = true) 
    )private Resident resident;

	private String name;
	private String description;
	private double rentPrice;
	private String photos;
	private String comments;
	private int numberOfRoommates;
	
	public HouseAd(String name,String description, double rentPrice, String photos, String comments,int numberOfRoommates) {
		super();
		this.setName(name);
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
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "HouseAd [id=" + id + ", resident=" + resident 
				+ ", description=" + description + ", rentPrice=" + rentPrice + ", photos=" + photos + ", comments="
				+ comments + ", numberOfRoommates=" + numberOfRoommates + "]";
	}



	

}
