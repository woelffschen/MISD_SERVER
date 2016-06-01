// created by Sylvia & Daniel

package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.print.attribute.standard.DateTimeAtCreation;

@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Attribute-Declaration 
	@Id @GeneratedValue
	int eventId;
	@Column(nullable =false)
	@OneToOne
	Menue menue;
	@Column(nullable =false)
	int minAge;
	@Column(nullable =false)
	int maxAge;
	@Column(nullable =false)
	char gender;
	@Column(nullable =false)
	String eventStreet;
	@Column(nullable =false)
	int eventPostalCode;
	@Column(nullable =false)
	String eventCity;
	@Column(nullable =false)
	DateTimeAtCreation eventDateTime;
	@Column(nullable =true)
	String comments;
	Attendance attendanceObject;
	User eventOwner;

	private Map<Event,Attendance> attendanceList;
	
	
	//Parameterloser Konstruktor 
	public Event(){};

	
	public Event(Menue m, int min, int max, String street, int plz, String city, DateTimeAtCreation dateTime,String com, User eO,char g){
		
		//mit Transaktion
		menue= m;
		minAge= min;
		maxAge= max;
		eventStreet= street;
		eventPostalCode= plz;
		eventCity= city;	
		eventDateTime= dateTime;
		comments= com;
		eventOwner = eO;
		gender=g;
		
	}//End Constructor
	
	
	//set gender	
			public void setGender(char g){
				gender= g;;
			}
		
	
	//get gender	
			public char getGender(){
				return gender;
			}
		
	
	//set EventOwner	
		public void setEventOwner(User eO){
			eventOwner = eO;
		}

	//get EventOwner	
		public User getEventOwner(){
			return eventOwner;
		}
	
//get Id	
	public int getId(int userId){
		return eventId;
	}

//get Menue	
	public int getMenueById(){
		return menue.getMenueById();
	}
// get and set minAge	
	public void setMinAge(int i){
		minAge=i;
	}
	
	public int getMinAge(){
		return minAge;
	}
// get and set maxAge
	public void setMaxAge(int i){
		maxAge=i;
	}
	
	public int getMaxAge(){
		return maxAge;
	}
// get and set eventStreet	
	public void setEventStreet(String i){
		eventStreet=i;
	}
	
	public String getEventStreet(){
		return eventStreet;
	}
// get and set eventPostalCode	
	public void setEventPostalCode(int i){
		eventPostalCode=i;
	}
	
	public int geteventPostalCode(){
		return eventPostalCode;
	}
// get and set eventCity	
	public void setEventCity(String i){
		eventCity=i;
	}
	
	public String getEventCity(){
		return eventCity;
	}
// get and set eventDateTime	
	public void setEventDateTime(DateTimeAtCreation i){
		eventDateTime=i;
	}
	
	public DateTimeAtCreation getEventDateTime(){
		return eventDateTime;
	}
// get and set comments	
	public void setComments(String i){
		comments=i;
	}
	
	public String getComments(){
		return comments;
	}
	
	
		
	public int getStatus(User u, Event e){
			return attendanceObject.status;
		}
	
    public List<Attendance> getAttendanceList(int eventId){
	    	return new ArrayList<Attendance>(attendanceList.values());
	    }

}// end Event
