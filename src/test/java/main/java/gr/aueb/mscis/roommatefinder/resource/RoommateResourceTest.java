package main.java.gr.aueb.mscis.roommatefinder.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.spi.TestContainerFactory;

import main.java.gr.aueb.mscis.roommatefinder.persistence.JPAUtil;
import main.java.gr.aueb.mscis.roommatefinder.service.RequestService;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.persistence.Initializer;


public abstract class RoommateResourceTest extends JerseyTest {
	
	Initializer dataHelper;
	
	public RoommateResourceTest() {
		super();
	}
	 
	public RoommateResourceTest(TestContainerFactory testContainerFactory) {
		super(testContainerFactory);
	}
	
	public RoommateResourceTest(Application jaxrsApplication) {
		super(jaxrsApplication);
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		dataHelper = new Initializer();
		dataHelper.prepareData();
	}
	
	public List<Resident> listResidents() {
		EntityManager em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		List<Resident> residents = em.createQuery("select r from Resident r").getResultList();
		
		tx.commit();
		em.close();
		
		return residents;
	}
	
	
	public List<Flatmate> listFlatmates() {
		EntityManager em = JPAUtil.getCurrentEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		List<Flatmate> flatmates = em.createQuery("select r from Flatmate r").getResultList();
		
		tx.commit();
		em.close();
		
		return flatmates;
	}
	
	public List<HouseAd> listAllHouseAds() {
		EntityManager em = JPAUtil.getCurrentEntityManager();
		RequestService service = new RequestService(em);
		List<HouseAd> houseAds = service.findAllHouseAds();
		
		return houseAds;
	}

}
