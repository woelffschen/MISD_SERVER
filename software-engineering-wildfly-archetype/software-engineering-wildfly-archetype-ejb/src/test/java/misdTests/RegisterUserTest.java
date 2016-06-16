package misdTests;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Calendar;

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
		BigInteger bi = new BigInteger("2222222222222222222222222");
		
		UserResponse userResponse = beans.registerUser(bi, "Lustig", "Peter", "Straße", 12345, "Stadt", 11061992, "Tel", 'M');
		
		assertEquals(userResponse.getReturnCode(), 0);

		int sessionId = userResponse.getSessionId();
		beans.logout(sessionId);
	}

}
