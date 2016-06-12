// @Author Sylvia & Daniel

package dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Local;

import entities.Event;
import entities.Menue;
import entities.User;

@Local
public interface EventDAOLocal {

	public void createEvent(Menue m, int min, int max, String street, int plz, String city, LocalDateTime dateTime,
			String com, char g);

	public void alterEvent(Event e, Menue m, int min, int max, String street, int plz, String city,
			LocalDateTime dateTime, String com, char g);

	public void deleteEvent(Event e, User user);

//	public List<Event> filterCity(String city);

	public Event findEventById(int eventId);

	public Menue findMenueById(int menueId);
}
