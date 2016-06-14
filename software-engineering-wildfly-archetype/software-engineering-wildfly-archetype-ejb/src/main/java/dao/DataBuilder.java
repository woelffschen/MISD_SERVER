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

	@PersistenceContext
	EntityManager em;

	@EJB
	EventDAOLocal edao;

	@EJB
	AttendanceDAOLocal adao;

	@EJB
	UserDAOLocal udao;

//	@Resource
//	private User user1, user2;
//
	@Resource
	private String lastname1, firstname1, street1, city1, telephone1, comment1, name, lastname2, firstname2, street2,
			telephone2, city2;
//
//	@Resource
//	private Event event1;
//
//	@Resource
//	private Menue menue1;
//
//	@Resource
//	private Attendance attendance1;
//
//	@Resource
//	private LocalDateTime date1;

	public DataBuilder() {
	};

	//
	//
	//
	@PostConstruct
	private void createTestData() {
		//
		//// // erzeugt Beispieldaten für einen User und ein Event inklusive
		// Menue,
		//// // falls diese noch nicht in der DB vorhanden sind.
		User user1 = new User();
		// if (user1 == null) {
		// // User noch nicht vorhanden, dann User mit neuem Event inklusive
		// // Menue anlegen:
		// user1 = new User();
		user1.setLastname(lastname1);
		user1.setFirstname(firstname1);
		user1.setStreet(street1);
		user1.setPostalCode(12345);
		user1.setCity(city1);
		user1.setAge(30);
		user1.setGender('F');
		user1.setTelephoneNumber(telephone1);
	
		em.persist(user1);
		//
		// User user2 = new User();
		// user1.setLastname(lastname2);
		// user1.setFirstname(firstname2);
		// user1.setStreet(street2);
		// user1.setPostalCode(12345);
		// user1.setCity(city2);
		// user1.setAge(35);
		// user1.setGender('M');
		// user1.setTelephoneNumber(telephone2);
		// user1.setAlcDrinks(true);
		// em.persist(user2);
		//
		//
		// Menue menue1 = new Menue();
		// menue1.setName(name);
		// menue1.setFructose(true);
		// menue1.setGluten(false);
		// menue1.setLactose(true);
		// menue1.setSorbit(false);
		// menue1.setVegan(false);
		// menue1.setVegetarian(false);
		// em.persist(menue1);
		//// event1 = new Event(menue1, 20, 25, street1, 12345, city1, date1,
		// comment1, 'm');
		//// em.persist(event1);
		//
		//
		// }
		////
		//// // erzeugt Beispieldaten für einen User der als ein Attendance an
		// einem
		//// // Event teilnehmen möchte.
		//// //User user2 = udao.getPublicUserData(user2);
		//// if (user2 == null) {
		//// // User noch nicht vorhanden, dann User anlegen und bei einem
		//// // vorhandenen Event Teilnahme anfragen:
		//// user2 = new User(lastname2, firstname2, street2, 56789, city2, 35,
		// telephone2, true, null, 'm');
		//// //em.persist(user2);
		//// em.find(Event.class, event1);
		//// //edao.filterCity(city1);
		//// attendance1 = new Attendance(user2.getUserId(),
		// event1.getEventId());
		//// em.persist(attendance1);
		////
		//// }
		//// }
	}
}
