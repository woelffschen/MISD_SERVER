/** 
 * @author Sylvia & Daniel
*/

package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Session;
import entities.User;

@Stateless
public class UserDAO implements UserDAOLocal {

	@PersistenceContext
	EntityManager em;

	@Override
	public User registerUser(String email, String lastname, String firstname, String street, int postalCode,
			String city, int age, char gender, String telephoneNumber) {
		User user = new User(email, lastname, firstname, street, postalCode, city, age, gender, telephoneNumber);
		em.persist(user);
		return user;
	}

	@Override
	public int loginUser(User user) {
		Session newSession = new Session(user);
		em.persist(newSession);
		return newSession.getSessionId();
	}

	@Override
	public void logoutUser(int sessionId) {
		Session session = findSessionById(sessionId);
		if (session != null) {
			em.remove(session);
		}
	}

	@Override
	public void deleteUser(String email) {
		em.remove(email);
	}

	@Override
	public Session findSessionById(int sessionId) {
		return em.find(Session.class, sessionId);
	}

	@Override
	public User findUserById(String email) {
		return em.find(User.class, email);
	}

	@Override
	public User findUserByEmail(String email) {
		return em.find(User.class, email);
	}

}
