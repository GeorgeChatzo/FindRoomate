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
import main.java.gr.aueb.mscis.roommatefinder.model.status;
import main.java.gr.aueb.mscis.roommatefinder.service.ProfileFlatmateService;

import javax.ws.rs.core.Response.Status;

@Path (FLATMATES)
public class FlatmateResource extends AbstractResource {

	@Context
	UriInfo uriInfo;
	
	@GET
	@Path("{flatmateId:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public FlatmateInfo getFlatmateDetails(@PathParam("flatmates") long flatmateId) {
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
		String username = flatmate.getUsername();
		String password = flatmate.getPassword();
		String name = flatmate.getName();
		String surname = flatmate.getSurname();
		int age = flatmate.getAge();
		long id = flatmate.getId();
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
		
		service.updatePersonalDetails(username, password, email, phoneNumber, name, surname, age, description, gender, profession,
				pets, habits, workSchedule, incomingGuests, rating, id) ;
		
		em.close();
		
		return Response.ok().build();
	}
	
}
