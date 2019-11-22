package gr.aueb.mscis.roommatefinder.model;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.jpwh.model.Constants;
import org.jpwh.model.associations.onetomany.jointable.User;
import org.jpwh.model.associations.onetoone.foreigngenerator.Address;

@Entity
@Table(name="COHABITREQUEST")

public class CohabitRequest {
	@Id
	@GeneratedValue(generator = Constants.ID_GENERATOR)
	 private Long id;
	
	@Id
	@GeneratedValue(generator = "houseKeyGenerator")
	@org.hibernate.annotations.GenericGenerator(
	name = "houseKeyGenerator",
	strategy = "foreign",
	parameters =
	@org.hibernate.annotations.Parameter(
	name = "property", value = "resident"
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
    )
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "FLATMATE_REQUEST",
        joinColumns =
            @JoinColumn(name = "COHABITREQUEST_ID"), // Defaults to ID
        inverseJoinColumns =
            @JoinColumn(nullable = false) // Defaults to BUYER_ID
    )
    
    
    
    private Flatmate flatmate;
    
    private HouseAd houseAd;
 
    @OneToOne(optional = false) // Create FK constraint on PK column
    @PrimaryKeyJoinColumn
     private Cohabitance cohabitance;
	 
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
