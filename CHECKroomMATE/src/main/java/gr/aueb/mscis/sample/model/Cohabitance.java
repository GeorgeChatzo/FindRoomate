package gr.aueb.mscis.sample.model;

public class Cohabitance {

	private double commision;
	private Date dateOfRequest;
	private int residentID;
	private int flatmateID;
	private Date connectionDate;
	
	public Cohabitance(double commision, Date dateOfRequest, int residentID, int flatmateID, Date connectionDate) {
		super();
		this.commision = commision;
		this.dateOfRequest = dateOfRequest;
		this.residentID = residentID;
		this.flatmateID = flatmateID;
		this.connectionDate = connectionDate;
	}

	public Cohabitance() {
		
	}

	public double getCommision() {
		return commision;
	}
	
	public void setCommision(double commision) {
		this.commision = commision;
	}
	
	public Date getDateOfRequest() {
		return dateOfRequest;
	}
	
	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}
	
	public int getResidentID() {
		return residentID;
	}
	
	public void setResidentID(int residentID) {
		this.residentID = residentID;
	}
	
	public int getFlatmateID() {
		return flatmateID;
	}
	
	public void setFlatmateID(int flatmateID) {
		this.flatmateID = flatmateID;
	}
	
	public Date getConnectionDate() {
		return connectionDate;
	}
	
	public void setConnectionDate(Date connectionDate) {
		this.connectionDate = connectionDate;
	}
	


}
