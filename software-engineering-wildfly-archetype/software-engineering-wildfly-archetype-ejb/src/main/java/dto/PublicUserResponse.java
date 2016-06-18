package dto;

public class PublicUserResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private int attendanceStatus;
	private String lastname;
	private String firstname;
	private String city;
	private int age;
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
	private int dateTime;
	private String eventOwner;
	private int eventId;
	private int postalCode;
	private String telephoneNumber;
	private String email;

	public PublicUserResponse() {
	};


	public void setAttendanceStatus(int attendanceStatus) {
		this.attendanceStatus = attendanceStatus;

	}
	
	public int getAttendanceStatus() {
		return attendanceStatus;
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

	public void setAge(int a) {
		age = a;
	}

	public int getAge() {
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

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
