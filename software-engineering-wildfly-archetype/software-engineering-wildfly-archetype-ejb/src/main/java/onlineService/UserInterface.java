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
import dto.DTOAssembler;
import dto.PrivateUserResponse;
import dto.PublicUserResponse;
import dto.ReturnCodeResponse;
import dto.UserResponse;
import dto.UserTO;
import entities.Attendance;
import entities.Event;
import entities.Session;
import entities.User;

/**
 * The UserInterface is a stateless webservice and responsible for handling user
 * and user data
 */
@WebService
@Stateless
public class UserInterface {

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
	 * An instrumentel class to find the correct event
	 * 
	 * @param eventId
	 *            of the requested event
	 * @return event object of requested event
	 * @throws NotAllowedException
	 */
	private Event getEvent(int eventId) throws NotAllowedException {
		Event event = edao.findEventById(eventId);
		if (event == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return event;
	}

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
			throw new NoSessionException("Bitte zunächst ein Login durchführen.");
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
	 * An instrumental class to find the correct user
	 * 
	 * @param email
	 *            of the requested user
	 * @return user object of requested user
	 * @throws NotAllowedException
	 */
	private User getEmail(String email) throws NotAllowedException {
		User user = udao.findUserByEmail(email);
		if (user == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return user;
	}

	/**
	 * registers a new user and logs him in
	 * 
	 * @param email
	 *            of the user
	 * @param lastname
	 *            of the user
	 * @param firstname
	 *            of the user
	 * @param street
	 *            of the user
	 * @param postalCode
	 *            of the user
	 * @param city
	 *            of the user
	 * @param age
	 *            birthday of the user in unix time
	 * @param telephoneNumber
	 *            of the user
	 * @param gender
	 *            of the user
	 * @return NotAllowedException or returnCode 0 and sessionId
	 */
	public UserResponse registerUser(String email, String lastname, String firstname, String street, int postalCode,
			String city, int age, String telephoneNumber, char gender) {
		UserResponse response = new UserResponse();
		try {
			User user = udao.registerUser(email, lastname, firstname, street, postalCode, city, age, gender,
					telephoneNumber);
			int sessionId = udao.loginUser(user);
			getEmail(email);
			response.setSessionId(sessionId);
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

	/**
	 * logs an user in
	 * 
	 * @param email
	 *            of the user
	 * @return NotAllowedException or returnCode 0 and sessionId
	 */
	public UserResponse loginUser(String email) {
		UserResponse response = new UserResponse();
		try {
			User user = getEmail(email);
			if (user != null) {
				int sessionId = udao.loginUser(user);
				response.setSessionId(sessionId);
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

	/**
	 * logs an user out
	 * 
	 * @param email
	 *            of the user
	 * @return NoSessionException or returnCode 0
	 */
	public ReturnCodeResponse logout(int sessionId) {
		ReturnCodeResponse response = new ReturnCodeResponse();

		try {
			Session session = getSession(sessionId);
			if (session != null)
				udao.logoutUser(sessionId);

		} catch (NoSessionException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;

	}

	/**
	 * gets the public data of an attendance and the belonging event data
	 * 
	 * @param email
	 *            of the event attendance which should be shown
	 * @param eventId
	 *            of the requested event
	 * @return NotAllowedException or returnCode 0 and requested data
	 */
	public PublicUserResponse getPublicUserData(String email, int eventId) {
		PublicUserResponse response = new PublicUserResponse();
		try {
			User user = getUser(email);
			Event event = getEvent(eventId);
			Attendance attendance = adao.findAttendance(eventId, email);

			if (user != null && event != null) {
				response.setLastname(user.getLastname());
				response.setFirstname(user.getFirstname());
				response.setPostalCode(user.getPostalCode());
				response.setAge(user.getAge());
				response.setGender(user.getGender());
				response.setTelephoneNumber(user.getTelephoneNumber());
				response.setComments(event.getComments());
				response.setEventCity(event.getEventCity());
				response.setEventDateTime(event.getEventDateTime());
				response.setEventOwner(event.getEventOwner());
				response.setEventPostalCode(event.getEventPostalCode());
				response.setEventStreet(event.getEventStreet());
				response.setGenderEvent(event.getGender());
				response.setMaxAge(event.getMaxAge());
				response.setMenueId(event.getMenue().getMenueId());
				response.setMinAge(event.getMinAge());
				response.setTakePlace(event.getTakePlace());
			} else {
				// not possible, because if there is no user and belonging
				// event, a NotAllowedException will be thrown
			}

			if (attendance != null) {
				response.setAttendanceStatus(attendance.getStatus());
			} else {
				response.setAttendanceStatus(-1);
			}

		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

	/**
	 * gets the private data of an attendance and the belonging event data
	 * 
	 * @param email
	 *            of the event attendance which should be shown
	 * @param eventId
	 *            of the requested event
	 * @return NotAllowedException or returnCode 0 and requested data
	 */
	public PrivateUserResponse getPrivateUserData(String email, int eventId) {
		PrivateUserResponse response = new PrivateUserResponse();
		try {
			User user = getUser(email);
			Event event = getEvent(eventId);
			if (user != null) {
				udao.findUserById(email);
				edao.findEventById(eventId);
				response.setLastname(user.getLastname());
				response.setFirstname(user.getFirstname());
				response.setAge(user.getAge());
				response.setGender(user.getGender());
				response.setTelephoneNumber(user.getTelephoneNumber());
				response.setComments(event.getComments());
				response.setEventCity(event.getEventCity());
				response.setEventDateTime(event.getEventDateTime());
				response.setEventOwner(event.getEventOwner());
				response.setEventPostalCode(event.getEventPostalCode());
				response.setEventStreet(event.getEventStreet());
				response.setGenderEvent(event.getGender());
				response.setMaxAge(event.getMaxAge());
				response.setMenueId(event.getMenue().getMenueId());
				response.setMinAge(event.getMinAge());
				response.setTakePlace(event.getTakePlace());
				response.setEmail(user.getEmail());
				return response;
			}

		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

	/**
	 * gets the public data of an user
	 * 
	 * @param email
	 *            of the user which should be shown
	 * @return NotAllowedException or returnCode 0 and requested user data
	 */
	public UserTO getPublicData(String email) {
		UserTO response = new UserTO();
		try {
			User user = getEmail(email);
			if (user != null) {
				response.setEmail(user.getEmail());
				response.setLastname(user.getLastname());
				response.setFirstname(user.getFirstname());
				response.setAge(user.getAge());
				response.setGender(user.getGender());
				response.setTelephoneNumber(user.getTelephoneNumber());
				response.setPostalCode(user.getPostalCode());
				response.setCity(user.getCity());
				return response;
			}

		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

	/**
	 * deletes an user
	 * 
	 * @param email
	 *            of the user to delete
	 * @param sessionId
	 *            of the user to delete
	 * @return NotAllowedException or NoSessionException or returnCode 0
	 */
	public ReturnCodeResponse deleteUser(String email, int sessionId) {
		ReturnCodeResponse response = new ReturnCodeResponse();
		try {
			getUser(email);
			getSession(sessionId);
			udao.deleteUser(email);

		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		} catch (NoSessionException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}

		return response;
	}

}
