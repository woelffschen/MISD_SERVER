/** 
 * @author Sylvia & Daniel
 * Java Doc written by Sylvia
*/

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

/**
 * The EventInterface is a stateless webservice and responsible for handling
 * events and event data
 */
@WebService
@Stateless
public class EventInterface {

	/**
	 * The AttendanceDAOLocal is the interface, which handles the communication
	 * with the database through the Attendance entity
	 */
	@EJB
	private AttendanceDAOLocal adao;

	/**
	 * The EventDAOLOcal is the interface, which handles the communication with
	 * the database through the Event entity.
	 */
	@EJB
	private EventDAOLocal edao;

	/**
	 * The UserDAOLocal is the interface, which handles the communication with
	 * the database through the User entity
	 */
	@EJB
	private UserDAOLocal udao;

	/**
	 * The DTOAssembler creates data transfer objects for the communication with
	 * the client
	 */
	@EJB
	private DTOAssembler assembler;

	/**
	 * An instrumentel class to find the correct session
	 * 
	 * @param sessionId
	 *            of the logged user
	 * @return session object of logged user
	 * @throws NoSessionException
	 */
	private Session getSession(int sessionId) throws NoSessionException {
		Session session = udao.findSessionById(sessionId);
		if (session == null)
			throw new NoSessionException("Please login first!");
		else
			return session;
	}

	/**
	 * An instrumental class to find the correct user
	 * 
	 * @param email
	 *            of the requested user
	 * @return user object of requested user
	 * @throws NotAllowedException
	 */
	private User getUser(String email) throws NotAllowedException {
		User user = udao.findUserById(email);
		if (user == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return user;
	}

	/**
	 * Creates an event and a menue, the event has the generated status
	 * takePlace = true and creates an event with the logged user as eventOwner
	 * with status 0
	 * 
	 * @param sessionId
	 *            of the logged user
	 * @param min
	 *            minimum age for participants
	 * @param max
	 *            maximum age for participants
	 * @param street
	 *            where the event will be held
	 * @param plz
	 *            where the event will be held
	 * @param city
	 *            where the event will be held
	 * @param comments
	 *            additional information for the event
	 * @param gender
	 *            requested gender of participants
	 * @param dateTime
	 *            when the event will be
	 * @param eo
	 *            eventOwner is the user who creates the event
	 * @param name
	 *            of the menue
	 * @param lactose
	 *            shows true if the menue is lactose freee
	 * @param gluten
	 *            shows true if the menue is gluten free
	 * @param fructose
	 *            shows true if the menue is fructose free
	 * @param sorbit
	 *            shows true if the menue is sorbit free
	 * @param vega
	 *            shows true if the menue is vegan
	 * @param vegee
	 *            shows true if the menue is vegetarian
	 * @return notAllowedException or noSessionException or returnCode 0 and
	 *         eventId
	 */
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

	/**
	 * sets the status of the event takePlace to false
	 * 
	 * @param eventId
	 *            of the requested event to delete
	 * @param email
	 *            of the eventOwner
	 * @return returnCode 0
	 */
	public ReturnCodeResponse deleteEvent(int eventId, String email) {
		ReturnCodeResponse response = new ReturnCodeResponse();
		Event event = this.edao.findEventById(eventId);
		if (event != null) {
			edao.deleteEvent(eventId);
		}
		return response;
	}

	/**
	 * shows one single event
	 * 
	 * @param eventId
	 *            of the requested event
	 * @return details of these requested event
	 */
	public SingleEventResponse getEvent(int eventId) {
		SingleEventResponse response = new SingleEventResponse();

		Event event = edao.findEventById(eventId);
		response.setEvent(this.assembler.makeDTO(event));

		return response;
	}

	/**
	 * shows a list of events where the city equals the param city and the
	 * requesting participant is in the same range of age as notified from the
	 * eventOwner
	 * 
	 * @param email
	 *            of the requesting participant
	 * @param sessionId
	 *            of the logged user
	 * @param city
	 *            of the requested city
	 * @return a list with all events which matches the city and age
	 */
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

	/**
	 * filters all events from a user where he is a eventOwner and a participant
	 * 
	 * @param email
	 *            of the requesting user
	 * @param sessionId
	 *            of the logged user
	 * @a list with all events which matches email
	 */
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

	/**
	 * filters all existing events
	 * 
	 * @param sessionId
	 *            of the logged user
	 * @return a list with all existing events
	 */
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
