// created by Sylvia & Daniel

package onlineService;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import dao.AttendanceDAOLocal;
import dao.EventDAOLocal;
import dao.UserDAOLocal;
import dto.EventFilterCityListResponse;
import dto.EventResponse;
import dto.ReturnCodeResponse;
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

	private List<Event> getEventList(BigInteger userid, String city) throws NotAllowedException {
		List<Event> eventList = edao.filterCity(userid, city);
		if (eventList == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return (List<Event>) eventList;
	}
	
	
	//hinzugefügt
	private List<Event> getownEventList(BigInteger userid) throws NotAllowedException {
		List<Event> eventList = edao.ownEventList(userid);
		if (eventList == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return (List<Event>) eventList;
	}

	
	private User getUser(BigInteger userId) throws NotAllowedException {
		User user = udao.findUserById(userId);
		if (user == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return user;
	}

	// nur Returncode zurück
	public ReturnCodeResponse createEvent(int sessionId, int min, int max, String street, int plz, String city,
			String comments, char gender, int dateTime, BigInteger eo, String name, boolean lactose, boolean gluten,
			boolean fructose, boolean sorbit, boolean vega, boolean vegee) {
		ReturnCodeResponse response = new ReturnCodeResponse();
		try {
			Session session = getSession(sessionId);
			User user = getUser(eo);
			if (session != null && user != null) {
				edao.createEvent(min, max, street, plz, city, comments, gender, dateTime, eo, name, lactose, gluten,
						fructose, sorbit, vega, vegee);
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());

		} catch (NoSessionException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}
	
	
	// return nur returncode // bei uns aber separat abspeichern und status ändern 
	public EventResponse deleteEvent(int eventId, BigInteger userId) {
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

	// 
	public EventFilterCityListResponse filterCity(BigInteger userId, int sessionId, String city) {
		EventFilterCityListResponse response = new EventFilterCityListResponse();
		try {
			Session session = getSession(sessionId);
			// to do TO Objekte erstellen
			List<Event> eventList = getEventList(userId, city);

			if (session != null && eventList != null) {
				return response;
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());

		} catch (NoSessionException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}
	
	public EventFilterCityListResponse eventList(BigInteger userId, int sessionId) {
		EventFilterCityListResponse response = new EventFilterCityListResponse();
		try {
			Session session = getSession(sessionId);
			List<Event> eventList = getownEventList(userId);

			if (session != null && eventList != null) {
				return response;
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());

		} catch (NoSessionException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

}
