// @Author Sylvia & Daniel

package dao;

import entities.Attendance;
import entities.Event;
import entities.User;
import onlineService.NotAllowedException;

public interface AttendanceDAOLocal {

	public int cancelAttendance(Event event, User user) throws NotAllowedException;

	public int requestAttendance(Event event, User user) throws NotAllowedException;

	public int confirmAttendance(Event event, User user, User userAendern) throws NotAllowedException;

	public int rejectAttendance(Event event, User user, User userAendern) throws NotAllowedException;

	public Attendance findAttendanceById(int attendanceId);

}
