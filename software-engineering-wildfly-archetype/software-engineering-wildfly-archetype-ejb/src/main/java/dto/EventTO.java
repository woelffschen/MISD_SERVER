// @Author Sylvia & Daniel

package dto;

import java.util.Calendar;

public class EventTO extends DataTransferObject {

	private static final long serialVersionUID = 3440740273700082798L;

	private int eventId;
	private int menueId;
	private int minAge;
	private int maxAge;
	private char gender;
	private int eventPostalCode;
	private String eventCity;
	private int eventOwner;
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

	public EventTO(int eventId, int menueId, int min, int max, char g, String street, int plz, String city,
	 String com, int dt, int eO, String n, boolean l, boolean gl, boolean f, boolean s, boolean ve, boolean veg) {

		super();
		this.eventId = eventId;
		this.menueId = menueId;
		minAge = min;
		maxAge = max;
		gender = g;
		eventPostalCode = plz;
		eventCity = city;
		dateTime = dt;
		comments = com;
		eventOwner = eO;
		setName(n);
		setLactose(l);
		setGluten(gl);
		setFructose(f);
		setSorbit(s);
		setVega(ve);
		setVegee(veg);
		

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

	public void setEventDateTime(int i) {
		dateTime = i;
	}

	public int getEventDateTime() {
		return dateTime;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getLactose() {
		return lactose;
	}

	public void setLactose(boolean lactose) {
		this.lactose = lactose;
	}

	public boolean getGluten() {
		return gluten;
	}

	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}

	public boolean getFructose() {
		return fructose;
	}

	public void setFructose(boolean fructose) {
		this.fructose = fructose;
	}

	public boolean getSorbit() {
		return sorbit;
	}

	public void setSorbit(boolean sorbit) {
		this.sorbit = sorbit;
	}

	public boolean getVega() {
		return vega;
	}

	public void setVega(boolean vega) {
		this.vega = vega;
	}

	public boolean getVegee() {
		return vegee;
	}

	public void setVegee(boolean vegee) {
		this.vegee = vegee;
	}

}
