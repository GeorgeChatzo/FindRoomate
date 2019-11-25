package main.java.gr.aueb.mscis.roommatefinder.model;

import javax.persistence.*;

import main.java.gr.aueb.mscis.roommatefinder.model.*;;

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
	public String toString() {
		return "Cohabitance [id=" + id + ", commision=" + commision + ", connection=" + connection + ", request="
				+ request + "]";
	}
	

}
