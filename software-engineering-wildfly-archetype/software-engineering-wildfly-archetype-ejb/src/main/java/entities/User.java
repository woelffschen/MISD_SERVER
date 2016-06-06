// @Author Sylvia & Daniel

package entities;

import java.awt.Image;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	int userId;
	@Column(nullable = true)
	Image userPic;
	@Column(nullable = false)
	String lastname;
	@Column(nullable = false)
	String firstname;
	@Column(nullable = false)
	String street;
	@Column(nullable = false)
	int postalCode;
	@Column(nullable = false)
	String city;
	@Column(nullable = false)
	int age;
	@Column(nullable = false)
	char gender;
	String telephoneNumber;
	boolean alcDrinks;

	Attendance status;

	public User() {
	};

	public User(String ln, String fn, String str, int plz, String c, int a, String tel, boolean alc, Image u, char g) {

		lastname = ln;
		firstname = fn;
		street = str;
		postalCode = plz;
		city = c;
		age = a;
		telephoneNumber = tel;
		alcDrinks = alc;
		userPic = u;
		gender = g;

	}

	public int getUserId() {
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

	public void setTelephoneNumber(String t) {
		telephoneNumber = t;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
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

	public void setGender(char n) {
		gender = n;
	}

	public char getGender() {
		return gender;
	}

}
