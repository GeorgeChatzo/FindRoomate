package main.java.gr.aueb.mscis.roommatefinder.resource;

public class RoommateUri {
	
	public static final String HOUSEADS = "houseAds";
	
	public static final String COREQUESTS = "cohabitrequests";
	
	public static final String FLATMATES = "flatmates";
	
	public static String houseAdIdUri(String id) {
        return HOUSEADS + "/" + id;
    }
	
	public static String cohabitRequestIdUri(String id) {
        return COREQUESTS + "/" + id;
    }
	
	public static String flatmateIdUri(String id) {
        return FLATMATES + "/" + id;
    }

}
