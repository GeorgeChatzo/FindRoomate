package main.java.gr.aueb.mscis.roommatefinder.service;

import static org.junit.Assert.*;

import java.text.ParseException;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.persistence.Initializer;
import main.java.gr.aueb.mscis.roommatefinder.persistence.JPAUtil;


public abstract class RoommateServiceTest {

	Initializer dataHelper;
	protected EntityManager em;

	public RoommateServiceTest() {
		super();
	}
	
	protected void beforeDatabasePreparation(){}
	
	protected void afterDatabasePreparation(){}

	@Before
	public final void setUp() throws ParseException {
		beforeDatabasePreparation();
		dataHelper = new Initializer();
		dataHelper.prepareData();
		em = JPAUtil.getCurrentEntityManager();
		afterDatabasePreparation();
	}

	protected void afterTearDown(){}
	
	@After
	public final void tearDown() {
		em.close();
		afterTearDown();
	}

}
