package gr.aueb.mscis.roommatefinder.model;

public class House {
	
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
	private Resident resident;
	
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

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

}
