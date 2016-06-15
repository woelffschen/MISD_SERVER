//@Author Sylvia & Daniel

package entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EventPublic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false)
	int eventId;
	
	@Column(nullable = false)
	int menueId;	
	@Column(nullable = false)
	int minAge;
	@Column(nullable = false)
	int maxAge;
	@Column(nullable = false)
	char gender;
	@Column(nullable = false)
	int eventPostalCode;
	@Column(nullable = false)
	String eventCity;
	@Column(nullable = true)
	String comments;
	@Column(nullable = false)
	boolean takePlace;
	@Column(nullable = false)
	Calendar dateTime;
	@Column(nullable = false)
	int eventOwner;
	


	public EventPublic() {
	};

	public EventPublic(int m, int min, int max, int plz, String city, 
			String com, char g, Calendar d, int eo) {

		// mit Transaktion
		menueId = m;
		minAge = min;
		maxAge = max;
		eventPostalCode = plz;
		eventCity = city;
		comments = com;
		gender = g;
		dateTime = d;
		eventOwner = eo;
		takePlace = true;		
	}
	
	public int getMenueId() {
		return menueId;
	}
	
	public void setMenueId(int menueId) {
		this.menueId = menueId;
	}
	
	public int getEventId() {
		return eventId;
	}

	public void setMinAge(int i) {
		minAge = i;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMaxAge(int i) {
		maxAge = i;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setEventPostalCode(int i) {
		eventPostalCode = i;
	}

	public int getEventPostalCode() {
		return eventPostalCode;
	}

	public void setEventCity(String i) {
		eventCity = i;
	}

	public String getEventCity() {
		return eventCity;
	}

	
	public Calendar getEventDateTime() {
		return dateTime;
	}

	public void setEventDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}

	public void setComments(String i) {
		comments = i;
	}

	public String getComments() {
		return comments;
	}
	
	public void setEventOwner(int eO) {
		eventOwner = eO;
	}

	public int getEventOwner() {
		return eventOwner;
	}

	public void setGender(char g) {
		gender = g;
	}

	public char getGender() {
		return gender;
	}

	public void setTakePlace(boolean b) {
		takePlace = b;
	}

	public boolean getTakePlace() {
		return takePlace;
	}
	
//	public Set<Attendance> getAttendanceList() {
//		return attendanceList;
//	}
//
//	public void setAttendanceList(Set<Attendance> attendanceList) {
//		this.attendanceList = attendanceList;
//	}

}
