package main.java.gr.aueb.mscis.roommatefinder.resource;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;

@XmlRootElement
public class HouseAdInfo {
	
	private long id;
	private String name;
	private String description;
	private double rentPrice;
	private String photos;
	private String comments;
	private int numberOfRoommates;
	private long residentId;
	
	public HouseAdInfo() {
		
	}
	
	public HouseAdInfo(long id, String name, String description, double rentPrice, String photos, String comments,
			int numberOfRoommates, long residentId) {
		this(name,description,rentPrice,photos,comments,numberOfRoommates,residentId);
		this.id = id;

	}

	public HouseAdInfo( String name, String description, double rentPrice, String photos, String comments,
			int numberOfRoommates, long residentId) {
		super();
		this.name = name;
		this.description = description;
		this.rentPrice = rentPrice;
		this.photos = photos;
		this.comments = comments;
		this.numberOfRoommates = numberOfRoommates;
		this.residentId = residentId;
	}
	
	public HouseAdInfo(HouseAd houseAd) {
		id = houseAd.getId();
		name = houseAd.getName();
		description = houseAd.getDescription();
		rentPrice = houseAd.getRentPrice();
		photos = houseAd.getPhotos();
		comments = houseAd.getComments();
		numberOfRoommates = houseAd.getNumberOfRoommates();
		residentId = houseAd.getResident().getId();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public long getResidentId() {
		return residentId;
	}

	public void setResidentId(long residentId) {
		this.residentId = residentId;
	}
	
	public static HouseAdInfo wrap(HouseAd ad) {
		return new HouseAdInfo(ad);
	}
	
	public static List<HouseAdInfo> wrap(List<HouseAd> houseAds) {

		List<HouseAdInfo> houseAdInfoList = new ArrayList<>();

		for (HouseAd ad : houseAds) {
			houseAdInfoList.add(new HouseAdInfo(ad));
		}

		return houseAdInfoList;

	}
	
	public HouseAd getHouseAd(EntityManager em) {
		HouseAd houseAd = null;
		
		if(id <= -1)
			houseAd = em.find(HouseAd.class, id);
		else
			houseAd = new HouseAd();
		houseAd.setId(id);
		houseAd.setName(name);
		houseAd.setDescription(description);
		houseAd.setComments(comments);
		houseAd.setNumberOfRoommates(numberOfRoommates);
		houseAd.setPhotos(photos);
		houseAd.setRentPrice(rentPrice);
		
		Resident resident = em.getReference(Resident.class, residentId);
		houseAd.setResident(resident);
		
		return houseAd;
	}

}