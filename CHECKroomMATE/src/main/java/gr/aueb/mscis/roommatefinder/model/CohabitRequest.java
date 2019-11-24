package main.java.gr.aueb.mscis.roommatefinder.model;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="cohabitrequests")

public class CohabitRequest {
	@Id
	@Column(name="COHABITREQUEST_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	
	@GeneratedValue(generator = "cohabitanceKeyGenerator")
	@org.hibernate.annotations.GenericGenerator(
	name = "cohabitanceKeyGenerator",
	strategy = "foreign",
	parameters =
	@org.hibernate.annotations.Parameter(
	name = "property", value = "cohabitance"
	)
	)
	protected Long idFk;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "HOUSE_REQUEST",
        joinColumns =
            @JoinColumn(name = "COHABITREQUEST_ID"), // Defaults to ID
        inverseJoinColumns =
            @JoinColumn(nullable = false) 
    ) private HouseAd houseAd;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "FLATMATE_REQUEST",
        joinColumns =
            @JoinColumn(name = "COHABITREQUEST_ID"), // Defaults to ID
        inverseJoinColumns =
            @JoinColumn(nullable = false)
    )private Flatmate flatmate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "RESIDENT_REQUEST",
        joinColumns =
            @JoinColumn(name = "COHABITREQUEST_ID"), // Defaults to ID
        inverseJoinColumns =
            @JoinColumn(nullable = false)
    )private Resident resident;
    
   
    @OneToOne(optional = false) // Create FK constraint on PK column
    @PrimaryKeyJoinColumn
     private Cohabitance cohabitance;
	 
	private boolean connection;
	private Date dateOfRequest;
	
	
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
