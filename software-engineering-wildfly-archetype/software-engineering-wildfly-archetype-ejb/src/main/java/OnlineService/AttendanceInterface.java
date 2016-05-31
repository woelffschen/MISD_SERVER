// created by Sylvia & Daniel

package OnlineService;

import javax.ejb.Local;
import javax.jws.WebService;

@WebService
public class AttendanceInterface {
	public void confirmAttendance(int eventId, int userId);
	public void rejectAttendance(int eventId, int userId);
	public void requestAttendance(int eventId, int userId);
	public void cancelAttendance(int eventId, int userId);
}
