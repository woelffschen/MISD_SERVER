// created by Sylvia & Daniel

package onlineService;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.print.attribute.standard.DateTimeAtCreation;

import dao.AttendanceDAOLocal;
import dao.EventDAOLocal;
import dao.UserDAOLocal;
import dto.AttendanceResponse;
import dto.EventFilterCityListResponse;
import dto.EventResponse;
import dto.EventTO;
import entities.Attendance;
import entities.Event;
import entities.Menue;
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

	@Resource
	private EJBContext ejbContext;

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

	private List<EventTO> getEventList(int eventId, Event city) throws NotAllowedException {
		Event eventList = edao.filterCity(city);
		if (eventList == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return (List<EventTO>) eventList;
	}

	private Menue getMenue(int menueId) throws NotAllowedException {
		Menue menue = edao.findMenueById(menueId);
		if (menue == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return menue;
	}

	private User getUser(int userId) throws NotAllowedException {
		User user = udao.findUserById(userId);
		if (user == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return user;
	}

	public EventResponse createEvent(int sessionId, int userId, Menue menue, int min, int max, String street, int plz,
			String city, DateTimeAtCreation dateTime, String comments, User user, char gender)
			throws NoSessionException, NotAllowedException {
		EventResponse response = new EventResponse();
		try {
			Session session = getSession(sessionId);
			User user1 = getUser(userId);
			if (session != null && user1 != null) {
				Event event = new Event(menue, min, max, street, plz, city, dateTime, comments, user, gender);
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

	public EventResponse alterEvent(int sessionId, int eventId, Menue menue, int min, int max, String street, int plz,
			String city, DateTimeAtCreation dateTime, String comments, User user, char gender)
			throws NoSessionException, NotAllowedException {
		EventResponse response = new EventResponse();
		try {
			Session session = getSession(sessionId);
			Menue menue1 = getMenue(menue.getMenueId());
			Event event = getEvent(eventId);
			if (session != null && event != null) {
				menue1.setName(menue.getName());
				menue1.setLactose(menue.getLactose());
				menue1.setGluten(menue.getGluten());
				menue1.setSorbit(menue.getSorbit());
				menue1.setVegan(menue.getVegan());
				menue1.setVegetarian(menue.getVegetarian());
				menue1.setTitlePic(menue.getTitlePic());
				event.setMinAge(event.getMinAge());
				event.setMaxAge(event.getMaxAge());
				event.setEventStreet(event.getEventStreet());
				event.setEventPostalCode(event.getEventPostalCode());
				event.setEventCity(event.getEventCity());
				event.setEventDateTime(event.getEventDateTime());
				event.setComments(event.getComments());
				event.setGender(event.getGender());
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
			User user = getUser(userId);
			if (event != null && user == event.getEventOwner()) {
				edao.deleteEvent(event, user);
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return null;
	}

	public List<EventTO> filterCity(int sessionId, int eventId, Event city)
			throws NotAllowedException, NoSessionException {
		EventFilterCityListResponse response = new EventFilterCityListResponse();
		try {
			Session session = getSession(sessionId);
			List<EventTO> eventList = getEventList(eventId, city);
		}

		catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}

		return (List<EventTO>) response;
	}

}
