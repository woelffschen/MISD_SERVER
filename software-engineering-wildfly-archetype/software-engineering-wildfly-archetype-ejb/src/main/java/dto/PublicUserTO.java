package dto;

import java.awt.Image;

import dto.DataTransferObject;

public class PublicUserTO extends DataTransferObject {

	private static final long serialVersionUID = 3440740273700082798L;

	private int userId;
	private Image userPic;
	private String lastname;
	private String firstname;
	private String city;
	private int age;
	private char gender;
	private boolean alcDrinks;

	public PublicUserTO() {
	};

	public PublicUserTO(int userId, String ln, String fn, String c, int a, char g, Image u, boolean alc) {

		super();
		this.userId = userId;
		lastname = ln;
		firstname = fn;
		city = c;
		age = a;
		gender = g;
		alcDrinks = alc;
		userPic = u;

	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId(int userId) {
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

	public void setAlcDrinks(boolean a) {
		alcDrinks = a;
	}

	public boolean getAlcDrinks() {
		return alcDrinks;
	}

	public void setUserPic(Image u) {
		userPic = u;
	}

	public Image getUserPic() {
		return userPic;
	}

}