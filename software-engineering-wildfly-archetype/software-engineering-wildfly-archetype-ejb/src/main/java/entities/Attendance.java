// @Author Sylvia & Daniel

package entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.print.attribute.standard.DateTimeAtCreation;

@Entity
@IdClass(Attendance.class)
public class Attendance implements Serializable {

	private static final long serialVersionUID = 1L;

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

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	

}
