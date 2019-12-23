package main.java.gr.aueb.mscis.roommatefinder.resource;

public class RoommateUri {
	
	public static final String HOUSEADS = "houseAds";
	
	public static final String COREQUESTS = "CohabitRequests";
	
	public static String houseAdIdUri(String id) {
        return HOUSEADS + "/" + id;
    }
	
	public static String cohabitRequestIdUri(String id) {
        return COREQUESTS + "/" + id;
    }

}
