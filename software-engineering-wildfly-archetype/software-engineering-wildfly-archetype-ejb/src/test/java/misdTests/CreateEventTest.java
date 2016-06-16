
package misdTests;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Calendar;

import javax.ejb.EJB;

import org.jboss.arquillian.core.api.annotation.Inject;
import org.junit.Test;

import dao.AttendanceDAOLocal;
import dao.EventDAOLocal;
import dao.UserDAOLocal;
import dto.ReturnCodeResponse;
import dto.UserLoginResponse;
import dto.UserResponse;
import dto.UserTO;
import onlineService.AttendanceInterface;
import onlineService.EventInterface;
import onlineService.UserInterface;

public class CreateEventTest extends DataSet{

	@EJB
	EventInterface eBean;

	@EJB
	UserInterface uBean;

	@EJB
	AttendanceInterface aBean;

	@EJB
	UserDAOLocal udlBean;

	@EJB
	EventDAOLocal edlBean;

	@EJB
	AttendanceDAOLocal adlBean;

	@Inject
	private Calendar date1;



	@Test
	/**
	 * Prueft, ob ein neuer User erfolgreich registriert werden kann.
	 */
	public void testCreateEvent() throws Exception {
		BigInteger bi = new BigInteger("222222222222222222222222222222222");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1992);
		c.set(Calendar.MONTH, 6);
		c.set(Calendar.DAY_OF_MONTH, 11);
		
		UserResponse userResponse = uBean.registerUser(bi,"Lustig", "Peter", "Straße", 12345, "Stadt", c,
				"Telefonnummer", 'F');

		int sessionId = userResponse.getSessionId();

		UserTO user1= new UserTO();

		
		ReturnCodeResponse eventResponse = eBean.createEvent(sessionId,bi, 25, 45, "street", 34567, "city",
				"comments", 'M', c, user1.getUserId(), "name", true, false, true, false, true, false);

		assertEquals(eventResponse.getReturnCode(), 0);

	}

}