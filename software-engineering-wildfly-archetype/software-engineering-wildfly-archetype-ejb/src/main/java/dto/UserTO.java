// @Author Sylvia & Daniel

package dto;

import java.math.BigInteger;
import java.util.Calendar;

public class UserTO extends DataTransferObject {

	private static final long serialVersionUID = 3440740273700082798L;

	private BigInteger userId;
	private String lastname;
	private String firstname;
	private String street;
	private int postalCode;
	private String city;
	private Calendar age;
	private char gender;
	private String telephoneNumber;

	public UserTO() {
	};

	public UserTO(BigInteger userId, String ln, String fn, String str, int plz, String c, Calendar a, char g,
			String tel) {

		super();
		this.userId = userId;
		lastname = ln;
		firstname = fn;
		street = str;
		postalCode = plz;
		city = c;
		age = a;
		gender = g;
		telephoneNumber = tel;

	}

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

	public void setStreet(String s) {
		street = s;
	}

	public String getStreet() {
		return street;
	}

	public void setPostalCode(int p) {
		postalCode = p;
	}

	public int getPostalCode() {
		return postalCode;
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
		gender = n;
	}

	public char getGender() {
		return gender;
	}

	public void setTelephoneNumber(String t) {
		telephoneNumber = t;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	// public User getPublicUserData() {
	// return user.getUserId();
	// return lastname;
	// return firstname;
	// return city;
	// return age;
	// return gender;
	// return telephoneNumber;
	// return alcDrinks;
	// return userPic;
	//
	// }
	// strg shift c alles aus oder einkommentieren

}
