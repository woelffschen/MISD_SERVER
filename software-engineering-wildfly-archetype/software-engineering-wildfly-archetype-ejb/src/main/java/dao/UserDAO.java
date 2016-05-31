// created by Sylvia & Daniel

package dao;

import java.awt.Image;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.xbank.dao.XbankDAOLocal;
import de.xbank.entities.Customer;
import de.xbank.entities.XbankSession;
import entities.Session;
import entities.User;

@Stateless
public class UserDAO implements UserDAOLocal{
	
	@PersistenceContext
	EntityManager em;

	
	// login
    public int loginUser(User user) {
       Session newSession = new Session(user);
        em.persist(newSession);
        return newSession.getId();
    }
    
    //find Session by Id
    public Session findSessionById(int id) {
    	return em.find(Session.class, id);
    }

	//logout
    public void logoutUser(int id) {
    	Session session = em.find(Session.class, id);
    	if (session != null) {
    		em.remove(session);
    	}
    }
	
	@Override
	public void deleteUser(int userId) {
		em.remove(userId);
	}
	
	
	
	@Override
	public User getPublicUserData(int userId) {
		List results = em.createQuery("SELECT lastname, firstname, userId, userPic, city, age, gender FROM Customer c WHERE c.userName LIKE :custName")
                .setParameter("userId", userId)
                .getResultList();
		if (results.size()==1) {
		   return (User) results.get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public User registerUser(String lastname,String firstname,String street,int postalCode,String city, int age, char gender){
				User user = new User();
				em.persist(user);	
				return user;
	}



}
