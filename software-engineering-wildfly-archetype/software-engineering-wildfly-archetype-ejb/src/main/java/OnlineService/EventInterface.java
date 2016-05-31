// created by Sylvia & Daniel

package OnlineService;

import javax.ejb.Local;
import javax.jws.WebService;

@WebService
public class EventInterface {
	public Event createEvent(int eventId);
	public Event alterEvent(int eventId);
	public Event deleteEvent(int eventId);
	public Event filterCity(int eventId);
}
