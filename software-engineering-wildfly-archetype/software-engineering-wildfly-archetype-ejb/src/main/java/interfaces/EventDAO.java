// created by Sylvia & Daniel

package interfaces;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EventDAO implements EventInterface {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Event createEvent(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event alterEvent(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event deleteEvent(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event filterCity(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

}
