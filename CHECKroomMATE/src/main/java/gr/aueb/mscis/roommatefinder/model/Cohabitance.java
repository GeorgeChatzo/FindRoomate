package main.java.gr.aueb.mscis.roommatefinder.model;

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
	
    @OneToOne(
            mappedBy = "cohabitance",
            cascade = CascadeType.PERSIST
        )
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
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(commision);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (connection ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((request == null) ? 0 : request.hashCode());
		return result;
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
