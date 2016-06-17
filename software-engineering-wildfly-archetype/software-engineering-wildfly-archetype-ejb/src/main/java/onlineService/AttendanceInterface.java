// created by Sylvia & Daniel

package onlineService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import dao.AttendanceDAOLocal;
import dao.EventDAOLocal;
import dao.UserDAOLocal;
import dto.AttendanceResponse;
import dto.DTOAssembler;
import entities.Attendance;
import entities.Event;
import entities.Session;
import entities.User;

@WebService
@Stateless
public class AttendanceInterface {

	@EJB
	private AttendanceDAOLocal adao;

	@EJB
	private EventDAOLocal edao;

	@EJB
	private UserDAOLocal udao;

	@EJB
	private DTOAssembler dtoa;

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
			throw new NotAllowedException("This action is not allowed!");
		else
			return event;
	}

	private User getUser(String email) throws NotAllowedException {
		User user = udao.findUserByEmail(email);
		if (user == null)
			throw new NotAllowedException("This action is not allowed!");
		else
			return user;
	}

	// bei Attendance (außer bei request) nur int status zurück
	
	public AttendanceResponse cancelAttendance(int sessionId, int eventId) {
		AttendanceResponse response = new AttendanceResponse();
		try {
			Session session = getSession(sessionId);
			Event event = getEvent(eventId);

			this.adao.cancelAttendance(event, session.getUser());
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());

		} catch (NoSessionException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

	// return Attendance ID status & Attendance Id zurück schicken
	public AttendanceResponse requestAttendance(int sessionId, int eventId, String email) {
		AttendanceResponse response = new AttendanceResponse();
		try {
			getSession(sessionId);
			Event event = getEvent(eventId);
			User user = getUser(email);
			if (event != null && user != null) {
				int status = this.adao.requestAttendance(event, user);
				response.setStatus(status);
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

	public AttendanceResponse confirmAttendance(int sessionId, int eventId, String email) {
		AttendanceResponse response = new AttendanceResponse();
		try {
			Session session = getSession(sessionId);
			Event event = getEvent(eventId);
			User userAendern = getUser(email);
			
			int status = this.adao.confirmAttendance(event, session.getUser(), userAendern);
			
			response.setStatus(status);
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());

		} catch (NoSessionException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		
		return response;
	}

	public AttendanceResponse rejectAttendance(int sessionId, int eventId, String email) {
		AttendanceResponse response = new AttendanceResponse();
		try {
			Session session = getSession(sessionId);
			Event event = getEvent(eventId);
			User userAendern = getUser(email);
			
			int status = this.adao.rejectAttendance(event, session.getUser(), userAendern);
			
			response.setStatus(status);
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
