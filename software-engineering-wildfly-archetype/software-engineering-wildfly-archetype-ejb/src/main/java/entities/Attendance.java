// @Author Sylvia & Daniel

package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.print.attribute.standard.DateTimeAtCreation;

@Entity
@IdClass(Attendance.class)
public class Attendance implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	int attendanceId;
	@Id
	Event eventId;
	@Id
	User userId;
	DateTimeAtCreation updateAt;
	int status;
	int e = eventId.eventId;
	int u = userId.userId;

	public Attendance() {
	};

	public Attendance(User u, Event e) {
		u = userId;
		e = eventId;
	}

	public void setCancelAttendance(User u, Event e) {
		status = 1;
	}

	public void setConfirmAttendance(User u, Event e) {
		status = 2;
	}

	public void setRequestAttendance(User u, Event e) {
		status = 3;
	}

	public void setRejectAttendance(User u, Event e) {
		status = 4;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int i) {
		status = i;
	}

	public int getAttendanceId() {
		return attendanceId;
	}

	public User getUserId() {
		return userId;
	}

	public Event getEventId() {
		return eventId;

	}

	public DateTimeAtCreation getUpdateAt() {
		return updateAt;
	}

}
