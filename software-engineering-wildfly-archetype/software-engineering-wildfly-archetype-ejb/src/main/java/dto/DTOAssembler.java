// @Author Sylvia & Daniel

package dto;

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
		dto.setUserId(user.getUserId());
		dto.setStatus(attendance.getStatus());
		return dto;
	}

//	public EventTO makeDTO(int eventId, int menueId, User user) {
//		EventTO dto = new EventTO();
//		dto.setEventId(event.getEventId());
//		dto.setMenueId(menue.getMenueId());
//		dto.setMinAge(event.getMinAge());
//		dto.setMaxAge(event.getMaxAge());
//		dto.setGender(event.getGender());
//		dto.setEventStreet(event.getEventStreet());
//		dto.setEventPostalCode(event.getEventPostalCode());
//		dto.setEventCity(event.getEventCity());
//		dto.setEventDateTime(event.getEventDateTime());
//		dto.setComments(event.getComments());
//		dto.setMenueId(menue.getMenueId());
//		dto.setName(menue.getName());
//		dto.setLactose(menue.getLactose());
//		dto.setGluten(menue.getGluten());
//		dto.setFructose(menue.getFructose());
//		dto.setSorbit(menue.getSorbit());
//		dto.setVega(menue.getVegan());
//		dto.setVegee(menue.getVegetarian());
//
//		return dto;
//
//	}


	public UserTO makeDTO(User user) {
		UserTO dto = new UserTO();
		dto.setUserId(user.getUserId());
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

	
	public PublicUserTO makeDTO1(User user1) {
		PublicUserTO dto = new PublicUserTO();
		dto.setUserId(user1.getUserId());
		dto.setLastname(user1.getLastname());
		dto.setFirstname(user1.getFirstname());
		dto.setCity(user1.getCity());
		dto.setAge(user1.getAge());
		dto.setGender(user1.getGender());
		return dto;

	}
	
}
