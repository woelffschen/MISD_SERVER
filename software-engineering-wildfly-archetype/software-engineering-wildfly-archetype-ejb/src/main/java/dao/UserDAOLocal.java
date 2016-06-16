// @Author Sylvia & Daniel

package dao;

import java.math.BigInteger;
import java.util.Calendar;

import javax.ejb.Local;

import entities.Session;
import entities.User;

@Local
public interface UserDAOLocal {

	public User getPublicUserData(User userId);

	public User registerUser(BigInteger userId, String lastname, String firstname, String street, int postalCode, String city, Calendar age,
			char gender, String telephoneNumber);

	public int loginUser(BigInteger userId);

	public void logoutUser(int sessionId);

	public void deleteUser(BigInteger userId);

	public Session findSessionById(int sessionId);

	public User findUserById(BigInteger userId);

}
