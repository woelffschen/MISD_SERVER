// created by Daniel & Sylvia

package interfaces;

import javax.ejb.Local;

@Local
public interface UserInterface {
	public User getPublicUserData(int userId);
	public User registerUser(int userId);
	public User logInUser(int userId);
	public User logOutUser(int userId);
	public User deleteUser(int userId);
}
