// @Author Sylvia & Daniel

package entities;

import java.io.Serializable;
import java.math.BigInteger;
//import java.util.Set;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	int eventId;
	
	@OneToOne
	Menue menue;
	
	@Column(nullable = false)
	int menueId;	
	@Column(nullable = false)
	int minAge;
	@Column(nullable = false)
	int maxAge;
	@Column(nullable = false)
	char gender;
	@Column(nullable = false)
	String eventStreet;
	@Column(nullable = false)
	int eventPostalCode;
	@Column(nullable = false)
	String eventCity;
	@Column(nullable = true)
	String comments;
	@Column(nullable = false)
	boolean takePlace;
	@Column(nullable = false)
	int dateTime;
	@Column(nullable = false)
	String eventOwner;
	

	
	@OneToMany(mappedBy = "event")
	private Set<Attendance> attendance;

	public Event() {
	};

	public Event(int menueId, int min, int max, String street, int plz, String city, 
			String com, char g, int d, String eo) {

		// mit Transaktion
		//menueId = m;
		this.menueId = menueId;
		minAge = min;
		maxAge = max;
		eventStreet = street;
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

	public void setEventStreet(String i) {
		eventStreet = i;
	}

	public String getEventStreet() {
		return eventStreet;
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

	
	public int getEventDateTime() {
		return dateTime;
	}

	public void setEventDateTime(int dateTime) {
		this.dateTime = dateTime;
	}

	public void setComments(String i) {
		comments = i;
	}

	public String getComments() {
		return comments;
	}
	
	public void setEventOwner(String eO) {
		eventOwner = eO;
	}

	public String getEventOwner() {
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
