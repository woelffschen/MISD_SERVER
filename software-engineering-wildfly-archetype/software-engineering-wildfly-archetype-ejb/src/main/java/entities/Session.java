package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Session {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private User user;
	private Date creationTime;

	public Session() {
	}

	public Session(User user) {
		this.user = user;
		this.creationTime = new Date();
	}

	public int getSessionId() {
		return id;
	}

	public void setSessionId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreationTime() {
		return creationTime;
	}

}
