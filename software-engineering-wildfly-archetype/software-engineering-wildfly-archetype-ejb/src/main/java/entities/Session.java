package entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Session {

	@Id
	@GeneratedValue
	private int sessionId;
	@ManyToOne
	private User user;
	private BigInteger userId;
	private Date creationTime;


	public Session() {
	}

	public Session(BigInteger userId) {
		this.setUserId(userId);
		this.creationTime = new Date();
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

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

}
