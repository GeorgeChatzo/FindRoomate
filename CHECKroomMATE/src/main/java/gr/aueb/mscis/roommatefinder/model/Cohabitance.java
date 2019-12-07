package main.java.gr.aueb.mscis.roommatefinder.model;

import java.util.Date;

import javax.persistence.*;

import main.java.gr.aueb.mscis.roommatefinder.model.*;

@Entity
@Table(name="cohabitance")

public class Cohabitance {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	
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
	
	public Cohabitance(double commision, boolean connection, Date startDate, Date endDate) {
		this.commision = commision;
		this.connection = connection;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
