// created by Sylvia & Daniel

package interfaces;

import javax.ejb.Local;

@Local
public interface EventInterface {
	public Event createEvent(int eventId);
	public Event alterEvent(int eventId);
	public Event deleteEvent(int eventId);
	public Event filterCity(int eventId);
}
