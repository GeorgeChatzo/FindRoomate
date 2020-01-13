package main.java.gr.aueb.mscis.roommatefinder.resource;

import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.RESIDENTS;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.model.status;
import main.java.gr.aueb.mscis.roommatefinder.service.ProfileResidentService;


@Path(RESIDENTS)
public class ResidentResource extends AbstractResource {
	
	@Context
	UriInfo uriInfo;
	
	@GET
	@Path("{residentId:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResidentInfo getResidentDetails(@PathParam("residents") long residentId) {
		EntityManager em = getEntityManager();
		
		ProfileResidentService service = new ProfileResidentService(em);
		Resident resident = service.findResidentById(residentId);
		ResidentInfo residentInfo = ResidentInfo.wrap(resident);
		
		em.close();
		return residentInfo;
	}
	
	@PUT
	@Path("{residentId:[0-9]*}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateResident(ResidentInfo residentInfo) {
		EntityManager em = getEntityManager();
		
		boolean check = residentInfo.getResident(em).validateFieldsResource();;
		Resident resident = null;
		if(check) {
			resident = residentInfo.getResident(em);
		}else {
			return Response.status (Status.NOT_ACCEPTABLE).build();
		}
		ProfileResidentService service = new ProfileResidentService(em);
		long id = resident.getId();
		String username = resident.getUsername();
		String password = resident.getPassword();
		String name = resident.getName();
		String surname = resident.getSurname();
		int age = resident.getAge();
		int numOfFlatmates = resident.getNumOfFlatmates();
		int ageRange = resident.getAgeRange();
		boolean petRule = resident.isPetRule();
		Set<String> preferedHabits = resident.getPreferedHabits();
		String preferedWorkSchedule = resident.getPreferedWorkSchedule();
		status preferedProfession = resident.getPreferedProfession();
		boolean guests = resident.isGuests();
		String genderChoice = resident.getGenderChoice();
		Set<Double> rating = resident.getRating();
		CellNumber phoneNumber = resident.getPhoneNumber();
		EmailAddress email = resident.getEmail();
		
		service.updatePersonalDetails(username, password, email, phoneNumber, name, surname, age, numOfFlatmates,
				 ageRange, preferedHabits, petRule, preferedWorkSchedule, rating, genderChoice, guests, preferedProfession, 
				 id);
		
		em.close();		
		
		return Response.ok().build();
	}

}
