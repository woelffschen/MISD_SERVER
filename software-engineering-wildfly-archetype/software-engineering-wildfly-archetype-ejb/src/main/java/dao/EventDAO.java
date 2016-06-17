// @ Author Sylvia & Daniel

package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Attendance;
import entities.Event;
import entities.Menue;
import entities.User;

@Stateless
@Local(EventDAOLocal.class)
public class EventDAO implements EventDAOLocal {

	@PersistenceContext
	EntityManager em;

	@Override
	public Event createEvent(int min, int max, String street, int plz, String city, String com, char g, int d,
			String eo, String name, boolean lactose, boolean gluten, boolean fructose, boolean sorbit, boolean vega,
			boolean vegee) {
		Menue menue = new Menue(name, lactose, gluten, fructose, sorbit, vega, vegee);
		em.persist(menue);

		Event event = new Event(min, max, street, plz, city, com, g, d, eo);
		event.setMenue(menue);
		em.persist(event);

		User user = em.find(User.class, event.getEventOwner());
		Attendance attendance = new Attendance(event, user);
		em.persist(attendance);
		return event;
	}

	@Override
	public void deleteEvent(int eventId, String email) {
		em.find(Event.class, eventId);
		Event event = findEventById(eventId);
		if (event.getEventOwner() == email) {
			event.setTakePlace(false);
			em.merge(eventId);
		}
	}

	@Override
	public List<Event> filterCity(String email, String city) {
		List<Event> result = new ArrayList<Event>();

		User user = findUserByEmail(email);
		if (user != null) {
			int age = user.getAge();
			result = em.createQuery(
					"SELECT e FROM Event e WHERE e.eventCity LIKE :city AND :age BETWEEN e.minAge AND e.maxAge",
					Event.class).setParameter("city", city).setParameter("age", age).getResultList();
		}

		return result;
	}

	@Override
	public List<Event> ownEventList(String email) {
		User u = em.find(User.class, email);

		List<Event> result = new ArrayList<Event>();

		for (Attendance a : u.getAttendance()) {
			if(a.getStatus() != 4) {
				result.add(a.getEvent());
			}
		}

		return result;
	}

	@Override
	public List<Event> getAll() {
		return this.em.createQuery("SELECT x FROM " + Event.class.getSimpleName() + " x", Event.class).getResultList();
	}

	@Override
	public Event findEventById(int eventId) {
		return em.find(Event.class, eventId);

	}

	@Override
	public User findUserByEmail(String email) {
		return em.find(User.class, email);
	}

	// @Override
	// public int getMenueId(Menue menue) {
	// return menue.getMenueId();
	// }

	@Override
	public int getEventId(Event event) {
		return event.getEventId();
	}
}
