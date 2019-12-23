package main.java.gr.aueb.mscis.roommatefinder.resource;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.FLATMATES;

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
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.status;
import main.java.gr.aueb.mscis.roommatefinder.service.ProfileFlatmateService;
import main.java.gr.aueb.mscis.roommatefinder.service.PublishAdService;

import javax.ws.rs.core.Response.Status;

@Path (FLATMATES)
public class FlatmateResource extends AbstractResource {

	@Context
	UriInfo uriInfo;
	
	@GET
	@Path("{flatmateId:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public FlatmateInfo getHouseAdDetails(@PathParam("flatmates") long flatmateId) {
		EntityManager em = getEntityManager();
		
		ProfileFlatmateService service = new ProfileFlatmateService(em);
		Flatmate flatmate = service.findFlatmateById(flatmateId);
		FlatmateInfo flatmateInfo = FlatmateInfo.wrap(flatmate);
		
		em.close();
		
		return flatmateInfo;
		}
	
	@PUT
	@Path("{flatmateId:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFlatmate(FlatmateInfo flatmateInfo) {
		EntityManager em = getEntityManager();
		
		boolean check = flatmateInfo.getFlatmate(em).validateFields();
		Flatmate flatmate = null;
		if(check) {
			flatmate = flatmateInfo.getFlatmate(em);
		}
		else {
			return Response.status (Status.NOT_ACCEPTABLE).build();
		}
		
		ProfileFlatmateService service = new ProfileFlatmateService(em);
		String description = flatmate.getDescription();
		String gender = flatmate.getGender();
		status profession = flatmate.getProfession();
		boolean pets = flatmate.isPets();
		String workSchedule = flatmate.getWorkSchedule();
		boolean incomingGuests = flatmate.isIncomingGuests();
		Set<Double> rating = flatmate.getRating();
		Set<String> habits = flatmate.getHabits();
		EmailAddress email = flatmate.getEmail();
		CellNumber phoneNumber = flatmate.getPhoneNumber();
		
		service.updatePersonalDetails(description, gender, profession, pets, 
				workSchedule, incomingGuests, rating, habits, email, phoneNumber);
		
		em.close();
		
		return Response.ok().build();
	}
	
}
