package dto;

import java.math.BigInteger;
import java.util.Calendar;

public class PublicUserTO extends DataTransferObject {

	private static final long serialVersionUID = 3440740273700082798L;

	private BigInteger userId;
	private String lastname;
	private String firstname;
	private String city;
	private Calendar age;
	private char gender;


	public PublicUserTO() {
	};

	public PublicUserTO(BigInteger userId, String ln, String fn, String c, Calendar a, char g) {

		super();
		this.userId = userId;
		lastname = ln;
		firstname = fn;
		city = c;
		age = a;
		gender = g;

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




}