package main.java.gr.aueb.mscis.sample.persistence;

import javax.persistence.*;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;



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

        query = em.createNativeQuery("");
        query.executeUpdate();
        
        tx.commit();
        
    }
    

    public void prepareData() {

        eraseData();                      

        //Movie terminator = new Movie("Snowden", 2016, "Oliver Stone");
        //Movie inception = new Movie("Inception", 2010, "Christopher Nolan");
       
        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //em.persist(terminator);
       // em.persist(inception);
        
        tx.commit();
    
    }
}
