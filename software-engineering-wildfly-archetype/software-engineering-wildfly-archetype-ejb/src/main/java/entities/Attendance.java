// @Author Sylvia & Daniel

package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity
public class Attendance implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
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

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAttendanceId() {
		return attendanceId;
	}
	

}
