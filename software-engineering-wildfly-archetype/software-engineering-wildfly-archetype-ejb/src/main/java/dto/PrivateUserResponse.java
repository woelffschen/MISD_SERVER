// created by Sylvia & Daniel

package dto;

import java.math.BigInteger;
import java.util.Calendar;

public class PrivateUserResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private BigInteger userId;
	private String lastname;
	private String firstname;
	private String city;
	private Calendar age;
	private char genderUser;
	private int menueId;
	private int minAge;
	private int maxAge;
	private char genderEvent;
	private String eventStreet;
	private int eventPostalCode;
	private String eventCity;
	private String comments;
	private boolean takePlace;
	private Calendar dateTime;
	private BigInteger eventOwner;
	private int eventId;
	private String telephonNumber;

	public PrivateUserResponse() {
	};

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setLastname(String l) {
		lastname = l;

	}

	public String getLastname() {
		return lastname;
	}

	public void setFirstname(String f) {
		firstname = f;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setCity(String c) {
		city = c;
	}

	public String getCity() {
		return city;
	}

	public void setAge(Calendar a) {
		age = a;
	}

	public Calendar getAge() {
		return age;

	}

	public void setGender(char n) {
		genderUser = n;
	}

	public char getGender() {
		return genderUser;
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

	public void setEventId(int eventId) {
		this.eventId = eventId;
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

	public void setEventOwner(BigInteger eO) {
		eventOwner = eO;
	}

	public BigInteger getEventOwner() {
		return eventOwner;
	}

	public void setGenderEvent(char g) {
		genderEvent = g;
	}

	public char getGenderEvent() {
		return genderEvent;
	}

	public void setTakePlace(boolean b) {
		takePlace = b;
	}

	public boolean getTakePlace() {
		return takePlace;
	}

	public String getTelephoneNumber() {
		return telephonNumber;
	}

	public void setTelephoneNumber(String telephonNumber) {
		this.telephonNumber = telephonNumber;
	}

}