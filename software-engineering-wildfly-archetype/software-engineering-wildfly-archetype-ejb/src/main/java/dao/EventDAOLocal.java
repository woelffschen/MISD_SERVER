// @Author Sylvia & Daniel

package dao;


import java.util.Calendar;
import java.util.List;

import javax.ejb.Local;

import entities.Event;
import entities.Menue;
import entities.User;

@Local
public interface EventDAOLocal {

	public int createEvent(int min, int max, String street, int plz, String city, 
			String com, char g, Calendar d, int eventOwner, String name, boolean lactose, boolean gluten, boolean fructose, boolean sorbit, boolean vega,
			boolean vegee);

	public void deleteEvent(int eventId, int userId);

	public List<Event> filterCity(int userid, String city);

	public Event findEventById(int eventId);

	public Menue findMenueById(int menueId);

	User findUserById(int userId);
	
//	public int getMenueId(Menue menue);
//	
	public int getEventId(Event event);
	
	}
