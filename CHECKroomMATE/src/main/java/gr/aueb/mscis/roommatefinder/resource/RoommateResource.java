package main.java.gr.aueb.mscis.roommatefinder.resource;

import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.FLATMATES;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.RESIDENTS;

import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.ROOMMATES;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
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
	
	@GET
	@Path(FLATMATES)
	@Produces(MediaType.APPLICATION_JSON)
	public List<RoommateInfo> listAllFlatmates(){
		EntityManager em = getEntityManager();
		
		ProfileFlatmateService service = new ProfileFlatmateService(em);
		@SuppressWarnings("unchecked")
		List<Roommate> flatmates =(List<Roommate>)(List<?>)service.findAllFlatmates();
		List<RoommateInfo> flatmateInfo = RoommateInfo.wrap(flatmates);
		
		em.close();
		
		return flatmateInfo;
	}
	
	
	@GET
	@Path(RESIDENTS)
	@Produces(MediaType.APPLICATION_JSON)
	public List<RoommateInfo> listAllResidents(){
		EntityManager em = getEntityManager();
		
		ProfileResidentService service = new ProfileResidentService(em);
		@SuppressWarnings("unchecked")
		List<Roommate> residents =(List<Roommate>)(List<?>)service.findAllResidents();
		List<RoommateInfo> flatmateInfo = RoommateInfo.wrap(residents);
		
		em.close();
		
		return flatmateInfo;
	}
	
	@PUT
	@Path("{residentId:[0-9]*}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateResident(RoommateInfo residentInfo) {
		EntityManager em = getEntityManager();
		
		boolean check = residentInfo.getRoommate(em).validateFields();
		Roommate resident = null;
		if(check) {
			resident = residentInfo.getRoommate(em);
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
		int numOfFlatmates = 0;
		int ageRange = 0;
		boolean petRule = true;
		Set<String> preferedHabits = null;
		String preferedWorkSchedule = "";
		status preferedProfession = null;
		boolean guests = true;
		String genderChoice = "";
		Set<Double> rating = null;
		CellNumber phoneNumber = null;
		EmailAddress email = null;
		
		service.updatePersonalDetails(username, password, email, phoneNumber, name, surname, age, numOfFlatmates,
				 ageRange, preferedHabits, petRule, preferedWorkSchedule, rating, genderChoice, guests, preferedProfession, 
				 id);
		
		em.close();		
		
		return Response.ok().build();
	}
	
//	@PUT
//	@Path("{roommateId:[0-9]*}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response updateRoommate(RoommateInfo roommateInfo) {
//		EntityManager em = getEntityManager();
//		
//		boolean check = roommateInfo.getRoommate(em).validateFields();
//		Roommate roommate = null;
//		if(check) {
//			roommate = roommateInfo.getRoommate(em);
//		}else {
//			return Response.status (Status.NOT_ACCEPTABLE).build();
//		}
//		AuthenticationService service = new AuthenticationService(em);
//		
//		String username = roommate.getUsername();
//		String password = roommate.getPassword();
//		String name = roommate.getName();
//		String surname = roommate.getSurname();
//		int age = roommate.getAge();
//		
//		service.signUp(username, password, name, surname, age);
//		
//		em.close();
//		
//		return Response.ok().build();
//	}
}
