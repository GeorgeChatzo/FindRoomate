package main.java.gr.aueb.mscis.roommatefinder.resource;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.spi.TestContainerFactory;

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

}
