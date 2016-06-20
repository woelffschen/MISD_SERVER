/** 
 * @author Sylvia & Daniel
 * Java Doc written by Sylvia
*/
package onlineService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import dao.AttendanceDAOLocal;
import dao.EventDAOLocal;
import dao.UserDAOLocal;
import dto.AttendanceResponse;
import dto.DTOAssembler;
import entities.Event;
import entities.Session;
import entities.User;

/**
 * The AttendanceInterface is a stateless webservice and responsible for
 * handling EventOwner and Participants
 */
@WebService
@Stateless
public class AttendanceInterface {

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
	private DTOAssembler dtoa;

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
	 * An instrumentel class to find the correct event
	 * 
	 * @param eventId 
	 *            of the requested event
	 * @return event object of requested event
	 * @throws NotAllowedException
	 */
	private Event getEvent(int eventId) throws NotAllowedException {
		Event event = this.edao.findEventById(eventId);
		if (event == null)
			throw new NotAllowedException("This action is not allowed!");
		else
			return event;
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
		User user = udao.findUserByEmail(email);
		if (user == null)
			throw new NotAllowedException("This action is not allowed!");
		else
			return user;
	}

	/**
	 * cancels an attendance participant and returns the current status 1
	 * 
	 * @param sessionId
	 *            of the logged user
	 * @param eventId
	 *            of the requested event, as far as he is not the eventOwner
	 * @param email
	 *            of the requesting participant
	 * @return notAllowedException or noSessionException or returnCode 0 and
	 *         status 1
	 */
	public AttendanceResponse cancelAttendance(int sessionId, int eventId, String email) {
		AttendanceResponse response = new AttendanceResponse();
		try {
			Session session = getSession(sessionId);
			Event event = getEvent(eventId);

			this.adao.cancelAttendance(event, session.getUser());
			response.setStatus(1);

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
	 * requests an attendance participant and returns the current status 3
	 * 
	 * @param sessionId
	 *            of the logged user
	 * @param eventId
	 *            of the requested event, as far as he is not the eventOwner
	 * @param email
	 *            of the requesting participant
	 * @return notAllowedException or noSessionException or returnCode 0 and
	 *         status 3
	 */
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

	/**
	 * confirms an attendance participant and returns the current status 2
	 * 
	 * @param sessionId
	 *            of the logged user
	 * @param eventId
	 *            of the requested event, as far as he is the eventOwner
	 * @param email
	 *            of the requesting participant
	 * @return notAllowedException or noSessionException or returnCode 0 and
	 *         status 2
	 */
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

	/**
	 * rejects an attendance participant and returns the current status 4
	 * 
	 * @param sessionId
	 *            of the logged user
	 * @param eventId
	 *            of the requested event, as far as he is the eventOwner
	 * @param email
	 *            of the requesting participant
	 * @return notAllowedException or noSessionException or returnCode 0 and
	 *         status 2
	 */
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
