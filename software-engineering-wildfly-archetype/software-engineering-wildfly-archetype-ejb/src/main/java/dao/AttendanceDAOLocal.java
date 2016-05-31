package dao;

import javax.ejb.Local;

import entities.Event;
import entities.User;

@Local
public interface AttendanceDAOLocal {
	
	
	public int cancelAttendance(Event event, User user);
	public int requestAttendance(Event event, User user);
	public void confirmAttendance(Event event, User user, User userAendern);
	public void rejectAttendance(Event event, User user, User userAendern);
	
	
}