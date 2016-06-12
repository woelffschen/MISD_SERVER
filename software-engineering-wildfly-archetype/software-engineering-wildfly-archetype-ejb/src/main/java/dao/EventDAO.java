// @ Author Sylvia & Daniel

package dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Event;
import entities.Menue;
import entities.User;

/**
 * @author user
 *
 */
@Stateless
@Local(EventDAOLocal.class)
public class EventDAO implements EventDAOLocal {

	@PersistenceContext
	EntityManager em;

	@Override
	public void createEvent(Menue m, int min, int max, String street, int plz, String city, LocalDateTime dateTime,
			String com, char g) {
		Event e = new Event(m, min, max, street, plz, city, dateTime, com, g);
		em.persist(e);

	}

	@Override
	public void alterEvent(Event e, Menue m, int min, int max, String street, int plz, String city,
			LocalDateTime dateTime, String com, char g) {
		em.find(Event.class, e);
		e.setComments(com);
		e.setEventCity(city);
		e.setEventDateTime(dateTime);
		e.setEventPostalCode(plz);
		e.setEventStreet(street);
		e.setMaxAge(max);
		e.setMinAge(min);
		em.merge(e);
	}

	@Override
	public void deleteEvent(Event e, User user) {
		em.find(Event.class, e);
		if (e.getEventOwner() == user) {
			em.remove(e);
		}
	}

//	TODO: Change return type to List<Event>
//	@Override
//	public List<Event> filterCity(String city) {
//	  List<Event> results = em.createQuery("SELECT * FROM Event WHERE eventCity LIKE :cityName")
//				.setParameter(":cityName", city).getResultList();
//		if (results.size() >= 1) {
//			return (results);
//		} else {
//			return null;
//		}
//	}

	@Override
	public Event findEventById(int eventId) {
		return em.find(Event.class, eventId);

	}

	@Override
	public Menue findMenueById(int menueId) {
		return em.find(Menue.class, menueId);

	}
}
