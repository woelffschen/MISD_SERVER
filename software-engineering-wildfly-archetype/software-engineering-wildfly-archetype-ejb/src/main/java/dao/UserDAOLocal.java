// @Author Sylvia & Daniel

package dao;

import java.awt.Image;

import javax.ejb.Local;

import entities.Session;
import entities.User;

@Local
public interface UserDAOLocal {

	public User getPublicUserData(User userId);

	public User registerUser(String lastname, String firstname, String street, int postalCode, String city, int age,
			String telephoneNumber, boolean alcDrinks, Image userPic, char gender);

	public int loginUser(User userId);

	public void logoutUser(int userId);

	public void deleteUser(int userId);

	public Session findSessionById(int sessionId);

	public User findUserById(int userId);

}
