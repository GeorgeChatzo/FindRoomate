package main.java.gr.aueb.mscis.roomatefinder.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



import org.junit.Before;
import org.junit.Test;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.Roommate;


public class RoommateTest {
	
	Roommate rommate;
	
	@Before
	public void setUp() {
		
		rommate = new Roommate("GChatz","qwerty123","George","Chatzopoulos",22);
		
	}
	
	
	@Test
	public void testRoomateConstructor() {
		

		Roommate rommateNew = new Roommate("GChatz","qwerty123","George","Chatzopoulos",22);
	
		assertTrue(rommateNew.getUsername().equals("GChatz"));
		assertTrue(rommateNew.getPassword().equals("qwerty123"));
		assertTrue(rommateNew.getName().equals("George"));
		assertTrue(rommateNew.getSurname().equals("Chatzopoulos"));
		assertEquals(rommateNew.getAge(),22);


	}
	
	@Test
	public void testRoomateEmptyConstructor() {
		
		rommate.setName("er");
		rommate.setSurname("po");
		rommate.setUsername("valkerian");
		rommate.setPassword("123");
		rommate.setAge(21);

		assertTrue(rommate.getUsername().equals("valkerian"));
		assertTrue(rommate.getPassword().equals("123"));
		assertTrue(rommate.getName().equals("er"));
		assertTrue(rommate.getSurname().equals("po"));

		assertEquals(rommate.getAge(),21);

		

	}
	
	@Test
	public void testValidateFields1() {
		
		rommate.setName("er");
		rommate.setSurname("po");
		rommate.setUsername("valkerian");
		rommate.setPassword("123");
		rommate.setAge(21);

		assertTrue(rommate.validateFields());
		
	}
	
	@Test
	public void testValidateFields2() {
		
		rommate.setName(null);
		rommate.setSurname("po");
		rommate.setUsername("valkerian");
		rommate.setPassword("123");
		rommate.setAge(21);
		assertFalse(rommate.validateFields());
		
	}
	
	@Test
	public void testValidateFields3() {
		
		rommate.setName("er");
		rommate.setSurname(null);
		rommate.setUsername("valkerian");
		rommate.setPassword("123");
		rommate.setAge(21);
		assertFalse(rommate.validateFields());
		
	}
	
	@Test
	public void testValidateFields4() {
		
		rommate.setName("er");
		rommate.setSurname("new");
		rommate.setUsername(null);
		rommate.setPassword("123");
		rommate.setAge(21);
		assertFalse(rommate.validateFields());
		
	}
	
	@Test
	public void testValidateFields5() {
		
		rommate.setName("er");
		rommate.setSurname("new");
		rommate.setUsername("jddd");
		rommate.setPassword(null);
		rommate.setAge(21);
		assertFalse(rommate.validateFields());
		
	}
	
	@Test
	public void testValidateFields6() {
		
		rommate.setName("er");
		rommate.setSurname("new");
		rommate.setUsername("jddd");
		rommate.setPassword("123");
		rommate.setAge(0);
		assertFalse(rommate.validateFields());
		
	}
	
	@Test
	public void testObjects() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		assertTrue(r11.equals(rl2));
		
	}
	
	@Test
	public void testObject() {
		
		assertTrue(rommate.equals(rommate));
		
	}
	
	@Test
	public void testOtherObject() {
		
		Roommate rl1 = new Roommate();
		HouseAd ad1 = new HouseAd();
		assertFalse(rl1.equals(ad1));
		
	}
	
	@Test
	public void testNullObject() {
		
		Roommate rl1  = new Roommate ();
		Roommate fl2 = null;
		assertFalse(rl1.equals(fl2));
		
	}
	
	@Test
	public void testAgeeq1() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		r11.setAge(15);
		rl2.setAge(18);
		assertFalse(r11.equals(rl2));
		
	}
	
	@Test
	public void testusername1() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		r11.setUsername("empty2");
		rl2.setUsername("empty1");
		assertFalse(r11.equals(rl2));
		
	}
	
	@Test
	public void testusername2() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		r11.setUsername(null);
		r11.setUsername("empty1");
		assertFalse(r11.equals(rl2));
		
	}
	
	@Test
	public void testusername3() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		r11.setUsername("empty1");
		rl2.setUsername("empty1");
		assertTrue(r11.equals(rl2));
		
	}
	
	//
	@Test
	public void testname1() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		r11.setName("empty2");
		rl2.setName("empty1");
		assertFalse(r11.equals(rl2));
		
	}
	
	@Test
	public void testname2() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		r11.setName(null);
		r11.setName("empty1");
		assertFalse(r11.equals(rl2));
		
	}
	
	@Test
	public void testname3() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		r11.setName("empty1");
		rl2.setName("empty1");
		assertTrue(r11.equals(rl2));
		
	}
	
	//
	@Test
	public void testsurname1() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		r11.setSurname("empty2");
		rl2.setSurname("empty1");
		assertFalse(r11.equals(rl2));
		
	}
	
	@Test
	public void testsurname2() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		r11.setSurname(null);
		r11.setSurname("empty1");
		assertFalse(r11.equals(rl2));
		
	}
	
	@Test
	public void testsurnname3() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		r11.setSurname("empty1");
		rl2.setSurname("empty1");
		assertTrue(r11.equals(rl2));
		
	}
	
//
	//
	@Test
	public void testPassword1() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		r11.setPassword("empty2");
		rl2.setPassword("empty1");
		assertFalse(r11.equals(rl2));
		
	}
	
	@Test
	public void testPassowrd2() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		r11.setPassword(null);
		r11.setPassword("empty1");
		assertFalse(r11.equals(rl2));
		
	}
	
	@Test
	public void testPassowrd3() {
		
		Roommate r11 = new Roommate();
		Roommate rl2 = new Roommate();
		r11.setPassword("empty1");
		rl2.setPassword("empty1");
		assertTrue(r11.equals(rl2));
		
	}


	

}
