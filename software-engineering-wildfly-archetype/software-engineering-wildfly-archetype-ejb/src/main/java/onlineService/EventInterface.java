// created by Sylvia & Daniel

package onlineService;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import dao.AttendanceDAOLocal;
import dao.EventDAOLocal;
import dao.UserDAOLocal;
import dto.EventFilterCityListResponse;
import dto.EventResponse;
import dto.EventTO;
import entities.Event;
import entities.Session;
import entities.User;

@WebService
@Stateless
public class EventInterface {

	@EJB
	private AttendanceDAOLocal adao;

	@EJB
	private EventDAOLocal edao;

	@EJB
	private UserDAOLocal udao;
	
	private Event event;

	private Session getSession(int sessionId) throws NoSessionException {
		Session session = udao.findSessionById(sessionId);
		if (session == null)
			throw new NoSessionException("Please login first!");
		else
			return session;
	}

	private Event getEvent(int eventId) throws NotAllowedException {
		Event event = edao.findEventById(eventId);
		if (event == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return event;
	}

	private List<Event> getEventList(int userid, String city) throws NotAllowedException {
		List<Event> eventList = edao.filterCity(userid, city);
		if (eventList == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return (List<Event>) eventList;
	}

	private User getUser(int userId) throws NotAllowedException {
		User user = udao.findUserById(userId);
		if (user == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return user;
	}

	public EventResponse createEvent(int sessionId, int userId, int min, int max, String street, int plz, String city,
			String comments, char gender, Calendar dateTime, int eo, String name, boolean lactose, boolean gluten,
			boolean fructose, boolean sorbit, boolean vega, boolean vegee)
			throws NoSessionException, NotAllowedException {
		EventResponse response = new EventResponse();
		EventTO eventTO = new EventTO();
		try {
			Session session = getSession(sessionId);
			User user1 = getUser(userId);
			if (session != null && user1 != null) {
				edao.createEvent(min, max, street, plz, city, comments, gender, dateTime, eo, name, lactose, gluten,
						fructose, sorbit, vega, vegee);
				// die EventId wird für das TO benötigt this.eventId = eventId;
				// die MenueId wird für das TO benötigt this.menueId = menueId;
				edao.getEventId(event);
				
				// edao.getMenueId(menue)
				eventTO.setMinAge(min);
				eventTO.setMaxAge(max);
				eventTO.setEventStreet(street);
				eventTO.setEventPostalCode(plz);
				eventTO.setEventCity(city);
				eventTO.setComments(comments);
				eventTO.setGender(gender);
				eventTO.setEventDateTime(dateTime);
				eventTO.setEventOwner(eo);
				eventTO.setName(name);
				eventTO.setLactose(lactose);
				eventTO.setGluten(gluten);
				eventTO.setFructose(fructose);
				eventTO.setSorbit(sorbit);
				eventTO.setVega(vega);
				eventTO.setVegee(vegee);
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

	public EventResponse deleteEvent(int eventId, int userId) throws NotAllowedException {
		EventResponse response = new EventResponse();
		try {
			Event event = getEvent(eventId);
			if (event != null && userId == event.getEventOwner()) {
				edao.deleteEvent(eventId, userId);
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return null;
	}

	public EventFilterCityListResponse filterCity(int sessionId, String city)
			throws NotAllowedException, NoSessionException {
		EventFilterCityListResponse response = new EventFilterCityListResponse();
		try {
			Session session = getSession(sessionId);
			List<Event> eventList = getEventList(sessionId, city);

			if (session != null && eventList != null) {
				return response;
			}
		}

		catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}

		return null;
	}

}
