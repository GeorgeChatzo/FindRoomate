package gr.aueb.mscis.sample.model;

public class HouseAd {
	
	private String description;
	private double rentPrice;
	private Photo photos;
	private String comments;
	
	public HouseAd(String description, double rentPrice, Photo photos, String comments) {
		super();
		this.description = description;
		this.rentPrice = rentPrice;
		this.photos = photos;
		this.comments = comments;
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
	
	public Photo getPhotos() {
		return photos;
	}
	
	public void setPhotos(Photo photos) {
		this.photos = photos;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	

}
