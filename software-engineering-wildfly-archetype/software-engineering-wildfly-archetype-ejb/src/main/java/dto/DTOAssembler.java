// @Author Sylvia & Daniel

package dto;

import java.util.List;

import javax.ejb.Stateless;

import entities.Attendance;
import entities.Event;
//import entities.Menue;
import entities.User;

/**
 * This stateless session bean provides operations for generating data transfer
 * objects from internal entity objects (Customer and Account).
 */

@Stateless
public class DTOAssembler {

	public AttendanceTO makeDTO(Attendance attendance, Event event, User user) {
		AttendanceTO dto = new AttendanceTO();
		//dto.setAttendanceId(attendance.GET);
		dto.setEventId(event.getEventId());
		dto.setEmail(user.getEmail());
		dto.setStatus(attendance.getStatus());
		return dto;
	}

	public EventTO makeDTO(Event event) {
		EventTO result = new EventTO();
		
		result.setEventId(event.getEventId());
		result.setComments(event.getComments());
		result.setEventCity(event.getEventCity());
		result.setDateTime(event.getEventDateTime());
		result.setEventId(event.getEventId());
		result.setEventOwner(event.getEventOwner());
		result.setEventPostalCode(event.getEventPostalCode());
		result.setGender(event.getGender());
		result.setFructose(event.getMenue().getFructose());
		result.setGluten(event.getMenue().getGluten());
		result.setLactose(event.getMenue().getLactose());
		result.setMaxAge(event.getMaxAge());
		result.setMenueId(event.getMenue().getMenueId());
		result.setMinAge(event.getMinAge());
		result.setName(event.getMenue().getName());
		result.setSorbit(event.getMenue().getSorbit());
		result.setVega(event.getMenue().getVegan());
		result.setVegee(event.getMenue().getVegetarian());
			
		
		return result;
	}
	public EventTO[] makeDTOs(List<Event> events) {
		EventTO[] result = new EventTO[events.size()];
		
		for(int i = 0; i < events.size(); i++) {
			result[i] = makeDTO(events.get(i));
		}
		
		return result;
	}

	public UserTO makeDTO(User user) {
		UserTO dto = new UserTO();
		dto.setEmail(user.getEmail());
		dto.setLastname(user.getLastname());
		dto.setFirstname(user.getFirstname());
		dto.setStreet(user.getStreet());
		dto.setPostalCode(user.getPostalCode());
		dto.setCity(user.getCity());
		dto.setAge(user.getAge());
		dto.setTelephoneNumber(user.getTelephoneNumber());
		dto.setGender(user.getGender());
		return dto;

	}

	
}
