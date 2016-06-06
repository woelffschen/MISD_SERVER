package dto;

public class UserResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private UserTO userTO;

	public UserResponse() {
	};

	public UserTO getUserTO() {
		return userTO;
	}

	public void setUserTO(UserTO userTO) {
		this.userTO = userTO;
	}

}
