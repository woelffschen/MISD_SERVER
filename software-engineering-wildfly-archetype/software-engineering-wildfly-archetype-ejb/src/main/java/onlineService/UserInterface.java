// created by Daniel & Sylvia

package onlineService;

import java.awt.Image;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.jws.WebService;

import dao.UserDAOLocal;
import entities.Session;
import entities.User;

@WebService
@Stateless
public class UserInterface {

	@EJB
	private UserDAOLocal udao;

	@Resource
	private EJBContext ejbContext;

	public User getPublicUserData(User userId) {
		return null;
	}

	public User registerUser(String lastname, String firstname, String street, int postalCode, String city, int age,
			String telephoneNumber, boolean alcDrinks, Image userPic, char gender) {
		return null;
	}

	public int loginUser(User userId) {
		return 0;
	}

	public void logoutUser(int id) {
	}

	public void deleteUser(int userId) {
	}

	private Session getSession(int sessionId) throws NoSessionException {
		Session session = udao.findSessionById(sessionId);
		if (session == null)
			throw new NoSessionException("Bitte zunächst ein Login durchführen.");
		else
			return session;
	}

}
