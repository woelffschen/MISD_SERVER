/** 
 * @author Sylvia & Daniel
*/

package dto;

public class UserResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private int sessionId;

	public UserResponse() {
	};

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

}
