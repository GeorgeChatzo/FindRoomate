package main.java.gr.aueb.mscis.roommatefinder.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.RequestState;

@XmlRootElement
public class CohabitRequestInfo {
	
	
	 private long id;
	 private long flatmateId;
	 private RequestState state = RequestState.NEW;
	 private boolean connection;
	 private Date dateOfRequest;
	 private long houseAdId;
	 
	 public CohabitRequestInfo() {
		 
	 }
	 
	 public CohabitRequestInfo(long flatmateId,boolean connection, Date dateOfRequest,long id,long houseAdId) {
		this(flatmateId,connection,dateOfRequest,houseAdId);
		this.id = id;
	 } 
	 
	 public CohabitRequestInfo(long flatmateId,boolean connection, Date dateOfRequest, long houseAdId) {
		 
		super();
		this.flatmateId = flatmateId;
		this.connection = connection;
		this.dateOfRequest = dateOfRequest;
		this.houseAdId = houseAdId;
		
	 }
	 
	 public CohabitRequestInfo(CohabitRequest request) {
		 
		 id = request.getId();
		 connection = request.isConnection();
		 state = request.getState();
		 dateOfRequest = request.getDateOfRequest();
		 flatmateId = request.getFlatmate().getId();
		 houseAdId = request.getHouseAd().getId();
		 
	 }
	 
	 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getFlatmateId() {
		return flatmateId;
	}

	public void setFlatmateId(long flatmateId) {
		this.flatmateId = flatmateId;
	}
	 
	public long getHouseAdId() {
		return houseAdId;
	}

	public void setHouseAdId(long houseAdId) {
		this.houseAdId = houseAdId;
	}

	public static CohabitRequestInfo wrap(CohabitRequest request) {
		return new CohabitRequestInfo(request);
	}
	
	public static List<CohabitRequestInfo> wrap(List<CohabitRequest> requests){
		
		List<CohabitRequestInfo> cohabitRequestInfoList = new ArrayList<>();
		
		for(CohabitRequest request : requests) {
			cohabitRequestInfoList.add(new CohabitRequestInfo(request));
		}
		
		return cohabitRequestInfoList;
		
	}
	
	
	public CohabitRequest getCohabitRequest(EntityManager em) {
		CohabitRequest request = null;
		
		if(id <= -1) {
			request = em.find(CohabitRequest.class,id);
		}else {
			request = new CohabitRequest();
		}
		
		request.setConnection(connection);
		request.setDateOfRequest(dateOfRequest);
		request.setState(state);
		
		Flatmate flatmate = em.getReference(Flatmate.class, flatmateId);
		request.setFlatmate(flatmate);
		
		HouseAd houseAd = em.getReference(HouseAd.class, houseAdId);
		request.setHouseAd(houseAd);
		
		return request;
		
	}
	
	
	 
	 

}
