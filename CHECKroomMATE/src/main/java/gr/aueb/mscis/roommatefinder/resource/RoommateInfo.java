package main.java.gr.aueb.mscis.roommatefinder.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.model.Roommate;
import main.java.gr.aueb.mscis.roommatefinder.model.status;

@XmlRootElement
public class RoommateInfo {
	
	private long id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private int age;
	
	
	public RoommateInfo() {
	}
	
	public RoommateInfo(long id, String username, String password, String name,String surname, int age) {
		this(username, password, name, surname, age);
		this.id = id;
		
	}
	
	public RoommateInfo(String username, String password, String name, String surname, int age) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	
	public RoommateInfo(Roommate roommate) {
		
		id = roommate.getId();
		username = roommate.getUsername();
		password = roommate.getPassword();
		name = roommate.getName();
		surname = roommate.getSurname();
		age = roommate.getAge();
	}
	

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	

	
	public static List<RoommateInfo> wrap(List<Roommate> roommates) {
		List<RoommateInfo> roommateInfoList = new ArrayList<>();
		
		for (Roommate roommate : roommates) {
			roommateInfoList.add(new RoommateInfo(roommate));
			}
		return roommateInfoList;
	}

	public static RoommateInfo wrap(Roommate roommate) {
		return new RoommateInfo(roommate);
	}
	
	public static RoommateInfo wrap(Resident roommate) {
		return new RoommateInfo(roommate);
	}
	
	public Roommate getRoommate(EntityManager em) {
		Roommate roommate = null;
		
		if(id<=-1) {
			roommate = em.find(Roommate.class, id);
		}else {
			roommate = new Roommate();
		}
		
		roommate.setId(id);
		roommate.setUsername(username);
		roommate.setPassword(password);
		roommate.setName(name);
		roommate.setSurname(surname);
		roommate.setAge(age);
		
		return roommate;		
	}
	
	


}