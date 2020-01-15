package main.java.gr.aueb.mscis.roommatefinder.model;

import java.util.Date;

import javax.persistence.*;
/**
 * The cohabitance between flatmate and resident 
 * @author Kevin McCallister
 *
 */
@Entity
@Table(name="cohabitance")

public class Cohabitance {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	private double commision;
	private boolean connection;
	private Date startDate;
	private Date endDate;
	
    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false, // NOT NULL
            cascade = CascadeType.PERSIST
        )
        @JoinColumn(unique = true)
	private CohabitRequest request;
	/**
	 * Custom constructor that initializes basic elements
	 * @param commision
	 * @param connection
	 * @param startDate
	 * @param endDate
	 */
	public Cohabitance(double commision, boolean connection, Date startDate, Date endDate) {
		this.commision = commision;
		this.connection = connection;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * Default Constructor 
	 */
	public Cohabitance() {
		
	}

	/**
	 * Returns the id of a cohabitance between flatmate and resident
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets an id for a cohabitance between flatmate and resident
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Returns the commission paid for a cohabitance
	 * @return commission
	 */
	public double getCommision() {
		return commision;
	}
	
	/**
	 * Sets the commision price for a cohabitance
	 * @param commision
	 */
	public void setCommision(double commision) {
		this.commision = commision;
	}
	
	/**
	 * Return {@code true} if cohabitance is made 
	 */
	public boolean getConnection() {
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
	 * Returns the date the cohabitance started
	 * @return date 
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date for the cohabitance
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Returns the date the cohabitance ends 
	 * @return end
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date for the cohabitance
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public CohabitRequest getRequest() {
		return request;
	}

	public void setRequest(CohabitRequest request) {
		this.request = request;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cohabitance other = (Cohabitance) obj;
		if (Double.doubleToLongBits(commision) != Double.doubleToLongBits(other.commision))
			return false;
		if (connection != other.connection)
			return false;
		if (id != other.id)
			return false;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cohabitance [id=" + id + ", commision=" + commision + ", connection=" + connection + ", request="
				+ request + "]";
	}
	

}
