// @Author Sylvia & Daniel

package entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(Attendance.class)
public class Attendance implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	int attendanceId;
	@Id
	@ManyToOne
	Event event;
	@Id
	@ManyToOne
	User user;

	LocalDateTime updateAt;

	int status;

	public Attendance() {
	}

	public Attendance(int eventId, int userId) {
		eventId = event.getEventId();
		userId = user.getUserId();
	}

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setCancelAttendance(int attendanceId) {
		status = 1;
	}

	public void setConfirmAttendance(int attendanceId) {
		status = 2;
	}

	public void setRequestAttendance(int attendanceId) {
		status = 3;
	}

	public void setRejectAttendance(int attendanceId) {
		status = 4;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int i) {
		status = i;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendance other = (Attendance) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
