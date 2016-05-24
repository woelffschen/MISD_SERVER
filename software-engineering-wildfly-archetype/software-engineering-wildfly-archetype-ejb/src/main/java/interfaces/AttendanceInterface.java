// created by Sylvia & Daniel

package interfaces;

import javax.ejb.Local;

@Local
public interface AttendanceInterface {
	public void confirmAttendance(int eventId, int userId);
	public void rejectAttendance(int eventId, int userId);
	public void requestAttendance(int eventId, int userId);
	public void cancelAttendance(int eventId, int userId);
}
