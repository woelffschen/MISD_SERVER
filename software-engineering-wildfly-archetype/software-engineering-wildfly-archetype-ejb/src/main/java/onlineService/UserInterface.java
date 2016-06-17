// created by Daniel & Sylvia

package onlineService;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import dao.EventDAOLocal;
import dao.UserDAOLocal;
import dto.DTOAssembler;
import dto.PrivateUserResponse;
import dto.PublicUserResponse;
import dto.ReturnCodeResponse;
import dto.UserResponse;
import dto.UserTO;
import entities.Event;
import entities.Session;
import entities.User;

@WebService
@Stateless
public class UserInterface {

	@EJB
	private UserDAOLocal udao;

	@EJB
	private EventDAOLocal edao;

	@EJB
	private DTOAssembler dtoAssembler;

	private Event getEvent(int eventId) throws NotAllowedException {
		Event event = edao.findEventById(eventId);
		if (event == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return event;
	}

	private Session getSession(int sessionId) throws NoSessionException {
		Session session = udao.findSessionById(sessionId);
		if (session == null)
			throw new NoSessionException("Bitte zunächst ein Login durchführen.");
		else
			return session;
	}

	private User getUser(String email) throws NotAllowedException {
		User user = udao.findUserById(email);
		if (user == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return user;
	}
	
	private User getEmail(String email) throws NotAllowedException {
		User user = udao.findUserByEmail(email);
		if (user == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return user;
	}

	public UserResponse registerUser(String email, String lastname, String firstname, String street,
			int postalCode, String city, int age, String telephoneNumber, char gender) {
		UserResponse response = new UserResponse();

 		if (udao.findUserByEmail(email) == null) {
			User user = udao.registerUser(email, lastname, firstname, street, postalCode, city, age, gender,
					telephoneNumber);
			if (user != null ) {
				int sessionId = udao.loginUser(user);

				response.setSessionId(sessionId);
			}
		}
		return response;
	}


	public UserResponse loginUser(String email) {
		UserResponse response = new UserResponse();
		try {
			User user = udao.findUserByEmail(email);
			if (user != null) {
				int sessionId = udao.loginUser(user);
				response.setSessionId(sessionId);
				getEmail(email);
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

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

	public PublicUserResponse getPublicUserData(String email, int eventId) {
		PublicUserResponse response = new PublicUserResponse();
		try {
			User user = getUser(email);
			Event event = getEvent(eventId);
			if (user != null) {
				udao.findUserById(email);
				edao.findEventById(eventId);
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
				response.setGender(event.getGender());
				response.setMaxAge(event.getMaxAge());
				response.setMenueId(event.getMenueId());
				response.setMinAge(event.getMinAge());
				response.setTakePlace(event.getTakePlace());
				return response;
			}

		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

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
				response.setGender(event.getGender());
				response.setMaxAge(event.getMaxAge());
				response.setMenueId(event.getMenueId());
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
