package main.java.gr.aueb.mscis.roommatefinder.model;
import java.text.SimpleDateFormat;
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
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="houseAd_id")
    private HouseAd houseAd;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
        name = "FLATMATE_REQUEST",
        joinColumns =
            @JoinColumn(name = "COHABITREQUEST_ID"), 
        inverseJoinColumns =
            @JoinColumn(nullable = false)
    )private Flatmate flatmate;
      
//    @OneToOne(optional = false) 
//    @PrimaryKeyJoinColumn
//     private Cohabitance cohabitance;
//	 
	private boolean connection;
	private Date dateOfRequest;
	
	
	public CohabitRequest(Flatmate flatmate,boolean connection, Date formatter, HouseAd houseAd) {
		this.connection = connection;
		this.dateOfRequest = formatter;
		this.flatmate = flatmate;
		this.houseAd = houseAd;
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

//	public Cohabitance getCohitance() {
//		return cohabitance;
//	}
//
//	public void setCohitance(Cohabitance cohitance) {
//		this.cohabitance = cohitance;
//	}

	public Flatmate getFlatmate() {
		return flatmate;
	}

	public void setFlatmate(Flatmate flatmate) {
		this.flatmate = flatmate;
	}
	
	public HouseAd getHouseAd() {
		return houseAd;
	}
	
	public void setHouseAd(HouseAd houseAd) {
		this.houseAd = houseAd;
	}
	
	public Date dateOfRequest() {
		Date date = new Date(System.currentTimeMillis());
		
		return date;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CohabitRequest other = (CohabitRequest) obj;
//		if (cohabitance == null) {
//			if (other.cohabitance != null)
//				return false;
//		} else if (!cohabitance.equals(other.cohabitance))
//			return false;
		if (connection != other.connection)
			return false;
		if (dateOfRequest == null) {
			if (other.dateOfRequest != null)
				return false;
		} else if (!dateOfRequest.equals(other.dateOfRequest))
			return false;
		if (flatmate == null) {
			if (other.flatmate != null)
				return false;
		} else if (!flatmate.equals(other.flatmate))
			return false;
		if (houseAd == null) {
			if (other.houseAd != null)
				return false;
		} else if (!houseAd.equals(other.houseAd))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idFk == null) {
			if (other.idFk != null)
				return false;
		} else if (!idFk.equals(other.idFk))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		return "CohabitRequest [id=" + id + ", idFk=" + idFk + ", houseAd=" + houseAd + ", flatmate=" + flatmate
				 + ", connection=" + connection + "]";
	}
	
	
	
}
