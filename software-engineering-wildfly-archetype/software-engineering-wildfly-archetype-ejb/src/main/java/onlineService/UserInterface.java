// created by Daniel & Sylvia

package onlineService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import dao.UserDAOLocal;
import dto.DTOAssembler;
import dto.UserLoginResponse;
import dto.UserResponse;
import entities.Session;
import entities.User;

@WebService
@Stateless
public class UserInterface {

	@EJB
	private UserDAOLocal udao;

	@EJB
	private DTOAssembler dtoAssembler;

	private Session getSession(int sessionId) throws NoSessionException {
		Session session = udao.findSessionById(sessionId);
		if (session == null)
			throw new NoSessionException("Bitte zunächst ein Login durchführen.");
		else
			return session;
	}

	private User getUser(int userId) throws NotAllowedException {
		User user = udao.findUserById(userId);
		if (user == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return user;
	}

	public UserLoginResponse registerUser(String lastname, String firstname, String street, int postalCode, String city,
			int age, String telephoneNumber, char gender) {
		UserLoginResponse response = new UserLoginResponse();
		try {
			User user = udao.registerUser(lastname, firstname, street, postalCode, city, age, telephoneNumber, gender);
			if (user != null) {
				User user1 = getUser(user.getUserId());
				int sessionId = udao.loginUser(user1.getUserId());
				getSession(sessionId);
				response.setSessionId(sessionId);
				response.setUser(dtoAssembler.makeDTO(user1));
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		} catch (NoSessionException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	public UserLoginResponse loginUser(int userId) {
		UserLoginResponse response = new UserLoginResponse();
		try {
			User user = getUser(userId);
			if (user != null) {
				int sessionId = udao.loginUser(userId);
				getSession(sessionId);
				response.setSessionId(sessionId);
				response.setUser(dtoAssembler.makeDTO(user));
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		} catch (NoSessionException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	public void logout(int sessionId) {
		udao.logoutUser(sessionId);
	}

	// public PublicUserResponse getPublicUserData(int userId) {
	// PublicUserResponse response = new PublicUserResponse();
	// try {
	// User user = getUser(userId);
	// if (user != null) {
	// udao.getPublicUserData();
	//
	// }
	//
	//
	// } catch (NotAllowedException n) {
	// response.setReturnCode(n.getErrorCode());
	// response.setMessage(n.getMessage());
	// }
	// return response;
	// }

	public UserResponse deleteUser(int userId, int sessionId) {
		UserResponse response = new UserResponse();
		try {
			getUser(userId);
			getSession(sessionId);
			udao.deleteUser(userId);

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
