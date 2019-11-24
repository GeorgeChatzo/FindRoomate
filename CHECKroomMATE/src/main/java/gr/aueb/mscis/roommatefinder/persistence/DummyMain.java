package main.java.gr.aueb.mscis.roommatefinder.persistence;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Assert;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.model.status;


public class DummyMain {
	
	public static void main(String[]args) {
		
        
        CellNumber cell = new CellNumber("69445458");
        EmailAddress email = new EmailAddress("exmple@example.com");
        Set<String> habits = null ;
        Set<Double> rating = null;
        Set<String> preferedHabits = null;
        
        Resident resident = new Resident("santa","25",email,cell,"Santa","Claus",1000,4,34,preferedHabits,true,"No job",status.UNEMPLOYED,
        		false,"female",rating);
        
        HouseAd advertisment = new HouseAd("New house at Galatsi",500.0,"GeorgeChatzo/photos/eikona1.jpg","Neodmito spiti diamperes",2); 
        resident.addHouseAd(advertisment);
        EntityManager em = JPAUtil.getCurrentEntityManager();
       
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        double Expected_Rent_Price = 500.0;
       
        em.persist(resident);
        tx.commit();

	       
        Query query = em.createQuery("select resident from Resident resident");
        //query.setLockMode(LockModeType.PESSIMISTIC_WRITE);
        List<HouseAd> results = query.getResultList(); 
        System.out.println(results.get(0));
	}
	

}
