package gr.aueb.mscis.roommatefinder.model;

@Entity
@Table(name="COHABITANCE")

public class Cohabitance {
	@Id
	@GeneratedValue(generator = Constants.ID_GENERATOR)
	private Long id;
	
	private double commision;
	private boolean connection;
	private CohabitRequest request;
	
    @OneToOne(
            mappedBy = "cohabitance",
            cascade = CascadeType.PERSIST
        )
    private CohabitRequest cohabitRequest;
	
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
	


}
