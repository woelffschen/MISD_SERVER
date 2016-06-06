package dto;

public class AttendanceResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private int status;
	private AttendanceTO attendanceTO;

	public AttendanceResponse() {
	};
	
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public AttendanceTO getAttendanceTO() {
		return attendanceTO;
	}

	public void setAttendanceTO(AttendanceTO attendanceTO) {
		this.attendanceTO = attendanceTO;
	}

}
