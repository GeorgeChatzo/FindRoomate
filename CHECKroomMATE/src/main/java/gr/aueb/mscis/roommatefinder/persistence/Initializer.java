package main.java.gr.aueb.mscis.roommatefinder.persistence;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.status;

//import gr.aueb.mscis.sample.model.Movie;


public class Initializer  {


    /**
     * Remove all data from database.
     * The functionality must be executed within the bounds of a transaction
     */
    public void  eraseData() {
        EntityManager em = JPAUtil.getCurrentEntityManager();
       
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = null;

        query = em.createNativeQuery(""); //remove  TODO
        query.executeUpdate();
        
        tx.commit();
        
    }
    

    public void prepareData() {

        eraseData();                      

   
        CellNumber cell = new CellNumber("69445458");
        EmailAddress email = new EmailAddress("exmple@example.com");
        Set<String> habits = null ;
        Set<Double> rating = null;
        
       
        Flatmate flatmate = new Flatmate("me", "1234", email, cell, "Santa",
    			"Claus", 65, "fantastic xooxo","male", status.EMPLOYEE, true,
    			habits, "Christmas",true, rating);
        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        em.persist(flatmate);
    
        
        tx.commit();
    
    }
}
