package main.java.gr.aueb.mscis.roommatefinder.persistence;

import javax.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Assert;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Cohabitance;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.House;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.model.status;
import main.java.gr.aueb.mscis.roommatefinder.service.RequestService;


public class DummyMain {
	
	public static void main(String[]args) throws ParseException {
		
        
        CellNumber cell = new CellNumber("69445458");
        EmailAddress email = new EmailAddress("exmple@example.com");
        Set<String> habits = null ;
        Set<Double> rating = null;
        Set<String> preferedHabits = null;
        
        Flatmate flatmate = new Flatmate("me", "1234", email, cell, "Santa",
    			"Claus", 65, "fantastic xooxo","male", status.EMPLOYEE, true,
    			habits, "Christmas",true, rating);
        
        Resident resident = new Resident("santa","25",email,cell,"Santa","Claus",1000,4,34,preferedHabits,true,"No job",status.UNEMPLOYED,
        		false,"female",rating);
        House house = new House("Greece","Athens","Galatsi",1111,"Diamerisma",3,false,115,true,true,1,5,1995,"Hlketrikos");

        resident.setHouse(house);
           
        HouseAd advertisment = new HouseAd("super","New house at Galatsi",500.0,"GeorgeChatzo/photos/eikona1.jpg","Neodmito spiti diamperes",2); 
        resident.addHouseAd(advertisment);
        //advertisment.setResident(resident);
       // resident.addHouseAd(advertisment);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        double Expected_Rent_Price = 500.0;

        String dateString = format.format( new Date()   );
        Date   date       = format.parse ( "2009-12-31" );  
        Cohabitance coh = new Cohabitance(50.0,false,date, date);
        
        EntityManager em = JPAUtil.getCurrentEntityManager();
       
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(flatmate);
        em.persist(resident);
        
        //em.persist(advertisment);
        //em.persist(house);
        //tx.commit();
        
       // List<HouseAd> results = null;
        
       // EntityTransaction tx = em.getTransaction();
		//tx.begin();
		//HouseAd houseAd = em.find(HouseAd.class, 5L);
		CohabitRequest cohabitRequest = flatmate.request(advertisment);
		coh.setRequest(cohabitRequest);
		//cohabitRequest.setCohitance(coh);
		//em.persist(cohabitRequest);
		em.persist(coh);
		tx.commit();
	       
        //Query query = em.createQuery("select resident from Resident resident");
        //Resident residentPrint = em.find(Resident.class, 1L);
       // Boolean ad = residentPrint.getHouseAds().contains(advertisment);
		// results = em.createQuery("select houseAd from HouseAd houseAd" , HouseAd.class).getResultList();
        //RequestService rs = new RequestService(em);
        //boolean create = rs.createRequest(1,flatmate);
        
        System.out.println(cohabitRequest.toString());
        
		List<CohabitRequest> results = null;
		results = em
				.createQuery(
						"select c from CohabitRequest c where c.houseAd.resident.id = :residentId ")
				.setParameter("residentId", 2L).getResultList();
		
		
		System.out.println(results);
		List<HouseAd> results1 = null;
		
		System.out.println("end");

		Query query = em.createQuery("select houseAd from HouseAd houseAd");
        results1 = query.getResultList(); 
        System.out.println(results1);
        
        System.out.println("end2");
		List<House> results3 = null;

		Query query2 = em.createQuery("select house from House house");
        results3 = query2.getResultList(); 
        System.out.println(results3);
        
        
		
        
        
	}
	

}
