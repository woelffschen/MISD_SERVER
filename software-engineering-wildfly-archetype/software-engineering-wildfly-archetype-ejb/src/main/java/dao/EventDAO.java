// @ Author Sylvia & Daniel

package dao;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Event;
import entities.Menue;
import entities.User;

@Stateless
@Local(EventDAOLocal.class)
public class EventDAO implements EventDAOLocal {

	@PersistenceContext
	EntityManager em;
	
	private Event event;

	@Override
	public int createEvent(int min, int max, String street, int plz, String city, String com, char g, Calendar d,
			int eo, String name, boolean lactose, boolean gluten, boolean fructose, boolean sorbit, boolean vega,
			boolean vegee) {
		Menue menue = new Menue(name, lactose, gluten, fructose, sorbit, vega, vegee);
		em.persist(menue);
		em.find(Menue.class, menue);
		Event event = new Event(menue, min, max, street, plz, city, com, g, d, eo);
		em.persist(event);
		em.find(Event.class, event);
		return event.getEventId();
	}

	@Override
	public void deleteEvent(int eventId, int userId) {
		em.find(Event.class, eventId);
		Event event = findEventById(eventId);
		if (event.getEventOwner() == userId) {
			event.setTakePlace(false);
			em.merge(eventId);
		}
	}

	@Override
	public List<Event> filterCity(int userid, String city) {
		int age = findUserById(userid).getAge();
		@SuppressWarnings("unchecked")
		List<Event> results = em
				.createQuery(
						"SELECT * FROM Event WHERE eventCity LIKE :cityName and age between minAge and maxAge and takePlace=true")
				.setParameter(":cityName", city).setParameter(":age", age).getResultList();
		if (results.size() >= 1) {
			return (results);
		} else {
			return null;
		}
	}

	@Override
	public Event findEventById(int eventId) {
		return em.find(Event.class, eventId);

	}

	@Override
	public Menue findMenueById(int menueId) {
		return em.find(Menue.class, menueId);

	}

	@Override
	public User findUserById(int userId) {
		return em.find(User.class, userId);
	}
	
//	@Override
//	public int getMenueId(Event event) {
//	em.find(Menue.class, menue);
//	return menue.getMenueId(); 
//	}
	
	@Override
	public int getEventId(Event event) {
	return event.getEventId();
	}
}
