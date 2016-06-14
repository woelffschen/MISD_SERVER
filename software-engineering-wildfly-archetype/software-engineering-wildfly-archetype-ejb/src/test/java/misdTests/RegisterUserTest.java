package misdTests;

import static org.junit.Assert.assertEquals;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import dto.UserLoginResponse;
import onlineService.UserInterface;

@RunWith(Arquillian.class)
public class RegisterUserTest {

	@EJB
	UserInterface beans;

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
	public void testRegistration() throws Exception {
		UserLoginResponse userLoginResponse = beans.registerUser("Lustig", "Peter", "Straße", 12345, "Stadt", 35,
				"Telefonnummer", 'F');
		assertEquals(userLoginResponse.getReturnCode(), 0);

		int sessionId = userLoginResponse.getSessionId();
		beans.logout(sessionId);
	}

}
