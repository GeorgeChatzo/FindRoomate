package main.java.gr.aueb.mscis.roommatefinder.model;


//Superclass Roommate 

import javax.persistence.*;



@MappedSuperclass

public class Roommate {
	
@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.AUTO)
 private Long id;
	

	
	private String username;
	private String password;
	private String name;
	private String surname;
	private int age;
	
	
	
	public Roommate(String username, String password, String name,
			String surname, int age) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	public Roommate() {
		
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

	@Override
	public String toString() {
		return "Roommate [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", surname=" + surname + ", age=" + age + "]";
	}


	
}
