package main.java.gr.aueb.mscis.roommatefinder.resource;
import static main.java.gr.aueb.mscis.roommatefinder.resource.RoommateUri.HOUSEADS;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.service.PublishAdService;
import main.java.gr.aueb.mscis.roommatefinder.service.RequestService;
import main.java.gr.aueb.mscis.roommatefinder.service.UpdateHouseAdService;

@Path(HOUSEADS)
public class HouseAdResource extends AbstractResource {
	
	@Context
	UriInfo uriInfo;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<HouseAdInfo> listAllHouseAds(){
		EntityManager em = getEntityManager();
		
		RequestService service = new RequestService(em);
		List<HouseAd> houseAds = service.findAllHouseAds();
		List<HouseAdInfo> houseAdInfo = HouseAdInfo.wrap(houseAds);
		
		em.close();
		
		return houseAdInfo;
	}
	
	@GET
	@Path("{houseAdId:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public HouseAdInfo getHouseAdDetails(@PathParam("houseAdId") long houseAdId) {
		EntityManager em = getEntityManager();
		
		PublishAdService service = new PublishAdService(em);
		HouseAd houseAd = service.findHouseAdById(houseAdId);
		HouseAdInfo houseAdInfo = HouseAdInfo.wrap(houseAd);
		
		em.close();
		
		return houseAdInfo;
		
	}
	 
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createHouseAd(HouseAdInfo houseAdInfo) {
		EntityManager em = getEntityManager();
		
		boolean check = houseAdInfo.getHouseAd(em).validate();
		HouseAd houseAd = null;
		if(check) {
		houseAd = houseAdInfo.getHouseAd(em);
		}
		else {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
		PublishAdService service = new PublishAdService(em);
		
		boolean result = service.createHouseAd(houseAd);
		if (!result) {
			em.close();
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder();
		URI newHouseAdUri = ub.path(Long.toString(houseAd.getId())).build();

		em.close();
		
		return Response.created(newHouseAdUri).build();
		
	}
	
	@PUT
	@Path("{houseAdId:[0-9]*}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateHouseAd(HouseAdInfo houseAdInfo) {
		EntityManager em = getEntityManager();
		System.out.println(houseAdInfo.getId());
		boolean check = houseAdInfo.getHouseAd(em).validate();
		HouseAd houseAd = null;
		if(check) {
		houseAd = houseAdInfo.getHouseAd(em);
		}
		else {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
		
		UpdateHouseAdService service = new UpdateHouseAdService(em);
		String name = houseAd.getName();
		String description = houseAd.getDescription();
		Double rentPrice = houseAd.getRentPrice();
		String photos = houseAd.getPhotos();
		String comments = houseAd.getComments();
		Integer numberOfRoommates = houseAd.getNumberOfRoommates();
		long houseAdid = houseAd.getId();
		long residentId = houseAd.getResident().getId();
		System.out.println(houseAdid);
		service.updateHouseAd(name, description, rentPrice, photos, comments, 
				numberOfRoommates, houseAdid, residentId);
		
		em.close();

		return Response.ok().build();
		
	}
	
	@DELETE
	@Path("{houseAdId:[0-9]*}")
	public Response deleteHouseAd(@PathParam("houseAdId") long houseAdId) {
		EntityManager em = getEntityManager();
		
		PublishAdService service = new PublishAdService(em);
		boolean result = service.deleteHouseAd(houseAdId);
		
		if (!result) {
			em.close();
			return Response.status(Status.NOT_FOUND).build();
		}

		em.close();
		return Response.ok().build();
		
	}

}
