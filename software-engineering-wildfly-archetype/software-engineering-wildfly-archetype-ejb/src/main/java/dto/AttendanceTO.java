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
	private int status;
	private int e= eventId.eventId;
	private int u= userId.userId;
	
	//Parameterloser Konstruktor 
	AttendanceTO(){};
	
	
	// set status
	public void setCancelAttendance(User u, Event e){
		status= 1;
	}
	
	public void setConfirmAttendance(User u, Event e){
		status = 2;
	}

	public void setRequestAttendance(User u, Event e){
		status = 3;
	}
	
	public void setRejectAttendance(User u, Event e){
		status = 4;
	}
	
	//get status
	public int getStatus(User u, Event e){
		return status;
	}
	
	//set status
			public void setStatus(int i){
			 status=i;
			}
	
}//End Class
