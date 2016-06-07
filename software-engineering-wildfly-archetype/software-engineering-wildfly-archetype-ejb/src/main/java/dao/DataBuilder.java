// @Author Sylvia

package dao;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import entities.Attendance;
import entities.Event;
import entities.Menue;
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
	private User user1, user2;

	@Resource
	private String lastname1, firstname1, street1, city1, telephone1, comment1, name, lastname2, firstname2, street2,
			telephone2, city2;

	@Resource
	private Event event1;

	@Resource
	private Menue menue1;

	@Resource
	private Attendance attendance1;

	private LocalDateTime date1 = LocalDateTime.now();

	@PostConstruct
	private void createTestData() {

		// erzeugt Beispieldaten für einen User und ein Event inklusive Menue,
		// falls diese noch nicht in der DB vorhanden sind.
		//User user1 = udao.getPublicUserData(user1);
//		if (user1 == null) {
//			// User noch nicht vorhanden, dann User mit neuem Event inklusive
//			// Menue anlegen:
//			user1 = new User(lastname1, firstname1, street1, 12345, city1, 29, telephone1, true, null, 'm');
//			em.persist(user1);
//			menue1 = new Menue(name, true, true, true, false, false, false, null);
//			em.persist(menue1);
//			event1 = new Event(menue1, 20, 25, street1, 12345, city1, date1, comment1, user1, 'm');
//			em.persist(event1);
//			logger.info("Neu angelegt: " + user1);
//			logger.info("Neu angelegt: " + menue1);
//			logger.info("Neu angelegt: " + event1);
//		}
//
//		// erzeugt Beispieldaten für einen User der als ein Attendance an einem
//		// Event teilnehmen möchte.
//		//User user2 = udao.getPublicUserData(user2);
//		if (user2 == null) {
//			// User noch nicht vorhanden, dann User anlegen und bei einem
//			// vorhandenen Event Teilnahme anfragen:
//			user2 = new User(lastname2, firstname2, street2, 56789, city2, 35, telephone2, true, null, 'm');
//			em.persist(user2);
//			edao.filterCity(event1);
//			attendance1 = new Attendance();
//			em.persist(attendance1);
//			logger.info("Neu angelegt: " + user2);
//			logger.info("Neu angelegt: " + attendance1);
//		}
	}

}
