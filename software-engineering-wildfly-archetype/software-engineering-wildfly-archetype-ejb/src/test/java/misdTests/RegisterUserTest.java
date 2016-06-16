package misdTests;

import static org.junit.Assert.assertEquals;

import javax.ejb.EJB;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import dto.UserResponse;
import onlineService.UserInterface;

//@RunWith(Arquillian.class)
public class RegisterUserTest extends DataSet {

	@EJB
	private UserInterface beans;
	

	
	/**
	 * Prueft, ob ein neuer User erfolgreich registriert werden kann.
	 */
	@Test
	public void testRegistration() throws Exception {
		
//		UserResponse userResponse = beans.registerUser("Test@IchWeißnichtWasIchTuh.de", "Lustig", "Peter", "Straße", 12345, "Stadt", 11061992, "Tel", 'M');
//		
//		assertEquals(userResponse.getReturnCode(), 0);
//
//		int sessionId = userResponse.getSessionId();
//		beans.logout(sessionId);
	}

}
