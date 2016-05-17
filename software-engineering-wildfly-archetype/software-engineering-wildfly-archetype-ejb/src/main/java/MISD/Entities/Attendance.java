package MISD.Entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.print.attribute.standard.DateTimeAtCreation;

@Entity @IdClass(Attendance.class)
public class Attendance implements Serializable{

	
	private static final long serialVersionUID = 1L;

	//created by Sylvia/ Daniel
	
	//PArameterloser Konstruktor 
	Attendance(){};
	
	//Attribute-Declaration
	@Id
	Event eventId;
	@Id
	User userId;
	DateTimeAtCreation updateAt;
	String status;
	int e= eventId.eventId;
	int u= userId.userId;
	
	
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
