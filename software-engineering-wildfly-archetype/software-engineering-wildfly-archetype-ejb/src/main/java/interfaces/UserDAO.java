// created by Sylvia & Daniel

package interfaces;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDAO implements UserInterface{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public User getPublicUserData(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User registerUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User logInUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User logOutUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
