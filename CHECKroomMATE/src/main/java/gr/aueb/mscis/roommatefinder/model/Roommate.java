package main.java.gr.aueb.mscis.roommatefinder.model;


import java.util.List;

//Superclass Roommate 

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "roommate")
@Inheritance(strategy = InheritanceType.JOINED)
public class Roommate {
	
@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.AUTO)
 private long id;
	
	private String username;
	private String password;
	private String name;
	private String surname;
	private int age;
	
	/**
	 * Custom constructor. Initializes roommate fields.
	 * @param username
	 * @param password
	 * @param name
	 * @param surname
	 * @param age
	 */
	public Roommate(String username, String password, String name,
			String surname, int age) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	/**
	 * Default constructor
	 */
	public Roommate() {
		
	}
	
	/**
	 * Returns id of roommate
	 * @return roommate id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets an id for the roommate
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Returns username of roommate
	 * @return username
	 */ 
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets a username for roommate
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Returns roommate's password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets password for roommate
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Returns name of roommate
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets name of roommate
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns roommate's surname 
	 * @return surname 
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Sets surname for roommate
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * Returns roommate's age
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Sets roommate's age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * Return {@code true} if log in was valid 
	 * @param roommateList
	 * @param usernameInput
	 * @param passwordInput
	 * @return
	 */
	public boolean login(List<Roommate> roommateList,String usernameInput,String passwordInput) {
		for(Roommate roommate: roommateList) {
			String username = roommate.getUsername();
			String password = roommate.getPassword();
			if(username.equals(usernameInput) && password.equals(passwordInput))
				return true;
		}
		return false;
	}
	/**
	 * Return {@code true} if sign up has completed 
	 * @param roommate
	 */
	public boolean signUp(Roommate roommate) {
		return roommate.validateFields();
	}
	
	public boolean  validateFields() {
	      if (this.username == null) {
	            return false;
	        }
	        if (this.password == null) {
	            return false;
	        }
	        
	        if (this.name == null) {
	            return false;
	        }
	        
	        if (this.surname == null) {
	            return false;
	        }
	        
	        if (this.age <= 0) {
	            return false;
	        }
	        return true;
		
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roommate other = (Roommate) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Roommate [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", surname=" + surname + ", age=" + age + "]";
	}


	
}
