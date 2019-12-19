package main.java.gr.aueb.mscis.roommatefinder.resource;

import javax.persistence.EntityManager;

import main.java.gr.aueb.mscis.roommatefinder.persistence.JPAUtil;


public class AbstractResource {

	protected EntityManager getEntityManager() {

		return JPAUtil.getCurrentEntityManager();

	}

}
