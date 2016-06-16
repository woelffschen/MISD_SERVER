package misdTests;

import static org.junit.Assert.assertEquals;

import javax.ejb.EJB;

import org.junit.Test;

import dto.UserResponse;
import dto.UserTO;
import onlineService.UserInterface;


public class LoginUserTest extends DataSet {
	
	@EJB
	UserInterface beans;



	@Test
	public void testLogin() throws Exception {
		
		
		UserResponse userResponse = beans.registerUser("Test@IchWeißnichtWasIchTuh.de", "Lustig", "Peter", "Straße", 12345, "Stadt", 11061992, "Tel", 'M');
		
		int sessionId = userResponse.getSessionId();
		beans.logout(sessionId); //User ausloggen
		
		UserTO user1=new UserTO();
		 userResponse = beans.loginUser(user1.getUserId()); 
		 
		 assertEquals(userResponse.getReturnCode(), 0);

			sessionId = userResponse.getSessionId();
			beans.logout(sessionId);
	}
}