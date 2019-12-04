package main.java.gr.aueb.mscis.roommatefinder.model;

/**
 * States that can be used to describe current request status 
 */



public enum RequestState {
	
	/**
	 * State if request has not been accepted/rejected yet 
	 */
	PENDING,
	
	/**
	 * State if request has been accepted
	 */
	ACCEPTED,
	
	/**
	 * State if request has been rejected
	 */
	REJECTED
	
	

}
