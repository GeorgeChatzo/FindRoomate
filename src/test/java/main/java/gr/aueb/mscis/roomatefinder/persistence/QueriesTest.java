package main.java.gr.aueb.mscis.roomatefinder.persistence;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.persistence.Initializer;
import main.java.gr.aueb.mscis.roommatefinder.persistence.JPAUtil;


public class QueriesTest {

	private Initializer dataHelper;

    @Before
    public void setUpJpa() throws ParseException {
        dataHelper = new Initializer();
        dataHelper.prepareData();
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void simpleQuery() {
        int Expected_Flatmate_Number = 1;
        EntityManager em = JPAUtil.getCurrentEntityManager();
        Query query = em.createQuery("select flatmate from Flatmate flatmate");
        List<Flatmate> results = query.getResultList();      
        Assert.assertEquals(Expected_Flatmate_Number, results.size());
        
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testingHouseAd() {
    	int Expected_HouseAd_Number = 1;
        EntityManager em = JPAUtil.getCurrentEntityManager();
        Query query = em.createQuery("select houseAd from HouseAd houseAd");
        List<HouseAd> results = query.getResultList(); 
        Assert.assertEquals(Expected_HouseAd_Number,results.size());
        
        
    }

}
