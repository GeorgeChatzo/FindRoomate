package gr.aueb.mscis.sample.model;
import java.util.Date;


public class CohabitRequest {
	
	private boolean connection;
	private Date dateOfRequest;
	private Resident resident;
	private Cohabitance cohabitance;
	private Flatmate flatmate;
	
	public CohabitRequest(boolean connection, Date dateOfRequest) {
		this.connection = connection;
		this.dateOfRequest = dateOfRequest;
	}

	public CohabitRequest() {
		
	}

	public boolean isConnection() {
		return connection;
	}

	public void setConnection(boolean connection) {
		this.connection = connection;
	}

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public Cohabitance getCohitance() {
		return cohabitance;
	}

	public void setCohitance(Cohabitance cohitance) {
		this.cohabitance = cohitance;
	}

	public Flatmate getFlatmate() {
		return flatmate;
	}

	public void setFlatmate(Flatmate flatmate) {
		this.flatmate = flatmate;
	}
	
}
