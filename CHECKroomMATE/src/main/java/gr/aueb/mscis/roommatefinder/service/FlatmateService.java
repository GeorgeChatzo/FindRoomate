package main.java.gr.aueb.mscis.roommatefinder.service;

import javax.persistence.EntityManager;

public class FlatmateService {

	private EntityManager em;

	public FlatmateService(EntityManager em) {
		this.em = em;
	}	
}
