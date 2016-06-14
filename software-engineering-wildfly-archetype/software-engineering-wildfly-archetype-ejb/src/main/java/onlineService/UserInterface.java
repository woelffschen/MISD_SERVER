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
			int age, String telephoneNumber, char gender)
			throws NoSessionException, NotAllowedException {
		UserLoginResponse response = new UserLoginResponse();
		try {
			User user = udao.registerUser(lastname, firstname, street, postalCode, city, age, telephoneNumber,
					gender);
			if (user != null) {
				int sessionId = udao.loginUser(user.getUserId());
				getSession(sessionId);
				response.setSessionId(sessionId);
				response.setUser(dtoAssembler.makeDTO(user));
			}
		} catch (NoSessionException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

	public UserLoginResponse loginUser(int userId) throws NoSessionException, NotAllowedException {
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
		}
		return response;
	}

	public UserResponse logout(int sessionId) {
		udao.logoutUser(sessionId);
		UserResponse response = new UserResponse();
		return response;
	}

//	 public PublicUserResponse getPublicUserData(int userId) {
//	 PublicUserResponse response = new PublicUserResponse();
//	 try {
//	 User user = getUser(userId);
//	 if (user != null) {
//	 udao.getPublicUserData();
//	
//	 }
//	
//	
//	 } catch (NotAllowedException n) {
//	 response.setReturnCode(n.getErrorCode());
//	 response.setMessage(n.getMessage());
//	 }
//	 return response;
//	 }

	public UserResponse deleteUser(int userId) throws NoSessionException, NotAllowedException {
		UserResponse response = new UserResponse();
		try {
			getUser(userId);
			udao.deleteUser(userId);

		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		}
		return response;
	}

}
