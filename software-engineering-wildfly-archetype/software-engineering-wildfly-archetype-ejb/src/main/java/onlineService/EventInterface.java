// created by Sylvia & Daniel

package onlineService;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import dao.AttendanceDAOLocal;
import dao.EventDAOLocal;
import dao.UserDAOLocal;
import dto.DTOAssembler;
import dto.EventFilterCityListResponse;
import dto.EventResponse;
import dto.ReturnCodeResponse;
import dto.SingleEventResponse;
import entities.Event;
import entities.Session;
import entities.User;

@WebService
@Stateless
public class EventInterface {

	@EJB
	private DTOAssembler assembler;

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

	public SingleEventResponse getEvent(int eventId) {
		SingleEventResponse response = new SingleEventResponse();

		Event event = edao.findEventById(eventId);
		response.setEvent(this.assembler.makeDTO(event));

		return response;
	}

	private User getUser(String email) throws NotAllowedException {
		User user = udao.findUserById(email);
		if (user == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return user;
	}

	// eventId muss auch zurück
	public EventResponse createEvent(int sessionId, int min, int max, String street, int plz, String city,
			String comments, char gender, int dateTime, String eo, String name, boolean lactose, boolean gluten,
			boolean fructose, boolean sorbit, boolean vega, boolean vegee) {
		EventResponse response = new EventResponse();
		try {
			Session session = getSession(sessionId);
			User user = getUser(eo);
			if (session != null && user != null) {
				Event event = edao.createEvent(min, max, street, plz, city, comments, gender, dateTime, eo, name,
						lactose, gluten, fructose, sorbit, vega, vegee);

				response.setEventId(event.getEventId());
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

	// return nur returncode // bei uns aber separat abspeichern und status
	// ändern Methode in EventDao delete Event machen
	public ReturnCodeResponse deleteEvent(int eventId, String email) {
		ReturnCodeResponse response = new ReturnCodeResponse();
		Event event = this.edao.findEventById(eventId);
		if (event != null && email == event.getEventOwner()) {
			edao.deleteEvent(eventId, email);
		}
		return response;
	}

	public EventFilterCityListResponse getEventsByCity(String email, int sessionId, String city) {
		EventFilterCityListResponse response = new EventFilterCityListResponse();
		try {
			getSession(sessionId);

			List<Event> eventList = edao.filterCity(email, city);

			response.setEventList(this.assembler.makeDTOs(eventList));
		} catch (NoSessionException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

	public EventFilterCityListResponse getEventsByEmail(String email, int sessionId) {
		EventFilterCityListResponse response = new EventFilterCityListResponse();
		try {
			getSession(sessionId);

			List<Event> eventList = edao.ownEventList(email);

			response.setEventList(this.assembler.makeDTOs(eventList));
		} catch (NoSessionException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}

		return response;
	}

	public EventFilterCityListResponse getEvents(int sessionId) {
		EventFilterCityListResponse response = new EventFilterCityListResponse();
		try {
			getSession(sessionId);

			List<Event> eventList = edao.getAll();
			response.setEventList(this.assembler.makeDTOs(eventList));
		} catch (NoSessionException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}

		return response;
	}
}
