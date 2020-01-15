package main.java.gr.aueb.mscis.roommatefinder.model;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

/**
 * The request for cohabitance.
 * Records the state of the request
 * @author Giorgos
 *
 */
@Entity
@Table(name="cohabitrequests")

public class CohabitRequest {
	@Id
	@Column(name="COHABITREQUEST_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
    @ManyToOne(fetch=FetchType.LAZY, 
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="houseAd_id")
    private HouseAd houseAd;
    
    @ManyToOne(fetch=FetchType.LAZY, 
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="flatmateid")
    private Flatmate flatmate;
    
    @Enumerated(EnumType.STRING)
    @Column(name="requestate")
    private RequestState state = RequestState.NEW;

	private boolean connection;
	private Date dateOfRequest;
	
	/**
	 * Custom constructor that initializes basic fields
	 * @param flatmate
	 * @param connection
	 * @param formatter
	 * @param houseAd
	 */
	public CohabitRequest(Flatmate flatmate,boolean connection, Date formatter,HouseAd houseAd) {
		this.connection = connection;
		this.dateOfRequest = formatter;
		this.flatmate = flatmate;
		this.houseAd = houseAd;
	}

	/**
	 * Default constructor
	 */
	public CohabitRequest() {
		
	}

	/**
	 * Returns the request id
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the request id
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Returns {@code true} if the resident accepts the request
	 */
	public boolean isConnection() {
		return connection;
	}

	/**
	 * Sets the connection state
	 * @param connection
	 */
	public void setConnection(boolean connection) {
		this.connection = connection;
	}

	/**
	 * Returns the date the request is made
	 * @return date
	 */
	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	/*
	 * Sets the request date
	 */
	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	/**
	 * Returns the flatmate that made the request
	 * @return
	 */
	public Flatmate getFlatmate() {
		return flatmate;
	}

	/**
	 * Sets the flatmate that made the request
	 * @param flatmate
	 */
	public void setFlatmate(Flatmate flatmate) {
		this.flatmate = flatmate;
	}
	
	/**
	 * Returns the houseAd for which the request is made
	 * @return the houseAAd
	 */
	public HouseAd getHouseAd() {
		return houseAd;
	}
	
	/**
	 * Sets the houseAd
	 * @param houseAd
	 */
	public void setHouseAd(HouseAd houseAd) {
		this.houseAd = houseAd;
	}
	/**
	 * Returns the state of the request at any time
	 * @return state
	 */
	public RequestState getState() {
		return state;
	}

	/**
	 * Sets a state for the request
	 * @param state
	 */
	public void setState(RequestState state) {
		this.state = state;
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
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		return "CohabitRequest [id=" + id +  ", houseAd=" + houseAd + ", flatmate=" + flatmate
				 + ", connection=" + connection + "]";
	}
	
	
	
}
