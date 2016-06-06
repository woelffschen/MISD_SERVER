// @Author Sylvia & Daniel

package dto;

import javax.ejb.Stateless;

import entities.Attendance;
import entities.Event;
import entities.Menue;
import entities.User;

/**
 * This stateless session bean provides operations for generating data transfer
 * objects from internal entity objects (Customer and Account).
 */

@Stateless
public class DTOAssembler {

	public AttendanceTO makeDTO(Attendance attendance, Event event, User user) {
		AttendanceTO dto = new AttendanceTO();
		dto.setAttendanceId(attendance.getAttendanceId());
		dto.setEventId(event.getEventId());
		dto.setUserId(user.getUserId());
		dto.setUpdateAt(attendance.getUpdateAt());
		dto.setStatus(attendance.getStatus());
		return dto;
	}

	public EventTO makeDTO(Event event, Menue menue, User user) {
		EventTO dto = new EventTO();
		dto.setEventId(event.getEventId());
		dto.setMenueId(menue.getMenueId());
		dto.setMinAge(event.getMinAge());
		dto.setMaxAge(event.getMaxAge());
		dto.setGender(event.getGender());
		dto.setEventStreet(event.getEventStreet());
		dto.setEventPostalCode(event.getEventPostalCode());
		dto.setEventCity(event.getEventCity());
		dto.setEventDateTime(event.getEventDateTime());
		dto.setComments(event.getComments());

		return dto;

	}

	public MenueTO makeDTO(Menue menue) {
		MenueTO dto = new MenueTO();
		dto.setMenueId(menue.getMenueId());
		dto.setName(menue.getName());
		dto.setLactose(menue.getLactose());
		dto.setGluten(menue.getGluten());
		dto.setFructose(menue.getFructose());
		dto.setSorbit(menue.getSorbit());
		dto.setVegan(menue.getVegan());
		dto.setVegetarian(menue.getVegetarian());
		dto.setTitlePic(menue.getTitlePic());
		return dto;

	}

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
		dto.setAlcDrinks(user.getAlcDrinks());
		dto.setUserPic(user.getUserPic());
		dto.setGender(user.getGender());
		return dto;

	}

}
