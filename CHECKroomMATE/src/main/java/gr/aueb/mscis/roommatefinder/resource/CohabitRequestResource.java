package main.java.gr.aueb.mscis.roommatefinder.resource;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.COREQUESTS;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import main.java.gr.aueb.mscis.roommatefinder.resource.HttpError;
import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.service.ManageRequestService;
import main.java.gr.aueb.mscis.roommatefinder.service.PublishAdService;
import main.java.gr.aueb.mscis.roommatefinder.service.RequestService;
import main.java.gr.aueb.mscis.roommatefinder.service.UpdateHouseAdService;


@Path(COREQUESTS)
public class CohabitRequestResource extends AbstractResource {

	@Context 
	UriInfo uriInfo;
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CohabitRequestInfo> listAllCohabitRequests(){
		
		EntityManager em = getEntityManager();
		ManageRequestService service = new ManageRequestService(em);
		List<CohabitRequest> cohabitRequests = service.viewAllRequests();
		List<CohabitRequestInfo> requests = CohabitRequestInfo.wrap(cohabitRequests);
		em.close();
		
		return requests;
	}	
	
	@GET
	@Path("{cohId:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CohabitRequestInfo> listAllPendingCohabitRequests(@PathParam("cohId") long flatmateId){
		EntityManager em = getEntityManager();
		
		RequestService rs = new RequestService(em);
		List<CohabitRequest> cohabitRequests = rs.viewPendingRequests(flatmateId);
		List<CohabitRequestInfo> requests = CohabitRequestInfo.wrap(cohabitRequests);
		
		em.close();
		
		return requests;
		
	} 
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCohabitRequest(CohabitRequestInfo cohabitRequestInfo) {
		EntityManager em = getEntityManager();
		
		RequestService rs = new RequestService(em);
		Response response = null;
		
		try {
			
			rs.createRequest(cohabitRequestInfo.getId(), cohabitRequestInfo.getFlatmateId());
			UriBuilder ub = uriInfo.getAbsolutePathBuilder();
			URI newRequestUri = ub.path(Long.toString(cohabitRequestInfo.getId())).build();
			response = Response.created(newRequestUri).build();
			
			
		} catch(Exception e) {
			
			HttpError error = HttpError.httpForbiddenError(e.getMessage());
			response = Response.status(Status.FORBIDDEN).entity(Entity.entity(error, MediaType.APPLICATION_JSON))
					.build();
			
		}
		
		em.close();
		
		return response;
		
		
	}
	

	

	
	
}
