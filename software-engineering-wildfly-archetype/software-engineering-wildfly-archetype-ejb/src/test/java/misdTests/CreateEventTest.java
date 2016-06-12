

package misdTests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import dao.UserDAOLocal;
import dto.EventResponse;
import dto.UserLoginResponse;
import dto.UserTO;
import entities.Menue;
import entities.Session;
import entities.User;
import onlineService.EventInterface;
import onlineService.UserInterface;

@RunWith(Arquillian.class)
public class CreateEventTest {

	@EJB
	EventInterface eBean;
	
	@EJB
	UserInterface uBean;
	
	@EJB
	UserDAOLocal udlBean;
	
	@Inject
	private LocalDateTime date1 = LocalDateTime.now();

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
//		User user1 = new User("Lustig", "Peter", "Straße", 12345, "Stadt", 35,'F', "Telefonnummer", true);
//
//		uBean.loginUser(user1.getUserId());
//		Session session = new Session(user1.getUserId());	
//			
		UserLoginResponse userLoginResponse = uBean.registerUser("Lustig", "Peter", "Straße", 12345, "Stadt", 35,
				"Telefonnummer", true, null, 'F');
		//assertEquals(userLoginResponse.getReturnCode(), 0);
		
		int sessionId = userLoginResponse.getSessionId();
		//beans.logout(sessionId);
		//User user1 = new User("Lustig", "Peter", "Straße", 12345, "Stadt", 35,'F', "Telefonnummer", true);
		//UserLoginResponse 
		UserTO user1 = userLoginResponse.getUser();
		userLoginResponse = uBean.loginUser(user1.getUserId());
		
		Menue menue1 = new Menue("meal", true, false, true, false, true, false);
		EventResponse eventResponse = eBean.createEvent(sessionId, user1.getUserId(), menue1, 25, 45, "street", 34567, "city", date1, "comments", 'M');
		
				assertEquals(eventResponse.getReturnCode(), 0);

	}

}