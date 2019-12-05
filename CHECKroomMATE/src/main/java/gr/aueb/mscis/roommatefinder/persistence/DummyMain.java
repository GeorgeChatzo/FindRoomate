package main.java.gr.aueb.mscis.roommatefinder.persistence;

import javax.persistence.*;

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
	
	public static void main(String[]args) {
		
        
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
           
        HouseAd advertisment = new HouseAd("super","New house at Galatsi",500.0,"GeorgeChatzo/photos/eikona1.jpg","Neodmito spiti diamperes",2); 
        resident.addHouseAd(advertisment);
        //advertisment.setResident(resident);
       // resident.addHouseAd(advertisment);
        Cohabitance coh = new Cohabitance(50.0,false);
        
        House house = new House("Greece","Athens","Galatsi",1111,"Diamerisma",3,false,115,true,true,1,5,1995,"Hlketrikos");
        EntityManager em = JPAUtil.getCurrentEntityManager();
       
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        double Expected_Rent_Price = 500.0;
        em.persist(flatmate);
        em.persist(resident);
        
        //em.persist(advertisment);
        //em.persist(house);
        //tx.commit();
        
       // List<HouseAd> results = null;
        
       // EntityTransaction tx = em.getTransaction();
		//tx.begin();
		HouseAd houseAd = em.find(HouseAd.class, 3L);
		CohabitRequest cohabitRequest = flatmate.request(houseAd);
		coh.setRequest(cohabitRequest);
		//cohabitRequest.setCohitance(coh);
		em.persist(cohabitRequest);
		em.persist(coh);
		tx.commit();
	       
        //Query query = em.createQuery("select resident from Resident resident");
        //Resident residentPrint = em.find(Resident.class, 1L);
       // Boolean ad = residentPrint.getHouseAds().contains(advertisment);
		// results = em.createQuery("select houseAd from HouseAd houseAd" , HouseAd.class).getResultList();
        //RequestService rs = new RequestService(em);
        //boolean create = rs.createRequest(1,flatmate);
        
        System.out.println(cohabitRequest.toString());
	}
	

}
