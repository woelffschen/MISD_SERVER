package misdTests;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Calendar;

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
		BigInteger bi = new BigInteger("222222222222222222222222222222222");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1992);
		c.set(Calendar.MONTH, 6);
		c.set(Calendar.DAY_OF_MONTH, 11);
		UserResponse userLoginResponse;
		//registriere User
		
		UserResponse userResponse = beans.registerUser(bi, "Lustig", "Peter", "Straße", 12345, "Stadt", c, "Tel", 'M');
		
		int sessionId = userResponse.getSessionId();
		beans.logout(sessionId); //User ausloggen
		
		UserTO user1=new UserTO();
		 userLoginResponse = beans.loginUser(user1.getUserId()); 
		 
		 assertEquals(userResponse.getReturnCode(), 0);

			sessionId = userResponse.getSessionId();
			beans.logout(sessionId);
	}
}