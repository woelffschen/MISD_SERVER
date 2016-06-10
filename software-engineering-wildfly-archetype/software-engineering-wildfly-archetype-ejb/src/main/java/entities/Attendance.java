// @Author Sylvia & Daniel

package entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

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
