// @Author Sylvia & Daniel

package dto;

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
	private String eventOwner;
	private String comments;
	private int dateTime;
	private String name;
	private boolean lactose;
	private boolean gluten;
	private boolean fructose;
	private boolean sorbit;
	private boolean vega;
	private boolean vegee;

	public EventTO() {
	};

	public EventTO(int eventId, int menueId, int minAge, int maxAge, char gender, String eventStreet, int eventPostalCode, String eventCity,
			String eventOwner, String comments, int dateTime, String name, boolean lactose, boolean gluten,
			boolean fructose, boolean sorbit, boolean vega, boolean vegee) {
		super();
		this.eventId = eventId;
		this.menueId = menueId;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.gender = gender;
		this.eventStreet = eventStreet;
		this.eventPostalCode = eventPostalCode;
		this.eventCity = eventCity;
		this.eventOwner = eventOwner;
		this.comments = comments;
		this.dateTime = dateTime;
		this.name = name;
		this.lactose = lactose;
		this.gluten = gluten;
		this.fructose = fructose;
		this.sorbit = sorbit;
		this.vega = vega;
		this.vegee = vegee;
	}


	public int getMenueId() {
		return menueId;
	}

	public void setMenueId(int menueId) {
		this.menueId = menueId;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEventStreet() {
		return eventStreet;
	}

	public void setEventStreet(String eventStreet) {
		this.eventStreet = eventStreet;
	}
	
	public int getEventPostalCode() {
		return eventPostalCode;
	}

	public void setEventPostalCode(int eventPostalCode) {
		this.eventPostalCode = eventPostalCode;
	}

	public String getEventCity() {
		return eventCity;
	}

	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}

	public String getEventOwner() {
		return eventOwner;
	}

	public void setEventOwner(String eventOwner) {
		this.eventOwner = eventOwner;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getDateTime() {
		return dateTime;
	}

	public void setDateTime(int dateTime) {
		this.dateTime = dateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLactose() {
		return lactose;
	}

	public void setLactose(boolean lactose) {
		this.lactose = lactose;
	}

	public boolean isGluten() {
		return gluten;
	}

	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}

	public boolean isFructose() {
		return fructose;
	}

	public void setFructose(boolean fructose) {
		this.fructose = fructose;
	}

	public boolean isSorbit() {
		return sorbit;
	}

	public void setSorbit(boolean sorbit) {
		this.sorbit = sorbit;
	}

	public boolean isVega() {
		return vega;
	}

	public void setVega(boolean vega) {
		this.vega = vega;
	}

	public boolean isVegee() {
		return vegee;
	}

	public void setVegee(boolean vegee) {
		this.vegee = vegee;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
