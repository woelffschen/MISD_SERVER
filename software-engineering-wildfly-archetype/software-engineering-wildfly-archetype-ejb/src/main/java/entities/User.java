// @Author Sylvia & Daniel

package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	int userId;
	@Column(nullable = true)
	byte[] userPic;
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
	@OneToMany(mappedBy="user")
	private Set<Attendance> status;

	public User() {
	};

	public User(String ln, String fn, String str, int plz, String c, int a, String tel, boolean alc, byte[] u, char g) {

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

	public void setUserPic(byte[] u) {
		userPic = u;
	}

	public byte[] getUserPic() {
		return userPic;
	}

	public void setGender(char n) {
		gender = n;
	}

	public char getGender() {
		return gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + gender;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + postalCode;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((telephoneNumber == null) ? 0 : telephoneNumber.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (gender != other.gender)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (postalCode != other.postalCode)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (telephoneNumber == null) {
			if (other.telephoneNumber != null)
				return false;
		} else if (!telephoneNumber.equals(other.telephoneNumber))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	
	
}
