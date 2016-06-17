// @Author Sylvia & Daniel

package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Column(nullable = false)
	String lastname;
	@Column(nullable = false)
	String firstname;
	@Column(nullable = true)
	String street;
	@Column(nullable = true)
	int postalCode;
	@Column(nullable = true)
	String city;
	@Column(nullable = false)
	int age;
	@Column(nullable = false)
	char gender;
	@Column(nullable = false)
	String telephoneNumber;
	@Id
	@Column(nullable = false, unique = true)
	String email;
	@OneToOne
	Session session;
	

	@OneToMany(mappedBy = "user")
	private Set<Attendance> attendance;

	public User() {
	};

	public User(String email, String lastname, String firstname, String street, int postalCode, String city,
			int age, char gender, String telephoneNumber) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.age = age;
		this.gender = gender;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public void setGender(char n) {
		gender = n;
	}

	public char getGender() {
		return gender;
	}

	public Set<Attendance> getAttendance() {
		return attendance;
	}
	
	public Session getsSession() {
		return session;

		
	}
	
}
