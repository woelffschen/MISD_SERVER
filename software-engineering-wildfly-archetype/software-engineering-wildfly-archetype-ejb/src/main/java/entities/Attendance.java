// created by Sylvia & Daniel

package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.print.attribute.standard.DateTimeAtCreation;

@Entity @IdClass(Attendance.class)
public class Attendance implements Serializable{

	
	private static final long serialVersionUID = 1L;

	
	//Attribute-Declaration
	@Id
	Event eventId;
	@Id
	User userId;
	DateTimeAtCreation updateAt;
	int status;
	int e= eventId.eventId;
	int u= userId.userId;
	
	//Parameterloser Konstruktor 
		public Attendance(){};
		
	
	// set status
	public void setCancelAttendance(User u, Event e){
		status = 1;
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
