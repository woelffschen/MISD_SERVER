// @Author Sylvia & Daniel

package dto;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class AttendanceTO extends DataTransferObject {

	private static final long serialVersionUID = 3440740273700082798L;

	private int attendanceId;
	private int eventId;
	private BigInteger userId;
	private LocalDateTime updateAt;
	private int status;

	public AttendanceTO() {
	};

	public AttendanceTO(int attendanceId, int eventId, BigInteger userId, LocalDateTime updateAt, int status) {
		super();
		this.attendanceId = attendanceId;
		this.eventId = eventId;
		this.userId = userId;
		this.updateAt = updateAt;
		this.status = status;

	};

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int i) {
		this.attendanceId = i;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
