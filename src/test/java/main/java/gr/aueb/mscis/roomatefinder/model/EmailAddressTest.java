package main.java.gr.aueb.mscis.roomatefinder.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;



public class EmailAddressTest {
	
	@Test
    public void equalsAndHashCode() {
        
        BasicEqualTester<EmailAddress> equalsTester = new BasicEqualTester<EmailAddress>();
                        
        equalsTester.setObjectUnderTest(new EmailAddress(null));        
        
        
        equalsTester.otherObjectIsOfDifferentType(new Object());            
        
        equalsTester.bothObjectsHaveNoState(new EmailAddress(null));
        
        equalsTester.setObjectUnderTest(new EmailAddress("a@b.gr"));
        equalsTester.otherObjectIsNull();
        equalsTester.otherObjectsHasNoState(new EmailAddress(null));        
        equalsTester.objectsHaveDifferentState(new EmailAddress("123@123.com"));        
        equalsTester.bothObjectsHaveSameState(new EmailAddress("a@b.gr"));

        EmailAddress email2 = equalsTester.getObjectUnderTest();
        equalsTester.sameReferences(email2);        
    }
	
	@Test
	public void TestToString() {
		
		EmailAddress mail = new EmailAddress("aueb@gmail.gr");
		assertTrue(mail.toString().equals("aueb@gmail.gr"));
	}
	
	@Test
	public void TestValid() {
		
		EmailAddress mail = new EmailAddress("aueb@gmail.gr");
		assertTrue(mail.isValid()==true);
	}
	
	@Test
	public void TestEquals() {
		
		EmailAddress mail = new EmailAddress(null);
		EmailAddress mail2 = new EmailAddress("aueb@gmail.gr");
		assertFalse(mail.equals(mail2));

	}
	

}
