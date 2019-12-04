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
	
	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
