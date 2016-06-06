// @Author Sylvia & Daniel

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

	@Id
	@GeneratedValue
	int eventId;
	@Column(nullable = false)
	@OneToOne
	Menue menue;
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
	@Column(nullable = false)
	DateTimeAtCreation eventDateTime;
	@Column(nullable = true)
	String comments;
	Attendance attendanceObject;
	User eventOwner;

	private Map<Event, Attendance> attendanceList;

	public Event() {
	};

	public Event(Menue m, int min, int max, String street, int plz, String city, DateTimeAtCreation dateTime,
			String com, User eO, char g) {

		// mit Transaktion
		menue = m;
		minAge = min;
		maxAge = max;
		eventStreet = street;
		eventPostalCode = plz;
		eventCity = city;
		eventDateTime = dateTime;
		comments = com;
		eventOwner = eO;
		gender = g;

	}

	public int getEventId() {
		return eventId;
	}

	public int getMenueId(int m) {
		return menue.getMenueId();
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

	public void setEventDateTime(DateTimeAtCreation i) {
		eventDateTime = i;
	}

	public DateTimeAtCreation getEventDateTime() {
		return eventDateTime;
	}

	public void setComments(String i) {
		comments = i;
	}

	public String getComments() {
		return comments;
	}

	public void setEventOwner(User eO) {
		eventOwner = eO;
	}

	public User getEventOwner() {
		return eventOwner;
	}

	public void setGender(char g) {
		gender = g;
	}

	public char getGender() {
		return gender;
	}

	public Map<Event, Attendance> getAttendanceList() {
		return attendanceList;
	}

	public void setAttendanceList(Map<Event, Attendance> attendanceList) {
		this.attendanceList = attendanceList;
	}

}
