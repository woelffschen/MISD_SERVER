// @Author Sylvia & Daniel

package dao;

import javax.ejb.Local;
import javax.print.attribute.standard.DateTimeAtCreation;

import entities.Event;
import entities.Menue;
import entities.User;

@Local
public interface EventDAOLocal {

	public void createEvent(Menue m, int min, int max, String street, int plz, String city, DateTimeAtCreation dateTime,
			String com, User eO, char g);

	public void alterEvent(Event e, Menue m, int min, int max, String street, int plz, String city,
			DateTimeAtCreation dateTime, String com, User eO, char g);

	public void deleteEvent(Event e, User user);

	public Event filterCity(Event city);

	public Event findEventById(int eventId);

	public Menue findMenueById(int menueId);
}
