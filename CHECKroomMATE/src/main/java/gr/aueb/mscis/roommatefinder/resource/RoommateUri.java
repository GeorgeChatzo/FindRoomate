package main.java.gr.aueb.mscis.roommatefinder.resource;

public class RoommateUri {
	
	/**
	 * /houseAds
	 */
	public static final String HOUSEADS = "houseAds";
	
	/**
	 * /cohabitrequests
	 */
	public static final String COREQUESTS = "cohabitrequests";
	
	/**
	 * /flatmates
	 */
	public static final String FLATMATES = "flatmates";
	
	/**
	 * /residents
	 */
	public static final String RESIDENTS = "residents";
	
	/**
	 * /roommates
	 */
	public static final String ROOMMATES = "roommates";
	
	/**
	 * /houseAds/{id}, <br>
	 * e.g. /houseAds/1
	 */
	public static String houseAdIdUri(String id) {
        return HOUSEADS + "/" + id;
    }
	
	public static String cohabitRequestIdUri(String id) {
        return COREQUESTS + "/" + id;
    }
	
	public static String roommateIdUri(String id) {
        return ROOMMATES + "/" + id;
    }
	
	public static final String FLATMATES_ALL = "roommates/flatmates";
	
	public static final String RESIDENTS_ALL = "roommates/residents";

	
	
	public static String flatmateIdUri(String id) {
        return FLATMATES + "/" + id;
    }
	
	/**
	 * /houseAds?name={name}, <br>
	 * e.g. /houseAds?name=super
	 */
	public static String houseAdSearchUri(String name) {
		return HOUSEADS + "?name=" + name;
	}

	public static String residentIdUri(String id) {
        return RESIDENTS + "/" + id;
    }
	 
}
