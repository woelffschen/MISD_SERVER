// created by Sylvia & Daniel

package onlineService;

import java.math.BigInteger;

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

	private Attendance getAttendance(int attendanceId, int eventId)
			throws NotAllowedException, EventOwnerException, ParticipantException {
		Attendance attendance = adao.findAttendanceById(attendanceId);
		Event event = edao.findEventById(eventId);
		if (attendance == null)
			throw new NotAllowedException("This action is not allowed!");
		if (attendance.getAttendanceId() == event.getEventId())
			throw new ParticipantException("This action is only allowed for Participants");
		if (attendance.getAttendanceId() != event.getEventId())
			throw new EventOwnerException("This action is only allowed for Event Owner");

		else
			return attendance;
	}

	private Event getEvent(int eventId) throws NotAllowedException {
		Event event = edao.findEventById(eventId);
		if (event == null)
			throw new NotAllowedException("This action is not allowed!");
		else
			return event;
	}

	private User getUser(BigInteger userId) throws NotAllowedException {
		User user = udao.findUserById(userId);
		if (user == null)
			throw new NotAllowedException("This action is not allowed!");
		else
			return user;
	}

	// bei Attendance (außer bei request) nur int status zurück
	
	public AttendanceResponse cancelAttendance(int sessionId, int attendanceId, int eventId) {
		AttendanceResponse response = new AttendanceResponse();
		try {
			Session session = getSession(sessionId);
			Attendance attendance = getAttendance(attendanceId, eventId);
			Event event = getEvent(eventId);

			if (attendance != null) {
				attendance.setStatus(attendance.getStatus());
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());

		} catch (NoSessionException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		} catch (EventOwnerException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());

		} catch (ParticipantException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

	// return Attendance ID status & Attendance Id zurück schicken
	public AttendanceResponse requestAttendance(int sessionId, int eventId, BigInteger userId) {
		AttendanceResponse response = new AttendanceResponse();
		try {
			Session session = getSession(sessionId);
			Event event = getEvent(eventId);
			User user = getUser(userId);
			if (event != null) {
				Attendance attendance = new Attendance(event, user);
				attendance.setStatus(attendance.getStatus());
				getAttendance(attendance.getAttendanceId(), eventId);
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());

		} catch (NoSessionException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		} catch (EventOwnerException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());

		} catch (ParticipantException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

	public AttendanceResponse confirmAttendance(int sessionId, int attendanceId, int eventId, int userId) {
		AttendanceResponse response = new AttendanceResponse();
		try {
			Session session = getSession(sessionId);
			Attendance attendance = getAttendance(attendanceId, eventId);
			Event event = getEvent(eventId);

			if (attendance != null) {
				attendance.setStatus(attendance.getStatus());
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());

		} catch (NoSessionException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		} catch (EventOwnerException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());

		} catch (ParticipantException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

	public AttendanceResponse rejectAttendance(int sessionId, int attendanceId, int eventId) {
		AttendanceResponse response = new AttendanceResponse();
		try {
			Session session = getSession(sessionId);
			Attendance attendance = getAttendance(attendanceId, eventId);
			Event event = getEvent(eventId);

			if (attendance != null) {
				attendance.setStatus(attendance.getStatus());
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());

		} catch (NoSessionException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		} catch (EventOwnerException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());

		} catch (ParticipantException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

}
