package dto;

import java.math.BigInteger;

public class UserResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private int sessionId;
//	private BigInteger userId;

	public UserResponse() {
	};
	
	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

//	public BigInteger getUserId() {
//		return userId;
//	}
//
//	public void setUserId(BigInteger userId) {
//		this.userId = userId;
//	}
//
//	
	

}
