package main.java.gr.aueb.mscis.roommatefinder.model;
import javax.persistence.*;

@Entity
@Table(name = "house")

public class House {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String country;
	private String city;
	private String region;
	private int zipCode;
	private String typeOfHouse;
	private int floorNo;
	private boolean garden;
	private double squareMeters;
	private boolean elevator;
	private boolean parking;
	private int balconies;
	private int roomsNo;
	private int constructionYear;
	private String nearPublicTransport;

	public House(String country, String city, String region, int zipCode, String typeOfHouse, int floorNo,
			boolean garden, double squareMeters, boolean elevator, boolean parking, int balconies, int roomsNo,
			int constructionYear, String nearPublicTransport) {
		
		this.country = country;
		this.city = city;
		this.region = region;
		this.zipCode = zipCode;
		this.typeOfHouse = typeOfHouse;
		this.floorNo = floorNo;
		this.garden = garden;
		this.squareMeters = squareMeters;
		this.elevator = elevator;
		this.parking = parking;
		this.balconies = balconies;
		this.roomsNo = roomsNo;
		this.constructionYear = constructionYear;
		this.nearPublicTransport = nearPublicTransport;
	}

	public House() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getTypeOfHouse() {
		return typeOfHouse;
	}

	public void setTypeOfHouse(String typeOfHouse) {
		this.typeOfHouse = typeOfHouse;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}

	public boolean isGarden() {
		return garden;
	}

	public void setGarden(boolean garden) {
		this.garden = garden;
	}

	public double getSquareMeters() {
		return squareMeters;
	}

	public void setSquareMeters(double squareMeters) {
		this.squareMeters = squareMeters;
	}

	public boolean isElevator() {
		return elevator;
	}

	public void setElevator(boolean elevator) {
		this.elevator = elevator;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public int getBalconies() {
		return balconies;
	}

	public void setBalconies(int balconies) {
		this.balconies = balconies;
	}

	public int getRoomsNo() {
		return roomsNo;
	}

	public void setRoomsNo(int roomsNo) {
		this.roomsNo = roomsNo;
	}

	public int getConstructionYear() {
		return constructionYear;
	}

	public void setConstructionYear(int constructionYear) {
		this.constructionYear = constructionYear;
	}

	public String getNearPublicTransport() {
		return nearPublicTransport;
	}

	public void setNearPublicTransport(String nearPublicTransport) {
		this.nearPublicTransport = nearPublicTransport;
	}

	public boolean validate() {
        if (this.country == null) {
            return false;
        }
        
        if (this.city == null) {
            return false;
        }
        
        if (this.region == null) {
            return false;
        }
        
        if (this.typeOfHouse == null) {
            return false;
        }
        
        if (this.squareMeters <= 0) {
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
		House other = (House) obj;
		if (balconies != other.balconies)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (constructionYear != other.constructionYear)
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (elevator != other.elevator)
			return false;
		if (floorNo != other.floorNo)
			return false;
		if (garden != other.garden)
			return false;
		if (id != other.id)
			return false;
		if (nearPublicTransport == null) {
			if (other.nearPublicTransport != null)
				return false;
		} else if (!nearPublicTransport.equals(other.nearPublicTransport))
			return false;
		if (parking != other.parking)
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (roomsNo != other.roomsNo)
			return false;
		if (Double.doubleToLongBits(squareMeters) != Double.doubleToLongBits(other.squareMeters))
			return false;
		if (typeOfHouse == null) {
			if (other.typeOfHouse != null)
				return false;
		} else if (!typeOfHouse.equals(other.typeOfHouse))
			return false;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", country=" + country + ", city="
				+ city + ", region=" + region + ", zipCode=" + zipCode + ", typeOfHouse=" + typeOfHouse + ", floorNo="
				+ floorNo + ", garden=" + garden + ", squareMeters=" + squareMeters + ", elevator=" + elevator
				+ ", parking=" + parking + ", balconies=" + balconies + ", roomsNo=" + roomsNo + ", constructionYear="
				+ constructionYear + ", nearPublicTransport=" + nearPublicTransport + "]";
	}
	
	

}
