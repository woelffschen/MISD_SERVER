/** 
 * @author Sylvia & Daniel
*/

package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Event;
import entities.User;

@Local
public interface EventDAOLocal {

	public Event createEvent(int min, int max, String street, int plz, String city, String com, char g, int d,
			String eventOwner, String name, boolean lactose, boolean gluten, boolean fructose, boolean sorbit,
			boolean vega, boolean vegee);

	public void deleteEvent(int eventId);

	public List<Event> getAll();

	public List<Event> filterCity(String email, String city);

	public List<Event> ownEventList(String email);

	public Event findEventById(int eventId);

	public int getEventId(Event event);

	User findUserByEmail(String eventOwner);
}