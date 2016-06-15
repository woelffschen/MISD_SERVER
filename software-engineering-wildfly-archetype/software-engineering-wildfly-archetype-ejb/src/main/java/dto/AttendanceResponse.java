// created by Sylvia & Daniel

package dto;

public class AttendanceResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private int status;

	public AttendanceResponse() {
	};
	
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
