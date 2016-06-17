package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Session {

	@Id
	@GeneratedValue
	private int sessionId;
	@OneToOne
	private User user;

	private Date creationTime;


	public Session() {
		this.creationTime = new Date();
	}
	
	
	public Session(User user) {
		super();
		this.creationTime = new Date();
		this.user = user;
	}


	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}


	public Date getCreationTime() {
		return creationTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}
