// @Author Sylvia & Daniel

package dto;

import java.math.BigInteger;

public class UserTO extends ReturnCodeResponse {

	private static final long serialVersionUID = 3440740273700082798L;

	private BigInteger userId;
	private String lastname;
	private String firstname;
	private String street;
	private int postalCode;
	private String city;
	private int age;
	private char gender;
	private String telephoneNumber;
	private String email;
	
	public UserTO() {
	};

	public UserTO(String email,BigInteger userId, String ln, String fn, String str, int plz, String c, int a, char g,
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
		this.email = email;

	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setAge(int a) {
		age = a;
	}

	public int getAge() {
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
