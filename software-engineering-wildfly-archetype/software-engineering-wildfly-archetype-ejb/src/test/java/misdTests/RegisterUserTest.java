package misdTests;

import static org.junit.Assert.assertEquals;

import javax.ejb.EJB;

import org.junit.Test;

import dto.UserResponse;
import onlineService.UserInterface;


public class RegisterUserTest extends DataSet {

	
	@EJB
	private UserInterface beans;


	@Test
	/**
	 * Prueft, ob ein neuer User erfolgreich registriert werden kann.
	 */
	public void testRegistration() throws Exception {
		
		UserResponse userResponse = beans.registerUser("Test@IchWeißnichtWasIchTuh.de", "Lustig", "Peter", "Straße", 12345, "Stadt", 11061992, "Tel", 'M');
		
		assertEquals(userResponse.getReturnCode(), 0);

		int sessionId = userResponse.getSessionId();
		beans.logout(sessionId);
	}

}
