// created by Daniel & Sylvia

package onlineService;

import java.math.BigInteger;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import dao.UserDAOLocal;
import dto.DTOAssembler;
import dto.ReturnCodeResponse;
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

	private User getUser(BigInteger userId) throws NotAllowedException {
		User user = udao.findUserById(userId);
		if (user == null)
			throw new NotAllowedException("Diese Aktion ist nicht erlaubt!");
		else
			return user;
	}

	public UserResponse registerUser(BigInteger userId, String lastname, String firstname, String street, int postalCode, String city,
			Calendar age, String telephoneNumber, char gender) {
		UserResponse response = new UserResponse();
		try {
			User user = udao.registerUser(userId, lastname, firstname, street, postalCode, city, age, gender, telephoneNumber);
			if (user != null) {
				User user1 = getUser(user.getUserId());
				int sessionId = udao.loginUser(user1.getUserId());
	
				response.setSessionId(sessionId);
				//response.setUserId(user1.getUserId());
			}
		} catch (NotAllowedException n) {
			response.setReturnCode(n.getErrorCode());
			response.setMessage(n.getMessage());
		} 
		return response;
	}

	public UserLoginResponse loginUser(BigInteger userId) {
		UserLoginResponse response = new UserLoginResponse();
		try {
			User user = getUser(userId);
			if (user != null) {
				int sessionId = udao.loginUser(userId);
				response.setSessionId(sessionId);
			
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
			if (session != null);
			udao.logoutUser(sessionId);
		
		} catch (NoSessionException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	
	}

	// 
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

	
	// hier nur ReturnCodeResponse zurück schicken!!
	public UserResponse deleteUser(BigInteger userId, int sessionId) {
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
