// @Author Sylvia & Daniel

package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity
public class Attendance implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	int attendanceId;
	
	@ManyToOne
	Event event;
	
	@ManyToOne
	User user;

	
	@Column(nullable = true)
	int status;

	public Attendance() {
	}

	public Attendance(Event event, User user) {
		this.event = event;
		this.user = user;
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
	
}
