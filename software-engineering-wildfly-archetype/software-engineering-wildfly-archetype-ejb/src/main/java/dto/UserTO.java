/** 
 * @author Sylvia & Daniel
*/

package dto;

public class UserTO extends ReturnCodeResponse {

	private static final long serialVersionUID = 3440740273700082798L;

	private String email;
	private String lastname;
	private String firstname;
	private String street;
	private int postalCode;
	private String city;
	private int age;
	private char gender;
	private String telephoneNumber;

	public UserTO() {
	};

	public UserTO(String email, String ln, String fn, String str, int plz, String c, int a, char g, String tel) {

		super();
		this.email = email;
		lastname = ln;
		firstname = fn;
		street = str;
		postalCode = plz;
		city = c;
		age = a;
		gender = g;
		telephoneNumber = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
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

}
