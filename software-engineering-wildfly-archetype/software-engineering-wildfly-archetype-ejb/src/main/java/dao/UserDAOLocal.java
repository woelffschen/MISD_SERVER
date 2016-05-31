package dao;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserDAOLocal {
	
	public User getPublicUserData(int userId);
	public User registerUser(String lastname,String firstname,String street,int postalCode,String city, int age, char gender);
	public User loginUser(int userId);
	public void logoutUser(int userId);
	public void deleteUser(int userId);

}
