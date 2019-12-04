package main.java.gr.aueb.mscis.roommatefinder.service;

import javax.persistence.EntityManager;

public class RequestService {
	
	
	private EntityManager em;

	public RequestService(EntityManager em) {
		this.em = em;
	}

}
