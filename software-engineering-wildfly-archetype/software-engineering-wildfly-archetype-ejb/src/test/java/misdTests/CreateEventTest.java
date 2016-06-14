
package misdTests;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import dao.AttendanceDAOLocal;
import dao.EventDAOLocal;
import dao.UserDAOLocal;
import dto.EventResponse;
import dto.UserLoginResponse;
import dto.UserTO;
import onlineService.AttendanceInterface;
import onlineService.EventInterface;
import onlineService.UserInterface;

@RunWith(Arquillian.class)
public class CreateEventTest {

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

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "test.war")
				.addPackages(true, "dao", "dto", "entities", "onlineService", "misdTests")
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource("META-INF/ejb-jar.xml", "ejb-jar.xml");
	}

	@Test
	/**
	 * Prueft, ob ein neuer User erfolgreich registriert werden kann.
	 */
	public void testCreateEvent() throws Exception {

		UserLoginResponse userLoginResponse = uBean.registerUser("Lustig", "Peter", "Straße", 12345, "Stadt", 35,
				"Telefonnummer", 'F');

		int sessionId = userLoginResponse.getSessionId();

		UserTO user1 = userLoginResponse.getUser();
		userLoginResponse = uBean.loginUser(user1.getUserId());

		EventResponse eventResponse = eBean.createEvent(sessionId, user1.getUserId(), 25, 45, "street", 34567, "city",
				"comments", 'M', date1, user1.getUserId(), "name", true, false, true, false, true, false);

		assertEquals(eventResponse.getReturnCode(), 0);

	}

}