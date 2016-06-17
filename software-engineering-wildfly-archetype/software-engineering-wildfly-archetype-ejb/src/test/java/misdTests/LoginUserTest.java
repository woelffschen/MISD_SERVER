package misdTests;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import dto.UserResponse;
import onlineService.UserInterface;

@RunWith(Arquillian.class)
public class LoginUserTest extends DataSet {
	
	@EJB
	UserInterface beans;



	@Test
	public void testLogin() throws Exception {
		
		
		UserResponse userResponse = beans.registerUser("Test@IchWeißnichtWasIchTuh.de", "Lustig", "Peter", "Straße", 12345, "Stadt", 11061992, "Tel", 'M');
		
		int sessionId = userResponse.getSessionId();
		beans.logout(sessionId); //User ausloggen
		
		 userResponse = beans.loginUser("Test@IchWeißnichtWasIchTuh.de"); 
		 
		 assertEquals(userResponse.getReturnCode(), 0);

			sessionId = userResponse.getSessionId();
			beans.logout(sessionId);
	}
}