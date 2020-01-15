package main.java.gr.aueb.mscis.roommatefinder.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.java.gr.aueb.mscis.roommatefinder.model.Roommate;

public class AuthenticationServiceTest extends RoommateServiceTest {

	@Test
	public void loginSuccessfulTest() {
		AuthenticationService service = new AuthenticationService(em);
		Roommate roommate = new Roommate("james","12345","james","bond",35);
		String username = "james";
		String password = "12345";
		
		boolean login = service.login(roommate, username, password);
		
		assertTrue(login);
	}
	
	@Test
	public void loginFailedTest() {
		AuthenticationService service = new AuthenticationService(em);
		Roommate roommate = new Roommate("james","12345","james","bond",35);
		String username = "james";
		String password = "123456";
		
		boolean login = service.login(roommate, username, password);
		
		assertFalse(login);
	}
	
	@Test
	public void signUpSuccessfulTest() {
		AuthenticationService service = new AuthenticationService(em);
		Roommate roommate = new Roommate("james","12345","james","bond",35);
		
		boolean signup = service.signUp(roommate.getUsername(), roommate.getPassword(), 
				roommate.getName(), roommate.getSurname(), roommate.getAge());
		
		assertTrue(signup);
		
		
	}
	
	
	@Test
	public void signUpFailedTest() {
		AuthenticationService service = new AuthenticationService(em);
		Roommate roommate = new Roommate(null,"12345","james","bond",35);
		
		boolean signup = service.signUp(roommate.getUsername(), roommate.getPassword(), 
				roommate.getName(), roommate.getSurname(), roommate.getAge());
		
		assertFalse(signup);
		
		
		
	}

}
