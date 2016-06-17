// created by Daniel & Sylvia
package misdTests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import dao.EventDAOLocal;
import dao.UserDAOLocal;
import dto.ReturnCodeResponse;
import dto.UserResponse;
import entities.Attendance;
import entities.Event;
import onlineService.EventInterface;
import onlineService.UserInterface;

@RunWith(Arquillian.class)
public class CreateEventTest extends DataSet{



	@EJB
	private UserInterface beans;
	
	@EJB
	private EventInterface ebeans;
	
	@EJB
	private UserDAOLocal udao;
	
	@EJB
	public EventDAOLocal edao;
	


	@Test
	@InSequence(1)
	public void testCreateEvent() throws Exception {
		UserResponse userResponse = beans.registerUser("Test@isp.de","Lustig", "Peter", "Straße", 12345, "Stadt", 30,
				"Telefonnummer", 'F');
		
		assertEquals("User not created", 0, userResponse.getReturnCode(), 0);
		
		int sessionId = userResponse.getSessionId();
		
		Assert.assertNotEquals("No Session", 0, sessionId, 0);
	
		ReturnCodeResponse eventResponse = ebeans.createEvent(sessionId,25, 45, "street", 34567, "city",
				"comments", 'M',11061992,"Test@isp.de" , "name", true, false, true, false, true, false);

		assertEquals("Event not created", 0, eventResponse.getReturnCode(), 0);
	}
	@Test
	@InSequence(2)
	public void testFindCreatedEvent() throws Exception {
		List<Event> eventResponse = edao.filterCity("Test@isp.de","city");

		assertEquals(1, eventResponse.size(), 0);
	}

}