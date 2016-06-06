// @Author Sylvia & Daniel

package dao;

import java.awt.Image;
import java.util.List;

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
	public User getPublicUserData(User userId) {
		List results = em
				.createQuery(
						"SELECT lastname, firstname, userId, userPic, city, age, gender FROM Customer c WHERE c.userName LIKE :custName")
				.setParameter("userId", userId).getResultList();
		if (results.size() == 1) {
			return (User) results.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User registerUser(String lastname, String firstname, String street, int postalCode, String city, int age,
			String telephoneNumber, boolean alcDrinks, Image userPic, char gender) {
		User user = new User();
		em.persist(user);
		return user;
	}

	// login
	public int loginUser(User userId) {
		Session newSession = new Session(userId);
		em.persist(newSession);
		return newSession.getSessionId();
	}

	// logout
	public void logoutUser(int id) {
		Session session = em.find(Session.class, id);
		if (session != null) {
			em.remove(session);
		}
	}

	// delete User
	@Override
	public void deleteUser(int userId) {
		em.remove(userId);
	}

	// find Session by Id
	@Override
	public Session findSessionById(int sessionId) {
		return em.find(Session.class, sessionId);
	}

	@Override
	public User findUserById(int userId) {
		return em.find(User.class, userId);
	}

}
