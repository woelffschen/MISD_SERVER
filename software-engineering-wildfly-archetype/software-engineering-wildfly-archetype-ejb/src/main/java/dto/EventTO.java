// @Author Sylvia & Daniel

package dto;

import java.time.LocalDateTime;

public class EventTO extends DataTransferObject {

	private static final long serialVersionUID = 3440740273700082798L;

	private int eventId;
	private int menueId;
	private int minAge;
	private int maxAge;
	private char gender;
	private String eventStreet;
	private int eventPostalCode;
	private String eventCity;
	private int eventOwner;
	private LocalDateTime eventDateTime;
	private String comments;

	public EventTO() {
	};

	public EventTO(int eventId, int menueId, int min, int max, char g, String street, int plz, String city,
			LocalDateTime dateTime, String com, int eO) {

		super();
		this.eventId = eventId;
		this.menueId = menueId;
		minAge = min;
		maxAge = max;
		gender = g;
		eventStreet = street;
		eventPostalCode = plz;
		eventCity = city;
		eventDateTime = dateTime;
		comments = com;
		eventOwner = eO;

	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getEventId(int eventId) {
		return eventId;
	}

	public void setMenueId(int menueId) {
		this.menueId = menueId;
	}

	public int getMenueId() {
		return menueId;
	}

	public void setGender(char g) {
		gender = g;

	}

	public char getGender() {
		return gender;
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

	public void setEventDateTime(LocalDateTime i) {
		eventDateTime = i;
	}

	public LocalDateTime getEventDateTime() {
		return eventDateTime;
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

}
