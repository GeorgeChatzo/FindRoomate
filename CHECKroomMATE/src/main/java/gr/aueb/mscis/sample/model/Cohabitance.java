package gr.aueb.mscis.sample.model;

public class Cohabitance {

	private double commision;
	private boolean connection;
	private CohabitRequest request;
	
	public Cohabitance(double commision, boolean connection) {
		this.commision = commision;
		this.connection = connection;
	}

	public Cohabitance() {
		
	}

	public double getCommision() {
		return commision;
	}
	
	public void setCommision(double commision) {
		this.commision = commision;
	}
	
	public boolean getConnection() {
		return connection;
	}
	
	public void setConnection(boolean connection) {
		this.connection = connection;
	}

	public CohabitRequest getRequest() {
		return request;
	}

	public void setRequest(CohabitRequest request) {
		this.request = request;
	}
	


}
