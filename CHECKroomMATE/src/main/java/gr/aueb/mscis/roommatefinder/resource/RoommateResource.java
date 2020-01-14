package main.java.gr.aueb.mscis.roommatefinder.resource;

import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.ROOMMATES;

import java.net.URI;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.model.Roommate;
import main.java.gr.aueb.mscis.roommatefinder.model.status;
import main.java.gr.aueb.mscis.roommatefinder.service.AuthenticationService;
import main.java.gr.aueb.mscis.roommatefinder.service.ProfileFlatmateService;
import main.java.gr.aueb.mscis.roommatefinder.service.ProfileResidentService;
import main.java.gr.aueb.mscis.roommatefinder.service.PublishAdService;

@Path (ROOMMATES)
public class RoommateResource extends AbstractResource {
	
	@Context
	UriInfo uriInfo;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RoommateInfo> listAllRoommates(){
	EntityManager em = getEntityManager();
		
	AuthenticationService service = new AuthenticationService(em);
	List<Roommate> roommates = service.findAllRoommates();
	List<RoommateInfo> roommateInfo = RoommateInfo.wrap(roommates);
		
	em.close();
		
	return roommateInfo;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createRoommate(RoommateInfo roommateInfo) {
	EntityManager em = getEntityManager();
		
	boolean check = roommateInfo.getRoommate(em).validateFields();
	Roommate roommate = null;
	if(check) {
	roommate = roommateInfo.getRoommate(em);
	}
	else {
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
	AuthenticationService service = new AuthenticationService(em);
	
	String username = roommate.getUsername();
	String password = roommate.getPassword();
	String name = roommate.getName();
	String surname = roommate.getSurname();
	int age = roommate.getAge();
	
	service.signUp(username, password, name, surname, age);
	
	UriBuilder ub = uriInfo.getAbsolutePathBuilder();
	URI newRoommateUri = ub.path(Long.toString(roommate.getId())).build();

	
	em.close();
	
	return Response.ok().build();
	}	
	
	
	@DELETE
	@Path("{rommateId:[0-9]*}")
	public Response deleteRoommate(@PathParam("roommate") Roommate roommate) {
		EntityManager em = getEntityManager();
		
		AuthenticationService service = new AuthenticationService(em);
		boolean result = service.deleteRoommate(roommate);
		
		if (!result) {
			em.close();
			return Response.status(Status.NOT_FOUND).build();
		}

		em.close();
		return Response.ok().build();
		
	}
	
	
}
