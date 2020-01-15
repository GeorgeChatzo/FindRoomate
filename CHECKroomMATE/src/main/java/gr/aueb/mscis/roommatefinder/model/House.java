package main.java.gr.aueb.mscis.roommatefinder.model;
import javax.persistence.*;

/**
 * The house 
 * @author Kevin McCallister
 *
 */
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

	/**
	 * Custom constructor. Initializes basic house fields
	 * @param country
	 * @param city
	 * @param region
	 * @param zipCode
	 * @param typeOfHouse
	 * @param floorNo
	 * @param garden
	 * @param squareMeters
	 * @param elevator
	 * @param parking
	 * @param balconies
	 * @param roomsNo
	 * @param constructionYear
	 * @param nearPublicTransport
	 */
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

	/*
	 * Default constructor
	 */
	public House() {
		
	}

	/*
	 * Returns house id 
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets an id for a house
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Returns the country where the house is
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country where the house is
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Returns the city where the house is 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the house city
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Returns the region where the house is
	 * @return region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Sets the house region
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Returns the house zip code
	 * @return zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the house postal code
	 * @param zipCode
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Returns the type of the house 
	 * @return type 
	 */
	public String getTypeOfHouse() {
		return typeOfHouse;
	}

	/**
	 * Sets the type of the house
	 * @param typeOfHouse
	 */
	public void setTypeOfHouse(String typeOfHouse) {
		this.typeOfHouse = typeOfHouse;
	}

	/**
	 * Returns the number of floors in the house
	 * @return floorNo
	 */
	public int getFloorNo() {
		return floorNo;
	}

	/**
	 * Sets the number of floors in the house
	 * @param floorNo
	 */
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}

	/**
	 * Returns {@code true} if house has garden
	 */
	public boolean isGarden() {
		return garden;
	}

	/**
	 * Sets if house has garden 
	 * @param garden
	 */
	public void setGarden(boolean garden) {
		this.garden = garden;
	}

	/**
	 * Returns house's square meters
	 * @return squareMeters
	 */
	public double getSquareMeters() {
		return squareMeters;
	}

	/**
	 * Sets the house's square meters
	 * @param squareMeters
	 */
	public void setSquareMeters(double squareMeters) {
		this.squareMeters = squareMeters;
	}

	/**
	 * Returns {@code true} if house has elevator
	 * @return
	 */
	public boolean isElevator() {
		return elevator;
	}

	/**
	 * Sets if the house has an elevator
	 * @param elevator
	 */
	public void setElevator(boolean elevator) {
		this.elevator = elevator;
	}

	/**
	 * Returns {@code true} if there is a parking space
	 * @return
	 */
	public boolean isParking() {
		return parking;
	}

	/**
	 * Sets if there is a parking space
	 * @param parking
	 */
	public void setParking(boolean parking) {
		this.parking = parking;
	}

	/**
	 * Returns number of balconies of the house
	 * @return balconies
	 */
	public int getBalconies() {
		return balconies;
	}

	/**
	 * Sets number of balconies of house
	 * @param balconies
	 */
	public void setBalconies(int balconies) {
		this.balconies = balconies;
	}

	/**
	 * Returns the number of rooms
	 * @return roomsNo
	 */
	public int getRoomsNo() {
		return roomsNo;
	}

	/**
	 * Sets number of rooms
	 * @param roomsNo
	 */
	public void setRoomsNo(int roomsNo) {
		this.roomsNo = roomsNo;
	}

	/**
	 * Returns year of house construction
	 * @return
	 */
	public int getConstructionYear() {
		return constructionYear;
	}

	/**
	 * Sets the construction year
	 * @param constructionYear
	 */
	public void setConstructionYear(int constructionYear) {
		this.constructionYear = constructionYear;
	}

	/**
	 * Returns nearest transport spot
	 * @return nearPublicTransport
	 */
	public String getNearPublicTransport() {
		return nearPublicTransport;
	}

	/**
	 * Sets a transport spot near the house
	 * @param nearPublicTransport
	 */
	public void setNearPublicTransport(String nearPublicTransport) {
		this.nearPublicTransport = nearPublicTransport;
	}

	/**
	 * Returns {@code true} if house fields are valid
	 */
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
