// created by Sylvia & Daniel

package dto;

import javax.persistence.Id;
import javax.print.attribute.standard.DateTimeAtCreation;

import dto.DataTransferObject;
import entities.Event;
import entities.User;

public class AttendanceTO extends DataTransferObject {
	
	private static final long serialVersionUID = 3440740273700082798L;
	
	//Attribute-Declaration
	private Event eventId;
	private User userId;
	private DateTimeAtCreation updateAt;
	private String status;
	private int e= eventId.eventId;
	private int u= userId.userId;
	
	//Parameterloser Konstruktor 
	AttendanceTO(){};
	
	
	// set status
	public void setCancelAttendance(User u, Event e){
		status = "cancelled";
	}
	
	public void setConfirmAttendance(User u, Event e){
		status = "confirmed";
	}

	public void setRequestAttendance(User u, Event e){
		status = "requested";
	}
	
	public void setRejectAttendance(User u, Event e){
		status = "rejected";
	}
	
	//get status
	public String getStatus(User u, Event e){
		return status;
	}
	
	
}//End Class
