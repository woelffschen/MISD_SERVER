// created by Daniel & Sylvia

package OnlineService;

import javax.ejb.Local;
import javax.jws.WebService;

import entities.User;

@WebService
public class UserInterface {
	public User getPublicUserData(int userId);
	public User registerUser(int userId);
	public User logInUser(int userId);
	public User logOutUser(int userId);
	public User deleteUser(int userId);
}
