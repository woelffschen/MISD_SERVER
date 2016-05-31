package dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;
import entities.User;

/**
 * Session Bean implementation class DataBuilder
 */
@Singleton
@Startup
public class DataBuilder {

	private static final Logger logger = Logger.getLogger(DataBuilder.class);
	
	@PersistenceContext
	EntityManager em;
	
	@EJB
	EventDAOLocal edao;
	
	@EJB
	AttendanceDAOLocal adao;
	
	@EJB
	UserDAOLocal udao;
	
	@Resource
	private int username1, username2;
	@Resource
	String password1, password2;

	@PostConstruct
	private void createTestData() {

		//erzeuge ein paar Beispieldaten zu Kunden und Konten, falls sie noch nicht in der DB vorhanden sind.
		User customer1 = udao.getUserById(username1);
		if (customer1 == null) {
			//Kunde noch nicht vorhanden, also mit 2 neuen Konten anlegen:
			customer1 = new Customer(username1, password1);
			em.persist(customer1);
			Account account1 = new Account(customer1);
			em.persist(account1);
			Account account2 = new Account(customer1);
			em.persist(account2);
			logger.info("Neu angelegt:" + customer1);
			logger.info("Neu angelegt: " + account1);
			logger.info("Neu angelegt: " + account2);			
		}

		Customer customer2 = dao.findCustomerByName(username2);
		if (customer2 == null) {
			//Kunde noch nicht vorhanden, also mit 2 neuen Konten anlegen:
			customer2 = new Customer(username2, password2);
			em.persist(customer2);
			Account account1 = new Account(customer2);
			em.persist(account1);
			Account account2 = new Account(customer2);
			em.persist(account2);
			logger.info("Neu angelegt:" + customer2);
			logger.info("Neu angelegt: " + account1);
			logger.info("Neu angelegt: " + account2);			
		}
	}


}
