package main.java.gr.aueb.mscis.roommatefinder.persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Cohabitance;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.House;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.RequestState;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.model.Roommate;
import main.java.gr.aueb.mscis.roommatefinder.model.status;


public class Initializer  {
	 public static  long resident1_id =1;
	 public static  long rommate_id =1;
	 public static  long flatmate_id=2;
	 public static  long house_id=3;
	 public static  long house_Adid=4;
	 public static  long cohabitance_id=5;
	 public static  long cohabitrequest_id=6;
	 
	
    /**
     * Remove all data from database.
     * The functionality must be executed within the bounds of a transaction
     */
    public void  eraseData() {
        EntityManager em = JPAUtil.getCurrentEntityManager();
       
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Query query = em.createNativeQuery("delete from cohabitance");
        query.executeUpdate();
        query = em.createNativeQuery("delete from cohabitrequests");
        query.executeUpdate();
        query = em.createNativeQuery("delete from flatmates");
        query.executeUpdate();
        query = em.createNativeQuery("delete from houseads");
        query.executeUpdate();
        query = em.createNativeQuery("delete from residents");
        query.executeUpdate();
        query = em.createNativeQuery("delete from roommate");
        query.executeUpdate();
        query = em.createNativeQuery("delete from house");
        query.executeUpdate();
        
        tx.commit();
        em.close();

    }
   
    public void prepareData() throws ParseException {

        eraseData();                      

        CellNumber cell = new CellNumber("69445458");
        EmailAddress email = new EmailAddress("exmple@example.com");
        Set<String> habits = null ;
        Set<Double> rating = null;
        Set<String> preferedHabits = null;
        
        Roommate roommate = new Roommate("james","12345","james","bond",35);
        
        Resident resident = new Resident("santa","25",email,cell,"Santa","Claus",1000,4,34,preferedHabits,true,"No job",status.UNEMPLOYED,
        		false,"female",rating);
        
        Flatmate flatmate = new Flatmate("me", "1234", email, cell, "Santa",
    			"Claus", 65, "fantastic xooxo","male", status.EMPLOYEE, true,
    			habits, "Christmas",true, rating);
        House house = new House("Greece","Athens","Galatsi",1111,"Diamerisma",3,false,115,true,true,1,5,1995,"Hlketrikos");

        HouseAd advertisment = new HouseAd("super","New house at Galatsi",500.0,"GeorgeChatzo/photos/eikona1.jpg","Neodmito spiti diamperes",2); 
        resident.addHouseAd(advertisment);
        resident.setHouse(house);
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date date = format.parse ( "2019-12-31" ); 
        Date dateEnd = format.parse ( "2020-12-31" );  
        Cohabitance cohabitance = new Cohabitance(50.0,false,date, dateEnd);
        CohabitRequest cohabitRequest = flatmate.request(advertisment);
        cohabitance.setRequest(cohabitRequest);
        
        //accepted
        Cohabitance cohabitanceAccepted= new Cohabitance(50.0,false,date, dateEnd);
        CohabitRequest cohabitRequestAccepted = flatmate.request(advertisment);
        cohabitRequestAccepted.setState(RequestState.ACCEPTED);
        cohabitanceAccepted.setRequest(cohabitRequestAccepted);
        
        
        
        EntityManager em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(roommate);
        em.persist(resident);
        em.persist(flatmate);
		em.persist(cohabitance);
		em.persist(cohabitanceAccepted);
        
        tx.commit();
        em.close();
        
        resident1_id = resident.getId();
        flatmate_id= flatmate.getId();
        house_id= house.getId();
        house_Adid= advertisment.getId();
        cohabitance_id= cohabitance.getId();
        cohabitrequest_id= cohabitRequest.getId();
        
        


    
    }
}
