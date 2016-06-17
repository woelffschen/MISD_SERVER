// @Author Sylvia & Daniel

package dao;


import java.math.BigInteger;
import java.util.List;

import javax.ejb.Local;

import entities.Event;
//import entities.Menue;
import entities.User;

@Local
public interface EventDAOLocal {

	public void createEvent(int min, int max, String street, int plz, String city, 
			String com, char g, int d, String eventOwner, String name, boolean lactose, boolean gluten, boolean fructose, boolean sorbit, boolean vega,
			boolean vegee);

	public void deleteEvent(int eventId, String email);

	public List<Event> filterCity(String email, String city);
	
	//hinzugefügt
	public List<Event> ownEventList(String email);

	public Event findEventById(int eventId);

//	public Menue findMenueById(int menueId);

//	User findUserById(BigInteger userId);
	
//	public int getMenueId(Menue menue);
	
	public int getEventId(Event event);

	User findUserByEmail(String eventOwner);
	
	}
