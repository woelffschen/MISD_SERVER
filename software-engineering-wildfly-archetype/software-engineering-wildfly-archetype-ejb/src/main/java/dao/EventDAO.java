// created by Sylvia & Daniel

package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.print.attribute.standard.DateTimeAtCreation;

import OnlineService.EventInterface;
import entities.Event;
import entities.Menue;
import entities.User;

@Stateless
public class EventDAO implements EventDAOLocal{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void createEvent(Menue m, int min, int max, String street, int plz, String city, DateTimeAtCreation dateTime,String com, User eO,char g) {
		Event e = new Event(m,min,max,street,plz,city,dateTime,com,eO,g);
		em.persist(e);
		
	}

	@Override
	public void alterEvent(Event e , Menue m, int min, int max, String street, int plz, String city, DateTimeAtCreation dateTime,String com, User eO,char g) {
		em.find(Event.class, e);
		e.setComments(com);
		e.setEventCity(city);
		e.setEventDateTime(dateTime);
		e.setEventOwner(eO);
		e.setEventPostalCode(plz);
		e.setEventStreet(street);
		e.setMaxAge(max);
		e.setMinAge(min);
		em.persist(e);
	}

	@Override
	public void deleteEvent(Event e, User user) {
		em.find(Event.class, e);
		if(e.getEventOwner() != user ){
		em.remove(e);
		}
		//else deklarieren mit Exception
	}

	@Override
	public Event filterCity(Event city) {
		List results = em.createQuery("SELECT * FROM Event e WHERE e.city LIKE :cityName")
                .setParameter("cityname", city)
                .getResultList();
		if (results.size()==1) {
		   return (Event) results.get(0);
		}
		else {
			return null;
		}
	}

}
