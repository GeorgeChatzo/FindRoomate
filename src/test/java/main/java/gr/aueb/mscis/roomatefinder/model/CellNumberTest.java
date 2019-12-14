package main.java.gr.aueb.mscis.roomatefinder.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;

public class CellNumberTest {
	
	@Test
	public void equalsAndHashCode() {
        BasicEqualTester<CellNumber> equalsTester = new BasicEqualTester<CellNumber>();
        
        equalsTester.setObjectUnderTest(new CellNumber(null));
        equalsTester.otherObjectIsNull();
        equalsTester.otherObjectIsOfDifferentType(new Object());
        equalsTester.bothObjectsHaveNoState(new CellNumber(null));
        
        equalsTester.setObjectUnderTest(new CellNumber("123"));        
        equalsTester.otherObjectIsNull();
        equalsTester.otherObjectsHasNoState(new CellNumber(null));
        equalsTester.objectsHaveDifferentState(new CellNumber("321"));
        equalsTester.sameReferences(equalsTester.getObjectUnderTest());
        equalsTester.bothObjectsHaveSameState(new CellNumber("123"));
    }
	
	
	@Test
	public void TestToString() {
		
		CellNumber number = new CellNumber("210123456");
		assertTrue(number.toString().equals("210123456"));
	}
	
	@Test
	public void TestValid() {
		
		CellNumber number = new CellNumber("210123456");
		assertTrue(number.isValid()==true);
	}
	
	@Test
	public void TestEquals() {
		
		CellNumber number1 = new CellNumber(null);
		CellNumber number2 = new CellNumber("2");
		assertFalse(number1.equals(number2));

	}
	

}
