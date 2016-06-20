/** 
 * @author Sylvia & Daniel
*/

package dao;

import javax.ejb.Local;

import entities.Session;
import entities.User;

@Local
public interface UserDAOLocal {

	public User registerUser(String eamil, String lastname, String firstname, String street, int postalCode,
			String city, int age, char gender, String telephoneNumber);

	public int loginUser(User user);

	public void logoutUser(int sessionId);

	public void deleteUser(String email);

	public Session findSessionById(int sessionId);

	public User findUserById(String email);

	public User findUserByEmail(String email);

}
